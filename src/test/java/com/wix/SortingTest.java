package com.wix;

import com.wix.annotation.Default;
import com.wix.data.MemberType;
import com.wix.data.SortingType;
import com.wix.model.User;
import com.wix.page.MemberBox;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.wix.TestTags.SMOKE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 2019-07-11
 */
@Feature("Sorting member")
public class SortingTest extends TestBase {

    static Stream<Arguments> provideMembersBySpecificCondition() {
        return Stream.of(
                Arguments.of(MemberType.ALL_MEMBERS, 8),
                Arguments.of(MemberType.ADMINS, 2),
                Arguments.of(MemberType.MODERATORS, 0)
        );
    }

    @Tags({@Tag("sort"), @Tag(SMOKE)})
    @ParameterizedTest
    @EnumSource(SortingType.class)
    @Story("Sorting member by their type")
    public void sortingMembersByTheirType(SortingType sortingType, @Default User user) {
        LinkedList<MemberBox> membersBeforeSorting = (LinkedList<MemberBox>) startPage.getMembers();
        startPage.selectSortBy(sortingType);
        LinkedList<MemberBox> membersAfterSorting = (LinkedList<MemberBox>) startPage.getMembers();
        assertThat(membersAfterSorting).as("Sorting by type was not applied!").isNotEqualTo(membersBeforeSorting);
    }

    @Tags({@Tag("sort"), @Tag(SMOKE)})
    @ParameterizedTest
    @MethodSource("provideMembersBySpecificCondition")
    @Story("Sorting member by specific condition")
    public void sortingMembersBySpecificCondition(MemberType sortingType, int expectedSize, @Default User user) {
        startPage
                .selectMemberSorting(sortingType)
                .getMembersElementsCollection()
                .shouldHave(sizeGreaterThanOrEqual(expectedSize).because("Sorting by condition was not applied!"));
    }



}
