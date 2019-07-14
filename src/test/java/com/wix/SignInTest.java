package com.wix;

import com.wix.data.UserFactory;
import com.wix.extension.WebDriverExtension;
import com.wix.model.User;
import com.wix.page.WelcomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.wix.TestTags.SMOKE;

/**
 * Created by alpa on 2019-07-11
 */
@Feature("Sign in")
@ExtendWith({WebDriverExtension.class})
public class SignInTest {

    private WelcomePage welcomePage = new WelcomePage();
    private User user = UserFactory.randomUser();

    @Tags({@Tag("signIn"), @Tag(SMOKE)})
    @Test
    @Story("Sign in by email")
    public void signInByEmailTest() {
        welcomePage
                .clickLogIn()
                .openSignInViaEmail()
                .signInViaEmail(user.getEmail(), user.getPassword())
                .userShouldBeLoggedIn();
    }


}
