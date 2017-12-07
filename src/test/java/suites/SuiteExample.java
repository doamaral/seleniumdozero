package suites;


import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //TODO
        //Incluir os .CLASS das Classes de Teste que compõem a suite
        //ClasseXTest.class,
        //ClasseYTest.class
})
public class SuiteExample {
    @AfterClass
    public static void endDrivers(){
        DriverFactory.killDriver();
    }
}
