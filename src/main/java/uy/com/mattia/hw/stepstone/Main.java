package uy.com.mattia.hw.stepstone;

import uy.com.mattia.hw.stepstone.model.HttpResponseEntity;

import static org.junit.Assert.assertEquals;

/**
 * Main class
 * Main class of the application, it unmarshalls the json into POJO and then checks the credits counting
 *
 * Created by mattia on 11/7/17.
 */
public class Main {

    public static void main(String[] args) {


        /*Unmarshalling the example json*/
        HttpResponseEntity response =
                new Unmarshaller().unmarshall(Main.class.getResourceAsStream("/json/examples/assignment.json"));

        /*Testing the credit counting*/

        CreditsCounter counter = new CreditsCounter();

        /*Testing the total credits*/
        assertEquals("The credits of all the entities companies are 1220 (users' credits are included)",
                1220, counter.count(response));

        /*Testing for each company in the file passing the id,*/
        assertEquals("The credits for the company (the only root company) with id 57 " +
                        "(users' credits aren't included)",
                1200, counter.count(response, 57));
        assertEquals("The credits for the company with id 1157 (users' credits aren't included)",
                100, counter.count(response, 157));
        assertEquals("The credits for the company with id 1570 (users' credits aren't included)",
                0, counter.count(response, 1570));
        assertEquals("The credits for the company with id 1157 (users' credits aren't included)",
                100, counter.count(response, 1157));

        System.out.println("Succesful execution!");

    }

}
