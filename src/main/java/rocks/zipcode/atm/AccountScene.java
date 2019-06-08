package rocks.zipcode.atm;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import rocks.zipcode.atm.bank.Bank;

import java.security.PublicKey;

public class AccountScene {
    GridPane grid = new GridPane();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Scene thisScene;


    public AccountScene(){

    }

    public Scene getAccountScene(){
        return null;
    }



}
