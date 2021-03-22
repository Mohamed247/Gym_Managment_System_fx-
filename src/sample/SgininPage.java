package sample;

import DataModels.Administrator;
import DataModels.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;



public class SgininPage implements Initializable {

    @FXML TextField nameText;
    @FXML PasswordField passText;
    @FXML Button createBtn;
    @FXML CheckBox adminCheck;

    @FXML
    void createBtnFunc(ActionEvent event){

        System.out.println(nameText.getText());
        System.out.println(passText.getText());
        System.out.println(adminCheck.isSelected());

        Boolean isAdmin = Administrator.signIn(nameText.getText(),passText.getText());
        Boolean isEmployee = Employee.signIn(nameText.getText(),passText.getText());

        if( adminCheck.isSelected() == true && isAdmin==true) {

            Main.stage.setScene(Main.sceneAdPage);
        }
        else if( adminCheck.isSelected() == false && isEmployee == true) {
            Main.stage.setScene(Main.sceneEmPage);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }


}
