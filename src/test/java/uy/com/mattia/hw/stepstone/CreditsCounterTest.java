package uy.com.mattia.hw.stepstone;

import org.junit.Test;
import uy.com.mattia.hw.stepstone.model.Company;
import uy.com.mattia.hw.stepstone.model.HttpResponseEntity;
import uy.com.mattia.hw.stepstone.model.User;

import static org.junit.Assert.*;

/**
 * CreditsCounterTest
 *
 * Unit test of CreditsCo   unter class
 *
 * Created by mattia on 11/8/17.
 */
public class CreditsCounterTest {

    private CreditsCounter counter = new CreditsCounter();

    private Company getCompany(int id, int credits, int numUsers, int [] usersCredits) {
        Company c = new Company();

        c.setId(id);
        c.setCredits(credits);

        for (int i = 0; i < numUsers; i++) {
            User u = new User();
            u.setCredits(usersCredits[i]);
            c.getUsers().add(u);
        }

        return c;
    }

    @Test
    public void basicCounting() throws Exception {

        HttpResponseEntity response = new HttpResponseEntity();

        assertEquals("The credits for and empty response must be 0.", 0, counter.count(response));

        response.getData().add(getCompany(1, 30, 1, new int[]{20}));

        assertEquals("The credits with no id specified must be 50.", 50, counter.count(response));
        assertEquals("The credits with the company id must be just 30, excluding users' credits.",
                30, counter.count(response, 1));
        assertEquals("The credits with a wrong company id must be 0.",0,
                counter.count(response, 0));

        response.getData().add(getCompany(2, 40, 0, null));

        assertEquals("The credits with no id specified must be adding of both companies.",
                90, counter.count(response));
        assertEquals("The credits with the company id 2 must be just 40.",
                40, counter.count(response, 2));

        Company c0 = response.getData().get(0);
        c0.getChildren().add(getCompany(3, 100, 2, new int[]{5, 15}));
        assertEquals("Children's credits must be added.",130, counter.count(response, 1));
        assertEquals("Total credits must be increased by 120.", 210, counter.count(response));
    }

    @Test
    public void repeatedIds() throws Exception {

        HttpResponseEntity response = new HttpResponseEntity();

        response.getData().add(getCompany(1, 30, 1, new int[]{20}));
        response.getData().add(getCompany(1, 40, 0, null));

        assertEquals("When a repeated id is passed, it'll consider just the credits of the first " +
                "company founded with such id (BFS search).",30, counter.count(response, 1));
        assertEquals("For total credits ids are ignored.",90, counter.count(response));

        Company c0 = response.getData().get(0);
        c0.getChildren().add(getCompany(1, 100, 2, new int[]{5, 15}));
        assertEquals("Children's credits must be added even if they have the same id.",130,
                counter.count(response, 1));

    }

}