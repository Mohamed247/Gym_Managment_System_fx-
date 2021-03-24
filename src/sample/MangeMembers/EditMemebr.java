package sample.MangeMembers;

import DataModels.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class EditMemebr implements Initializable {

    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField mobNum;
    @FXML TextField gender;
    @FXML TextField trainerid;
    @FXML TextField ID;
    @FXML TextField classtype;
    @FXML TextField memShipType;
    @FXML TextField day;
    @FXML TextField month;
    @FXML TextField year;
    @FXML Button editBtn;
    @FXML Button backBtn;


    public void editMemberFunc(ActionEvent actionEvent) {

        int _age = Integer.parseInt(age.getText());
        String _mobNum = mobNum.getText();
        String _name = name.getText();
        String _gender = gender.getText();
        String _memShipType = memShipType.getText();
        Time _time = new Time(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
        int _trainerId = Integer.parseInt(trainerid.getText());
        String _classType = classtype.getText();
        ArrayList<String> _classesTypes = new ArrayList<String>(Arrays.asList(_classType.split(" ")));
        int _id = Integer.parseInt(ID.getText());

        if (_age < 0){
            JOptionPane.showMessageDialog(null, "Age must be greater than 0.");
            return;
        }
        if (_mobNum.length() != 11){
            JOptionPane.showMessageDialog(null, "Mobile number length must be 11 numbers.");
            return;
        }
        if (!_gender.toLowerCase().equals("male") && !_gender.toLowerCase().equals("female")){
            JOptionPane.showMessageDialog(null, "Gender is either male or female.");
            return;
        }
        if (!_memShipType.toLowerCase().equals("payg") && !_memShipType.toLowerCase().equals("term") && !_memShipType.toLowerCase().equals("open")){
            JOptionPane.showMessageDialog(null, "Membership type must either be Term, PAYG or Open.");
            return;
        }
        if (!Trainer.checkTrainerIsPresent(_trainerId)){
            JOptionPane.showMessageDialog(null, "Trainer not found. Incorrect trainer ID.");
            return;
        }
        for (String classTypeTemp: _classesTypes){
            if (!GymClass.checkClassIsPresent(classTypeTemp) && classTypeTemp.length() != 0){
                JOptionPane.showMessageDialog(null, "Gym class is not present, please choose another one.");
                return;
            }
        }

        if (!Member.checkMemberIsPresent(_id)){
            JOptionPane.showMessageDialog(null, "Member ID is incorrect.");
            return;
        }


        Member changeMem = new Member(_age, _mobNum,_name, _gender,_memShipType,_time);

        if (!Employee.editMember(_id, changeMem , Integer.parseInt(trainerid.getText()), _classesTypes)){
            JOptionPane.showMessageDialog(null, "Class unavailable as max number of members reached, please enter another class to join" );
            return;
        };

        JOptionPane.showMessageDialog(null, "Member has been succesfully edited.");

    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
