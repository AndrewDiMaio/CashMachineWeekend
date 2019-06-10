package rocks.zipcode.atm;


import javafx.scene.image.Image;
import javafx.scene.layout.*;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {


    SceneSetter callScene = new SceneSetter();
    private TextField field = new TextField();

    public CashMachine cashMachine = new CashMachine(new Bank());

    Scene2 callScene2 = new Scene2();

    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Set Account ID");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });
//        File presidentAstley = new File("src/Resources/president-astley.jpg");
//            BackgroundImage myBI = new BackgroundImage(new Image("presidentAstley", 32,32,false,true),
//            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//            BackgroundSize.DEFAULT);

        FlowPane flowpane = new FlowPane();
//        flowpane.setStyle("-fx-background-image: \"src/Resources/president-astley.jpg\" ");


        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;


    }




    @Override
    public void start(Stage stage) throws Exception {



//        callScene2 = new Scene2();
//
//        stage.setTitle("Create Account");
//        stage.setScene(callScene2.getScene2());
//
//        stage.show();

        stage.setTitle("Welcome To CTM");
        stage.setScene(callScene.getScene1());

        stage.show();



    }


    public CashMachine getCashMachine() {
        return cashMachine;
    }





    public static void main(String[] args) {
        launch(args);
    }
}
