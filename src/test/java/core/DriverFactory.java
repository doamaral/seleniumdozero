package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    //private static WebDriver navegador;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){

    }
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    public static WebDriver initDriver(){
        WebDriver navegador = null;
        switch (Properties.BROWSER) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\geckodriver.exe");
                navegador = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver.exe");
                navegador = new ChromeDriver();
                break;
        }
        return navegador;
    }

    public static void killDriver(){
        WebDriver navegador = getDriver();
        if(navegador != null) {
            navegador.quit();
            navegador = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }
}
