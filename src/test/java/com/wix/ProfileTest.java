package com.wix;

import com.wix.annotation.SignIn;
import com.wix.model.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.wix.TestTags.SMOKE;

/**
 * Created by alpa on 2019-07-11
 */
@Feature("Profile")
public class ProfileTest extends TestBase {

    @Tags({@Tag("profile"), @Tag(SMOKE)})
    @Test
    @Story("User can edit profile")
    public void userCanEditProfileNameTest(@SignIn User user) {
        String newUserName = "bob2";
        startPage.getMember(user.getName())
                .clickMyProfile()
                .clickEditBtn()
                .inputMemberName(newUserName)
                .clickSave()
                .memberShouldHaveName(newUserName);
    }
}
