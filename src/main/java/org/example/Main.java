package org.example;

import Model.User;
import Model.Company;
import Provider.Provider;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            var userApiUrl = "https://fake-json-api.mock.beeceptor.com/users";
            var companyApiUrl = "https://fake-json-api.mock.beeceptor.com/companies";

            var userProvider = new Provider<>(userApiUrl, User.class);
            var companyProvider = new Provider<>(companyApiUrl, Company.class);

            List<User> users = userProvider.getAll();
            List<Company> companies = companyProvider.getAll();

            printItems("Users", users);
            printItems("Companies", companies);

        } catch (Exception e) {
            System.err.println("Smth went wrong");
        }
    }

    private static<T> void printItems(String title, List<T> items) {
        System.out.println(title);

        if (items == null || items.isEmpty()) {
            System.out.println("No " + title.toLowerCase() + " found.");
            return;
        }

        for (T item : items) {
            System.out.println(item);
        }

        System.out.println();
    }
}
