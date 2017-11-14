package uy.com.mattia.hw.stepstone;

import org.junit.Test;
import uy.com.mattia.hw.stepstone.model.Company;
import uy.com.mattia.hw.stepstone.model.HttpResponseEntity;
import uy.com.mattia.hw.stepstone.model.User;

import static org.junit.Assert.*;

/**
 * UnmarshallerTest
 *
 * Checks the correct unmarshalling of the example json.
 *
 * Created by mattia on 11/8/17.
 */
public class UnmarshallerTest {

    @Test
    public void checkingFieldsUnmarshalling() throws Exception {

        HttpResponseEntity response =
                new Unmarshaller().unmarshall(Main.class.getResourceAsStream("/json/examples/assignment.json"));

        /* # */
        assertEquals("#/STATUS", 200, response.getStatus().intValue());
        assertEquals("#/MESSAGE", "", response.getMessage());
        assertTrue(response.getResult());

        /* #/DATA */
        assertNotNull("#/DATA/*", response.getData());
        assertEquals("count(#/DATA/*)", 1, response.getData().size());

        Company root = response.getData().get(0);
        assertEquals("#/DATA/*[1]/CREDITS", 1000, root.getCredits().intValue());
        assertNull("#/DATA/*[1]/PARENT_ID", root.getParentId());
        assertEquals("#/DATA/*[1]/STATUS", "ACTIVE", root.getStatus());
        assertEquals("#/DATA/*[1]/NAME", "Stepstone International", root.getName());
        assertEquals("#/DATA/*[1]/ID", 57, root.getId().intValue());

        /* #/DATA/*[1]/CHILDREN */
        assertNotNull("#/DATA/*[1]/CHILDREN", root.getChildren());
        assertEquals("count(#/DATA/*[1]/CHILDREN/*)", 2, root.getChildren().size());
        assertEquals("#/DATA/*[1]/CHILDREN/*[1]/ID", 157, root.getChildren().get(0).getId().intValue());
        assertEquals("#/DATA/*[1]/CHILDREN/*[2]/ID", 1157, root.getChildren().get(1).getId().intValue());

        /* #/DATA/*[1]/USERS */
        assertNotNull("#/DATA/*[1]/USERS", root.getUsers());
        assertEquals("count(#/DATA/*[1]/USERS/*)", 2, root.getUsers().size());

        /* #/DATA/*[1]/USERS/*[1] */
        User u = root.getUsers().get(0);
        assertEquals("#/DATA/*[1]/USERS/*[1]/CREDITS", 5, u.getCredits().intValue());
        assertEquals("#/DATA/*[1]/USERS/*[1]/STATUS", "ACTIVE", u.getStatus());
        assertEquals("#/DATA/*[1]/USERS/*[1]/NAME", "Jan Kowalski", u.getName());
        assertEquals("#/DATA/*[1]/USERS/*[1]/ID", 77814, u.getId().intValue());

    }

}