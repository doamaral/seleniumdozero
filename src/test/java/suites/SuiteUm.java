package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.LoginPage;
import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContasTests.class,
        UserTests.class,
        MovimentacaoTests.class,
        ResumoTests.class
})
public class SuiteUm {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void resetaBase(){
        page.acccessLoginPage()
                .loginUser("asdf@gmail.com","123456")
                .selectResetHiddenLink();
        System.out.println("CENÁRIOS RESETADOS!!!");
    }
}
