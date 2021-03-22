package sample.MangeTrainer;

import DataModels.Administrator;
import DataModels.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class EditTrainer implements Initializable {

    @FXML TextField id;
    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField gender;

    @FXML
    public void editTrainerFunc(ActionEvent actionEvent) {
        Administrator.editTrainer( Integer.parseInt(id.getText()),new Trainer(name.getText(),Integer.parseInt(age.getText()),gender.getText()));
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
