package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    public Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Example 1", "example1@gmail.com", 500
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Example 2", "example2@gmail.com", 200
        )));

        accounts.put(9999, new PremiumAccount(new AccountData(
                9999, "Goku", "itsover9000@gmail.com", 9001
        )));

        accounts.put(500, new BasicAccount(new AccountData(
                500, "Mark Hanna", "wallstreetwolf@Matt.com", 7
        )));

        accounts.put(10101, new PremiumAccount(new AccountData(
                10101, "Neo", "TheOne@One.com", 99999)));

        accounts.put(7000, new BasicAccount(new AccountData(7000, "Garfield", "Imsorryjon@theend.com", 600)));


    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1000 or 2000");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());
        }
    }


    public void addAccount(Integer id, String name, String email, Boolean premium) {
        if (name.equalsIgnoreCase("zipcode")) {
            accounts.put(id, new PremiumAccount(new AccountData(
                    id, "Zipcode rocks!", "z1pc0destudent@internet.com", -3000)));
        } else if (premium.equals(true)) {
            accounts.put(id, new PremiumAccount(new AccountData(
                    id, name, email, 0)));
        } else {
            accounts.put(id, new BasicAccount(new AccountData(
                    id, name, email, 0)));
        }



    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
    public List<String> getAllAccounts() {
        List<String> accountNumbers = new ArrayList<>();
        for (Integer accountNumber : accounts.keySet()){
            accountNumbers.add(accountNumber.toString());
        }

        return accountNumbers;
    }
}
