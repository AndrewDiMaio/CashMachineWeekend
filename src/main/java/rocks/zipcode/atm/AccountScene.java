package rocks.zipcode.atm;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rocks.zipcode.atm.bank.Account;

import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import java.io.File;
import java.security.PublicKey;

public class AccountScene {
    GridPane grid = new GridPane();
    private CashMachine cashMachine;
    private Scene thisScene;
    private Button withdrawl = new Button("Withdrawal");
    private Button deposit = new Button("Deposit");
    private Text scenetitle;
    private Text userName;
    private Label nameLabel = new Label("Name:");
    private Stage newStage;
    private Text acctBalance;
    private Label accountBalance = new Label("Account Balance:");
    private Text cusEmail;
    private Label emailAddress = new Label("Email Address:");
    private Button logOut = new Button("Log Out");
    File Giveyouup = new File("src/Resources/NeverGonnaGiveYouUp.mp3");
    AudioClip buttonPress = new AudioClip(Giveyouup.toURI().toString());
    File sayGoodbye = new File("src/Resources/NeverGonnaLetYouDown.mp3");
    AudioClip buttonPress2 = new AudioClip(sayGoodbye.toURI().toString());
    File runAround = new File("src/Resources/NeverGonnaSayGoodbye.mp3");
    AudioClip buttonPress3 = new AudioClip((runAround.toURI().toString()));

    private TextField field = new TextField();


    public AccountScene(int id, CashMachine cashMachine){
        this.cashMachine = cashMachine;
        grid.setStyle("-fx-background-color: Green");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 600, 400));

        scenetitle = new Text("Account Info");
        grid.add(scenetitle, 0, 0, 3, 1);


        cashMachine.login(id);
        userName = new Text(cashMachine.getName());
        grid.add(userName, 1, 1, 1,1);
        grid.add(nameLabel, 0, 1, 1, 1);


        acctBalance = new Text(String.valueOf("$" + cashMachine.getBalance() + "0"));
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
            buttonPress2.play();
            cashMachine.deposit(amount);
            acctBalance.setText(String.valueOf("$" + cashMachine.getBalance() + "0"));
            field.setText("");

        });

        withdrawl.setOnAction(e-> {
                    float amount = Float.parseFloat(field.getText());
                    float previousBalance = cashMachine.getBalance();

                    buttonPress.play();
                    cashMachine.withdraw(amount);
                    acctBalance.setText(String.valueOf("$" + cashMachine.getBalance() + "0"));
                    field.setText("");
                    if (cashMachine.getBalance() <= -1) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Overdraft");
                        alert.setHeaderText("Overdraft Warning");
                        alert.setContentText("The requested action has caused your account balance to go below zero.");
                        alert.showAndWait(); }

                    else if (previousBalance == cashMachine.getBalance()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Withdrawal Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Your account contains insufficient funds.");

                        alert.showAndWait();
                    }
                });

        logOut.setOnAction(e-> {
            buttonPress3.play();
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
