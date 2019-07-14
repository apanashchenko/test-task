package com.wix;

import com.wix.annotation.Default;
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
@Feature("Search member")
public class SearchTest extends TestBase {

    @Tags({@Tag("search"), @Tag(SMOKE)})
    @Test
    @Story("Search member by name")
    public void searchMemberByName(@Default User user) {
        startPage
                .searchMember(user.getName())
                .getMembersElementsCollection()
                .shouldHaveSize(1);

        startPage.searchedMemberShouldBe(1);
    }
}
