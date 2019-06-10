package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene2 extends SceneSetter{
    GridPane grid = new GridPane();



    Stage newStage;

    //Bank thisBank;
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


    Button exitButton = new Button("Exit");


    //public CashMachine thisCashMachine;


    public Scene2(CashMachine thisCashMachine){
        //this.thisCashMachine = thisCashMachine;
        //thisBank = thisCashMachine.getBank();
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

        HBox exitBtn = new HBox(10);
        exitBtn.setAlignment(Pos.BOTTOM_LEFT);
        exitBtn.getChildren().addAll(exitButton);
        grid.add(exitButton, 5, 10);


        exitButton.setOnAction(e -> {
            newStage.close();
        });



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

            if (name.equals("")){
                name = "Anonymous";
                email = "n/a";
            }


            while (true) {
                idInt = (int) (Math.random() * 10000);
                if (!thisCashMachine.getBank().accounts.containsKey(idInt)) {
                    break;
                }
            }

            id = idInt;

            if(premium.equalsIgnoreCase("premium")){
                premiumBoul = true;
            } else {
                premiumBoul = false;
            }


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome to CTM");
            alert.setHeaderText(null);
            alert.setContentText("Welcome, " + name + "! Thank you for choosing CTM. Your account number is " + id + ".");

            alert.showAndWait();
            newStage.close();


            thisCashMachine.getBank().addAccount(id, name, email, premiumBoul);
            System.out.println(thisCashMachine.getBank().getAccounts());
            System.out.println(thisCashMachine.getBank().getAllAccounts());

            thisCashMachine.login(id);

            SceneSetter callScene = new SceneSetter(thisCashMachine);
            callScene.displayMainScene();
        });

    }


    public void getCreateScene(){
        newStage = new Stage();
        newStage.setTitle("Account ");
        newStage.setScene(thisScene);
        newStage.show();

    }



    public void buttonLogic(){



    }
}
