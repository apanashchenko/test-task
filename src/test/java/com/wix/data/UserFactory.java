package com.wix.data;

import com.github.javafaker.Faker;
import com.wix.model.User;

import java.util.Locale;

/**
 * Created by alpa on 2019-07-12
 */
public class UserFactory {

    private static final String DEFAULT_PASSWORD = "123456";

    public static User defaultUser() {
        return create("unclebob@email.com", DEFAULT_PASSWORD, "unclebob");
    }

    public static User randomUser() {
        Faker faker = new Faker(new Locale("us-US"));
        String name = faker.name().firstName();
        String email = name.replaceAll(" ", "").toLowerCase() + "@email.com";
        return create(email, DEFAULT_PASSWORD, name);
    }

    private static User create(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

}
