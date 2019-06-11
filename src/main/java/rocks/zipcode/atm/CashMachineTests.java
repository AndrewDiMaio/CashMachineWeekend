package rocks.zipcode.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcode.atm.ActionResult;
import rocks.zipcode.atm.CashMachine;
import rocks.zipcode.atm.bank.Bank;


public class CashMachineTests {
    private CashMachine thisCashMachine;
    private Bank thisBank;

    @Before
    public void setUp(){
        thisBank = new Bank();
        thisCashMachine = new CashMachine(thisBank);
        thisCashMachine.login(1000);
    }


    @Test
    public void depositTest() {
        thisCashMachine.deposit(100.0f);
        Float expected = 600.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void depositTest2() {
        thisCashMachine.deposit(-100.0f);
        Float expected = 500.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void withdrawTest() {
        thisCashMachine.withdraw(100.0f);
        Float expected = 400.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdrawTest2() {
        thisCashMachine.withdraw(-100.0f);
        Float expected = 500.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdrawTest3() {
        thisCashMachine.login(2000);
        thisCashMachine.withdraw(300.0f);
        Float expected = -100.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void withdrawTest4() {
        thisCashMachine.withdraw(10000.0f);
        Float expected = 500.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void login() {
        thisCashMachine.login(9999);
        String expected = "Goku";
        String actual = thisCashMachine.getName();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void exit() {
        String expected = "Try account 1000 or 2000 and click submit.";
        thisCashMachine.exit();
        String actual = thisCashMachine.toString();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getName() {
        String expected = "Example 1";
        String actual = thisCashMachine.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalance() {
        Float expected = 500.0f;
        Float actual = thisCashMachine.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmail() {
        String expected = "Example 1";
        String actual = thisCashMachine.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAccounts() {
    }

    @Test
    public void getBank() {
        Bank expected = thisBank;
        Bank actual = thisCashMachine.getBank();
        Assert.assertEquals(expected, actual);
    }
}
