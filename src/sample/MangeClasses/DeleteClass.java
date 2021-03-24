package sample.MangeClasses;

import DataModels.Administrator;
import DataModels.GymClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


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
        String _name=name.getText();
        if (!GymClass.checkClassIsPresent(_name)){
            JOptionPane.showMessageDialog(null, "Gym class is not present, please enter another one.");
            return;
        }
        Administrator.removeClass(_name);
        JOptionPane.showMessageDialog(null, "Class has been succesfully deleted.");
    }
}
