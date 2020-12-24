package sample.MangeMembers;

import DataModels.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import DataModels.Employee;
import DataModels.Member;
import static sample.Main.members;
import java.net.URL;
import java.util.ResourceBundle;

public class EditMemebr implements Initializable {
    @FXML TextField name;
    @FXML TextField age;
    @FXML TextField mobNum;
    @FXML TextField gender;
    @FXML TextField trainer;
    @FXML TextField ID;
    @FXML TextField classes;
    @FXML TextField memShipType;
    @FXML TextField day;
    @FXML TextField month;
    @FXML TextField year;
    @FXML Button editBtn;
    @FXML Button backBtn;


    public void editMemberFunc(ActionEvent actionEvent) {
        Employee.editMember(Integer.parseInt(ID.getText()), new Member(Integer.parseInt(age.getText()), mobNum.getText(), name.getText(), gender.getText(), memShipType.getText(), new Time(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText())) ), members);
        // assign trainer to member
        // add member to class
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
