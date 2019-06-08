package rocks.zipcode.atm;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rocks.zipcode.atm.bank.Account;

import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import java.security.PublicKey;

public class AccountScene {
    GridPane grid = new GridPane();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Scene thisScene;
    Button withdrawl = new Button("Withdrawal");
    Button deposit = new Button("Deposit");
    Text scenetitle;
    Text userName;
    Label nameLabel = new Label("Name:");
    Stage newStage;
    Text acctBalance;
    Label accountBalance = new Label("Account Balance:");
    Text cusEmail;
    Label emailAddress = new Label("Email Address:");
    Button logOut = new Button("Log Out");


    private TextField field = new TextField();


    public AccountScene(int id){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 500, 400));

        scenetitle = new Text("Account Info");
        grid.add(scenetitle, 0, 0, 3, 1);


        cashMachine.login(id);
        userName = new Text(cashMachine.getName());
        grid.add(userName, 1, 1, 1,1);
        grid.add(nameLabel, 0, 1, 1, 1);


        acctBalance = new Text(String.valueOf(cashMachine.getBalance()));
        grid.add(acctBalance, 1, 2, 1, 1);
        grid.add(accountBalance, 0,2, 1, 1);

        cusEmail = new Text(cashMachine.getEmail());
        grid.add(cusEmail, 1, 3, 1, 1);
        grid.add(emailAddress, 0, 3, 1, 1);

        grid.add(field, 0, 4, 3, 1);
        grid.add(withdrawl, 3, 5, 1, 1 );
        grid.add(deposit, 0, 5, 1, 1);

        grid.add(logOut, 2, 6, 3,1);


        deposit.setOnAction(e-> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);
            acctBalance.setText(String.valueOf(cashMachine.getBalance()));
        });

        withdrawl.setOnAction(e-> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);
            acctBalance.setText(String.valueOf(cashMachine.getBalance()));
        });

        logOut.setOnAction(e-> {
            newStage.close();
        });



    }

    public void getAccountScene(int id){
        newStage = new Stage();
        newStage.setTitle("Account " + id);
        newStage.setScene(thisScene);
        newStage.show();

    }



}
