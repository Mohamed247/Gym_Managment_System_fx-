package sample.MangeMembers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import DataModels.Employee;
import DataModels.Member;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteMember implements Initializable {

    @FXML Button deleteBtn;
    @FXML TextField ID;

    public void deleteMemberBtnFunc(ActionEvent actionEvent) {
        int _id = Integer.parseInt(ID.getText());
        if (!Member.checkMemberIsPresent(_id)){
            JOptionPane.showMessageDialog(null, "Member ID is incorrect.");
            return;
        }
        Employee.removeMember(_id);
        JOptionPane.showMessageDialog(null, "Member has been succesfully deleted.");

    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
