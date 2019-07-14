package com.wix;

import com.wix.annotation.SignIn;
import com.wix.data.ReportReason;
import com.wix.data.UserFactory;
import com.wix.model.User;
import com.wix.page.MemberBox;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.wix.TestTags.SMOKE;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by alpa on 2019-07-11
 */
@Feature("Member functionality")
public class MemberTest extends TestBase {

    @Tags({@Tag("member"), @Tag(SMOKE)})
    @Test
    @Story("Member can leave community")
    public void memberCanLeaveCommunityTest(@SignIn User user) {
        MemberBox member = startPage.getMember(user.getName());
        member
                .openMoreActions()
                .selectLeaveCommunity()
                .clickConfirm();
        assertThat(startPage.isMemberPresent(user.getName())).isFalse();
    }

    @Tags({@Tag("member"), @Tag(SMOKE)})
    @Test
    @Story("Member can send report")
    public void memberCanSendReportForOtherMemberTest(@SignIn User user) {
        MemberBox member = startPage.getMember(UserFactory.defaultUser().getName());
        member
                .openMoreActions()
                .selectReportMember()
                .selectReason(ReportReason.OFFENCIVE_CONTENT)
                .clickReport();

        member.moreActionsShouldBeAbsent();
    }
}
