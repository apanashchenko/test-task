package com.wix;

import com.wix.annotation.Default;
import com.wix.data.UserFactory;
import com.wix.model.User;
import com.wix.page.MemberBox;
import com.wix.rest.api.RestApiHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.wix.TestTags.SMOKE;

/**
 * Created by alpa on 2019-07-12
 */
@Feature("Follow/UnFollow")
public class FollowTest extends TestBase {

    private RestApiHelper restApiHelper = new RestApiHelper();
    private User newUser = UserFactory.randomUser();

    @BeforeEach
    public void registerNewUser() {
        restApiHelper.registerUserByEmail(newUser.getEmail(), newUser.getPassword());
    }

    @Tags({@Tag("follow"), @Tag(SMOKE)})
    @Test
    @Story("Follow and unfollow to user")
    public void followAndUnFollowTest(@Default User user) {
        MemberBox followerUser = startPage.followToUser(newUser.getName()).findMemberBox(user.getName());
        followerUser.shouldHaveFollowing(1);

        MemberBox followingUser = startPage.findMemberBox(newUser.getName());
        followingUser.shouldHaveFollowers(1);

        followerUser = startPage.unFollowToUser(newUser.getName()).findMemberBox(user.getName());
        followerUser.shouldHaveFollowing(0);

        followingUser = startPage.findMemberBox(newUser.getName());
        followingUser.shouldHaveFollowers(0);
    }


}
