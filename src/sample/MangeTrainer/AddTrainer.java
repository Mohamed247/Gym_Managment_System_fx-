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
import javax.swing.*;

public class AddTrainer implements Initializable {

    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField gender;
    @FXML Button addTrainerBtn;


    @FXML
    void addTrainerBtnFunc(ActionEvent actionEvent){
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
        Administrator.addTrainer(new Trainer(_name,_age,_gender));
        JOptionPane.showMessageDialog(null, "Trainer has been succesfully added.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }


}
