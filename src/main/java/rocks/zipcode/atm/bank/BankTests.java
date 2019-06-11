package rocks.zipcode.atm.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcode.atm.ActionResult;
import rocks.zipcode.atm.CashMachine;

public class BankTests {

    private Bank thisBank;
    private CashMachine thisCashMachine;


    @Before
    public void setUp(){
        thisBank = new Bank();
        thisCashMachine = new CashMachine(thisBank);
    }


    @Test
    public void addAccount() {
        thisBank.addAccount(1337, "Test Example", "exampleTest@gmail.com", true);
        Integer expectedSize = 7;
        Integer actualSize = thisBank.getAccounts().size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getAccounts() {
        Integer expectedSize = 6;
        Integer actualSize = thisBank.getAccounts().size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getAllAccounts() {
        Integer expectedSize = 6;
        Integer actualSize = thisBank.getAllAccounts().size();
        Assert.assertEquals(expectedSize, actualSize);
    }
}
