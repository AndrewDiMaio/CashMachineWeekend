package rocks.zipcode.atm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneSetter {
    GridPane grid = new GridPane();
    private CashMachine cashMachine;
    AccountScene loginSuccess;
    Scene thisScene;
    Button btnLogin = new Button("Sign In");
    TextField userTextField = new TextField();
    Text scenetitle = new Text("Welcome to CTM");
    Label accountNum = new Label("Account Number:");
    Text actiontarget = new Text();
    ObservableList<String> accountList;

    Stage mainStage;


    Button createAccnt = new Button("Create Account");


    public SceneSetter() {
    }


    public SceneSetter(CashMachine cashMachine) {

        this.cashMachine = cashMachine;
        grid.setStyle("-fx-background-color: Green");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 500, 230));

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(accountNum, 0, 1);
        grid.add(userTextField, 1, 1);


        accountList = FXCollections.observableArrayList();
        for (String i : cashMachine.getAllAccounts()) {
            accountList.add(i);
        }
        ComboBox accountBox = new ComboBox(accountList);
        grid.add(accountBox, 2, 1);
        accountBox.setOnAction(e -> {
            userTextField.setText(accountBox.getSelectionModel().getSelectedItem().toString());
        });


        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnLogin);
        grid.add(hbBtn, 1, 4);


        HBox hbBtn2 = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(createAccnt);
        grid.add(hbBtn2, 1, 5);


        createAccnt.setOnAction(e -> {
            mainStage.close();
            CreateAccountScene callCreateAccountScene = new CreateAccountScene(cashMachine);
            callCreateAccountScene.getCreateScene();

        });


        grid.add(actiontarget, 1, 6);
        btnLogin.setOnAction(e -> {
            int id = Integer.parseInt(userTextField.getText());
            userTextField.setText("");
            cashMachine.login(id);
            if (cashMachine.toString().contains("Try account 1000 or 2000 and click submit.")) {
                actiontarget.setText("Enter A Valid Account");
            } else {
                loginSuccess = new AccountScene(id, cashMachine);
                loginSuccess.getAccountScene(id);
            }
        });
    }


    public void displayMainScene() {
        mainStage = new Stage();
        mainStage.setTitle("Welcome to CTM");
        mainStage.setScene(thisScene);
        mainStage.show();

    }


    public void buttonLogic() {


    }


}