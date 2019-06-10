package rocks.zipcode.atm;


import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    public CashMachine cashMachine = new CashMachine(new Bank());

    SceneSetter callScene = new SceneSetter(cashMachine);


    @Override
    public void start(Stage stage) throws Exception {

        callScene.displayMainScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
