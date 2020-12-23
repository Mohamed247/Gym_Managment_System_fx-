package sample.MangeTrainer;

import DataModels.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.*;

public class DeleteTrainer implements Initializable {

    @FXML TextField id;
    @FXML Button deleteBtn;

    @FXML
    public void deleteTrainerBtnFunc(ActionEvent actionEvent) {
        Administrator.removeTrainer(Integer.parseInt(id.getText()),trainers,members,classes);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
