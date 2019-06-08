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
    AccountScene loginSuccess = new AccountScene();
    Scene thisScene;
    Button btnLogin = new Button("Sign In");
    TextField userTextField = new TextField();
    Text scenetitle = new Text("Welcome");
    Label accountNum = new Label("Account Number:");
    Text actiontarget = new Text();


    public SceneSetter(){

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 500, 230));

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(accountNum, 0, 1);
        grid.add(userTextField, 1, 1);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnLogin);
        grid.add(hbBtn, 1, 4);


    }


    public Scene getScene1() {
       return thisScene;
    }

    public void buttonLogic(){

        grid.add(actiontarget, 1, 6);
        btnLogin.setOnAction(e -> {
            int id = Integer.parseInt(userTextField.getText());
            cashMachine.login(id);
            if (cashMachine.toString().contains("Try account 1000 or 2000 and click submit.")) {
                actiontarget.setText("Enter A Valid Account");
            }
            else {loginSuccess.getAccountScene();}
        });

    }

}
