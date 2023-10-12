package testcases;

import org.base.baseTest;
import org.pages.homepage;
import org.pages.loginpage;
import org.testng.annotations.Test;
import org.util.controlmethods;

public class test2 extends baseTest {
    controlmethods cr = new controlmethods();
    loginpage lp = new loginpage();
    homepage hp = new homepage();

    @Test
    public void signWithLockedoutUser(){
        lp.lockedoutsignin();

    }
}
