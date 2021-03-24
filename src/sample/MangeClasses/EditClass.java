package sample.MangeClasses;

import DataModels.Administrator;
import DataModels.GymClass;
import DataModels.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;



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
        String _name=name.getText();
        String _description=description.getText();
        String _day=day.getText();
        int _maxNum=Integer.parseInt(maxNum.getText());
        int _startTime=Integer.parseInt(startTime.getText());
        int _endTime=Integer.parseInt(endTime.getText());
        int _trainerId=Integer.parseInt(trainerId.getText());
        if (!Trainer.checkTrainerIsPresent(_trainerId)){
            JOptionPane.showMessageDialog(null, "Trainer ID is incorrect.");
            return;
        }
        if (_maxNum < 0){
            JOptionPane.showMessageDialog(null, "Maximum number must be greater than 0.");
            return;
        }
        if (_endTime < _startTime){
            JOptionPane.showMessageDialog(null, "Start Time must be smaller than End time.");
            return;
        }
        if(!_day.toLowerCase().equals("saturday") && !_day.toLowerCase().equals("sunday") && !_day.toLowerCase().equals("mondy") && !_day.toLowerCase().equals("tuesday") && !_day.toLowerCase().equals("wednesday") && !_day.toLowerCase().equals("thursday"))
        {
            JOptionPane.showMessageDialog(null, "Please enter a correct day.");
            return;
        }

        Administrator.editClass(_name,new GymClass(_name,_description,_day,_maxNum,_startTime,_endTime));
        Administrator.assignTrainerToClass(_name,_trainerId);
        JOptionPane.showMessageDialog(null, "Class has been succesfully edited.");
    }
}
