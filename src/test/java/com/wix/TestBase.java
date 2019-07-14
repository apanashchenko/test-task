package com.wix;

import com.wix.extension.UserParameterResolver;
import com.wix.extension.WebDriverExtension;
import com.wix.page.StartPage;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by alpa on 2019-07-11
 */
@ExtendWith({WebDriverExtension.class, UserParameterResolver.class})
public abstract class TestBase {

    protected StartPage startPage = new StartPage();

}
