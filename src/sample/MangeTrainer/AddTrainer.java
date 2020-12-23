package sample.MangeTrainer;

import DataModels.Administrator;
import DataModels.Trainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import java.net.URL;
import java.util.ResourceBundle;
import static sample.Main.trainers;

public class AddTrainer implements Initializable {

    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField gender;
    @FXML Button addTrainerBtn;

    @FXML
    void addTrainerBtnFunc(ActionEvent actionEvent){
        Administrator.addTrainer(new Trainer(name.getText(),Integer.parseInt(age.getText()),gender.getText()),trainers);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }


}
