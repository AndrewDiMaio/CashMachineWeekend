package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import rocks.zipcode.atm.bank.*;

import java.util.InputMismatchException;
import java.util.Map;

public class Scene2 extends SceneSetter{
    GridPane grid = new GridPane();
    public CashMachine cashMachine = new CashMachine(new Bank());


    Bank thisBank = new Bank();
    AccountScene loginSuccess;
    Scene thisScene;

    Button createButton = new Button("Create Account");
    Text scenetitle = new Text("CTM Account Creation");

    Label accountNum = new Label("Choose an Account Number:");
    TextField accountTextField = new TextField();

    Label nameField = new Label("Enter your name:");
    TextField nameTextField = new TextField();

    Label emailField = new Label("Enter your email address:");
    TextField emailTextField = new TextField();

    Label premiumField = new Label("Basic or Premium?");
    TextField premiumTextField = new TextField();





    public Scene2(){

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.thisScene = (new Scene(grid, 500, 500));

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        grid.add(nameField, 0, 2);
        grid.add(nameTextField, 1, 2);

        grid.add(emailField, 0, 3);
        grid.add(emailTextField, 1, 3);

        grid.add(premiumField, 0, 4);
        grid.add(premiumTextField, 1, 4);



        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(createButton);
        grid.add(hbBtn, 1, 10);


        grid.add(actiontarget, 1, 6);
        createButton.setOnAction(e -> {

            Integer id = 1337;
            Integer idInt;
            String name = "";
            String email = "";
            String premium = "";
            Boolean premiumBoul = false;



            name = nameTextField.getText();
            email = emailTextField.getText();
            premium = premiumField.getText();




            while (true) {
                idInt = (int) (Math.random() * 10000);
                if (!thisBank.accounts.containsKey(idInt)) {
                    break;
                }
            }

            id = idInt;

            if(premium.equalsIgnoreCase("premium")){
                premiumBoul = true;
            } else {
                premiumBoul = false;
            }

            actiontarget.setText("Welcome, " + name + "! Your account number is " + id + ".");
            thisBank.addAccount(id, name, email, premiumBoul);
            System.out.println(thisBank.getAccounts());
            this.cashMachine = new CashMachine(thisBank);
            cashMachine.login(id);
        });

    }


    public Scene getScene2() {
        return thisScene;
    }

    public void buttonLogic(){



    }
}
