package sample.MangeClasses;

import DataModels.Administrator;
import DataModels.Class;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.classes;
import static sample.Main.trainers;

public class EditClass implements Initializable {

    @FXML TextField name;
    @FXML TextField trainerId;
    @FXML TextField day;
    @FXML TextField maxNum;
    @FXML TextField startTime;
    @FXML TextField endTime;
    @FXML TextArea description;
    @FXML Button editBtn;

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void editBtnFunc(ActionEvent actionEvent) {
        Administrator.editClass(name.getText(),new Class(name.getText(),description.getText(),day.getText(),Integer.parseInt(maxNum.getText()),Integer.parseInt(startTime.getText()),Integer.parseInt(endTime.getText())),classes);
        Administrator.assignTrainerToClass(name.getText(),Integer.parseInt(trainerId.getText()),trainers,classes);

    }
}
