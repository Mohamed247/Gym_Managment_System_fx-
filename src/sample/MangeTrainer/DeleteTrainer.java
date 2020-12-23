package sample.MangeTrainer;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteTrainer implements Initializable {

    public TextField deleteBt;

    public void deleteTrainerBtnFunc(ActionEvent actionEvent) {
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
