package rocks.zipcode.atm;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import rocks.zipcode.atm.bank.Account;

import rocks.zipcode.atm.bank.Bank;

import java.security.PublicKey;

public class AccountScene {
    GridPane grid = new GridPane();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Scene thisScene;
    Button btnLogin = new Button("Sign In");
    TextField userTextField = new TextField();
    Text scenetitle; =
    Label accountNum = new Label("Account Number:");
    Text actiontarget = new Text();



    public AccountScene(int id){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 500, 800));

        scenetitle = new Text("Account" + id);
        grid.add(scenetitle, 0, 0, 2, 1);







    }

    public Scene getAccountScene(){
        return thisScene;
    }



}
