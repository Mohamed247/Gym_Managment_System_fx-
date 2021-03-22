package sample.MangeMembers;

import DataModels.Administrator;
import DataModels.Employee;
import DataModels.Member;
import DataModels.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.EmpViewMembers.*;


import java.net.URL;
import java.util.ResourceBundle;

public class AddMembers implements Initializable
{

   
    @FXML TextField trainerid;
    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField gender;
    @FXML TextField mobNum;
    @FXML TextField classtype;
    @FXML TextField memShipType;
    @FXML TextField day;
    @FXML TextField month;
    @FXML TextField year;
    @FXML Button addBtn;
    @FXML Button backBtn;

    @FXML
    void addMemberBtnFunc(ActionEvent actionEvent)
    {
        Member member = new Member(Integer.parseInt(age.getText()), mobNum.getText(), name.getText(), gender.getText(), memShipType.getText(), new Time(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText())) );
        Employee.addMember(member);
        Administrator.assignTrainerToMember(member,Integer.parseInt(trainerid.getText()));
        Employee.addMemberToClass(member, classtype.getText());
        //System.out.println(members.get(3).age);
        //System.out.println(members.get(3).trainerId);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    } 
    
    public void backBtnFunc(ActionEvent actionEvent) { Main.stage.setScene(Main.sceneEmPage); }

    public void addBtnMemberFunc(ActionEvent actionEvent) {
    }
}
