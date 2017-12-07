package core;

import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

import static core.DriverFactory.getDriver;

public class BaseTest {
    @Before
    public void setUp(){
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().get("https://srbarriga.herokuapp.com/login");
    }
    @After
    public void tearDown(){
        if(Properties.FECHAR_BROWSER) DriverFactory.killDriver();
    }
}

