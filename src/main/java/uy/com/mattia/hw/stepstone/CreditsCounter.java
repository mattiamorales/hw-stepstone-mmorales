package uy.com.mattia.hw.stepstone;

import uy.com.mattia.hw.stepstone.model.Company;
import uy.com.mattia.hw.stepstone.model.HttpResponseEntity;
import uy.com.mattia.hw.stepstone.model.User;

import java.util.LinkedList;

/**
 * CreditsCounter
 *
 * Class that offers the methods for counting credits according with the criteria asked and detailed below.
 *
 * From HW text:
 * B) Write two methods for:
 *      1. Counting the total number of credits that the root company has access to, provided that:
 *          - The root company can make use of all credits assigned to it, to its sub-companies, and to all
 *          users within the company hierarchy
 *      2. When a Company ID is provided as an input, calculate the number of credits the company has access to,
 *      provided that:
 *          - The company can use its own credits and all credits assigned to its sub-companies
 *          - The company cannot use any of the users’ credits within its hierarchy
 *
 * Created by mattia on 11/8/17.
 */

public class CreditsCounter {

    /***
     * Method 1: Counting the total number of credits that the root company has access to, provided that
     * the root companies can make use of all credits assigned to it, to its sub-companies, and to all
     * users within the company hierarchy
     * @param response The http response entity to analyze
     * @return The total amount of credits for all the companies in HttpResponse.
     */
    public int count(HttpResponseEntity response) {

        if (response == null || response.getData() == null){
            return 0;
        } else {

            int credits = 0;

            for (Company c : response.getData()){
                credits += count(c, true);
            }

            return credits;

        }

    }

    /**
     * Method 2: When a Company ID is provided as an input, calculate the number of credits the company
     * has access to, provided that the company can use its own credits and all credits assigned to its
     * sub-companies but the company cannot use any of the users’ credits within its hierarchy
     * @param response The http response entity to analyze
     * @param id The company id to consider
     * @return The credits of the company according the criteria (excluding users' credits)
     */
    public int count(HttpResponseEntity response, int id) {
        if (response == null || response.getData() == null){
            return 0;
        } else {

            Company it = null;

            LinkedList<Company> companies = new LinkedList<>();
            companies.addAll(response.getData());

            while (!companies.isEmpty()) {
                it = companies.pop();

                if (it.getId() == id){
                    break;
                } else {
                    companies.addAll(it.getChildren());
                }

            }

            if (it == null || it.getId() != id) {
                /*The company was not founded*/
                return 0;
            } else {
                return count(it, false);
            }

        }
    }

    /* It calculates the credits of the given company and alll its children hierarchy,
    considering users' credits just if boolean flag 'withUsersCredits' is on.*/
    private int count(Company company, boolean withUsersCredits) {

        if (company == null) {
            return 0;
        }

         /* An iterative solution is preferred, instead of a recursive one, in order
         to avoid the lacking of tail recursion optimization.*/
        int credits = 0;
        Company it;
        LinkedList<Company> companies = new LinkedList<>();
        companies.add(company);

        do {

            it = companies.pop();

            credits += it.getCredits();

            // Adding users' credits
            if (withUsersCredits) {

                for (User u : it.getUsers()) {
                    credits += u.getCredits();
                }

            }

            // Adding children credits
            companies.addAll(it.getChildren());

        } while(!companies.isEmpty());

        return credits;

    }

}
