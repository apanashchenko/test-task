package com.wix.extension;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.wix.annotation.Default;
import com.wix.annotation.SignIn;
import com.wix.data.UserFactory;
import com.wix.model.ServerResponse;
import com.wix.model.User;
import com.wix.page.StartPage;
import com.wix.rest.api.RestApiHelper;
import com.wix.rest.api.RestUtils;
import okhttp3.Headers;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.support.AnnotationSupport;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.Set;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by alpa on 2019-07-12
 */
public class UserParameterResolver implements ParameterResolver {

    private RestApiHelper restApiHelper = new RestApiHelper();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Default aDefault = AnnotationSupport.findAnnotation(parameterContext.getParameter(), Default.class).orElse(null);
        SignIn signIn = AnnotationSupport.findAnnotation(parameterContext.getParameter(), SignIn.class).orElse(null);
        if (aDefault != null) {
            return parameterContext.getParameter().getType().equals(User.class);
        }
        if (signIn != null) {
            return parameterContext.getParameter().getType().equals(User.class);
        }
        return false;
    }

    @Override
    public User resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Default aDefault = AnnotationSupport.findAnnotation(parameterContext.getParameter(), Default.class).orElse(null);
        SignIn signIn = AnnotationSupport.findAnnotation(parameterContext.getParameter(), SignIn.class).orElse(null);

        if (aDefault != null) {
            User user = UserFactory.defaultUser();
            loginToApp(user);
            return user;
        } else if (signIn != null) {
            User user = UserFactory.randomUser();
            registerUserAndLoginToApp(user);
            return user;
        }

        return null;
    }

    private void loginToApp(User user) {
        ServerResponse serverResponse = restApiHelper.login(user.getEmail(), user.getPassword());
        Headers headers = restApiHelper.getHeaders();

        Set<Cookie> authorizationCookies = RestUtils.getAuthorizationCookies(headers, serverResponse);

        setCookiesAndLogin(authorizationCookies);
    }

    private void registerUserAndLoginToApp(User user) {
        ServerResponse serverResponse = restApiHelper.registerUserByEmail(user.getEmail(), user.getPassword());
        Headers headers = restApiHelper.getHeaders();

        Set<Cookie> authorizationCookies = RestUtils.getAuthorizationCookies(headers, serverResponse);

        setCookiesAndLogin(authorizationCookies);
    }

    private void setCookiesAndLogin(Set<Cookie> authorizationCookies) {
        WebDriver.Options manage = WebDriverRunner.getWebDriver().manage();
        authorizationCookies.forEach(manage::addCookie);

        Selenide.refresh();

        new StartPage().userShouldBeLoggedIn();
    }

}
