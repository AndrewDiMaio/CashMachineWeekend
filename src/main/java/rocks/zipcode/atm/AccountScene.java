package rocks.zipcode.atm;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rocks.zipcode.atm.bank.Account;

import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import javafx.scene.media.AudioClip;
import java.io.File;
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
    File Giveyouup = new File("src/Resources/Giveyouup.mp3");
    AudioClip buttonPress = new AudioClip(Giveyouup.toURI().toString());
    File sayGoodbye = new File("src/Resources/SayGoodbye.mp3");
    AudioClip buttonPress2 = new AudioClip(sayGoodbye.toURI().toString());
    File runAround = new File("src/Resources/runaround.mp3");
    AudioClip buttonPress3 = new AudioClip((runAround.toURI().toString()));
    //File presidentAstley = new File("src/Resources/president-astley.jpg");
//    BackgroundImage myBI = new BackgroundImage(new Image("presidentAstley", 32,32,false,true),
//            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//            BackgroundSize.DEFAULT);

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
            buttonPress.play();
            cashMachine.deposit(amount);
            acctBalance.setText(String.valueOf(cashMachine.getBalance()));
            field.setText("");

        });

        withdrawl.setOnAction(e-> {
                    float amount = Float.parseFloat(field.getText());
                    buttonPress2.play();
                    cashMachine.withdraw(amount);
                    acctBalance.setText(String.valueOf(cashMachine.getBalance()));
                    field.setText("");
                    if (cashMachine.getBalance() <= -1) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Overdraft");
                        alert.setHeaderText("Overdraft Warning");
                        alert.setContentText("The requested action has caused your account balance to go below zero.");
                        alert.showAndWait(); }

                    else if (cashMachine.getBalance() == cashMachine.getBalance()){
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
