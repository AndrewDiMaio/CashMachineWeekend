package rocks.zipcode.atm;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import rocks.zipcode.atm.bank.Bank;

public class SceneSetter {
    GridPane grid = new GridPane();
    private CashMachine cashMachine = new CashMachine(new Bank());


    public Scene setScene1() {

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene loginScene1 = (new Scene(grid, 500, 230));

        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label accountNum = new Label("Account Number:");
        grid.add(accountNum, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);


        Button btnLogin = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnLogin);
        grid.add(hbBtn, 1, 4);
        btnLogin.setOnAction(e -> {
            int id = Integer.parseInt(userTextField.getText());
            cashMachine.login(id);
            if (cashMachine.toString().contains("Try account 1000 or 2000 and click submit.")) {
                actiontarget.setText("Please Enter A Valid Account Number");
            }


        });
        return loginScene1;
    }

}
