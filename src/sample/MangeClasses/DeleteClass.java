package sample.MangeClasses;

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

public class DeleteClass implements Initializable {

    @FXML TextField name;
    @FXML Button deleteBtn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    @FXML
    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    public void deleteBtnFunc(ActionEvent actionEvent) {
        Administrator.removeClass(name.getText(),trainers,members,classes);
    }
}
