package testcases;

import org.base.baseTest;
import org.pages.cartpage;
import org.pages.homepage;
import org.pages.loginpage;
import org.testng.annotations.Test;
import org.util.controlmethods;

public class test4 extends baseTest {
    controlmethods cr = new controlmethods();
    loginpage lp = new loginpage();
    homepage hp = new homepage();
    cartpage cp = new cartpage();

    @Test
    public void signinErrorUser(){
     lp.errorusersignin();
     hp.removeProductFromCart();
        cp.buyProductError();

    }

}
