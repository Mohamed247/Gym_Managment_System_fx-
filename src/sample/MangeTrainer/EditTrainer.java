package sample.MangeTrainer;

import DataModels.Administrator;
import DataModels.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditTrainer implements Initializable {

    @FXML TextField id;
    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField gender;

    @FXML
    public void editTrainerFunc(ActionEvent actionEvent) {
        int _id=Integer.parseInt(id.getText());
        String _name = name.getText();
        int _age = Integer.parseInt(age.getText());
        String _gender = gender.getText();
        if (_age < 0){
            JOptionPane.showMessageDialog(null, "Age must be greater than 0.");
            return;
        }
        if (!_gender.toLowerCase().equals("male") && !_gender.toLowerCase().equals("female")){
            JOptionPane.showMessageDialog(null, "Gender is either male or female.");
            return;
        }
        if (!Trainer.checkTrainerIsPresent(_id)){
            JOptionPane.showMessageDialog(null, "Trainer not found. Incorrect trainer ID.");
            return;
        }
        Administrator.editTrainer( _id,new Trainer(_name,_age,_gender));
        JOptionPane.showMessageDialog(null, "Trainer has been succesfully edited.");
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
