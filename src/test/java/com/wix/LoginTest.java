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
@Feature("Login to app")
@ExtendWith({WebDriverExtension.class})
public class LoginTest {

    private WelcomePage welcomePage = new WelcomePage();
    private User user = UserFactory.defaultUser();

    @Tags({@Tag("login"), @Tag(SMOKE)})
    @Test
    @Story("Login to app as exist user")
    public void loginTest() {
        welcomePage
                .clickLogIn()
                .openLoginDialog()
                .clickLogInViaEmailBtn()
                .login(user.getEmail(), user.getPassword())
                .userShouldBeLoggedIn();
    }
}
