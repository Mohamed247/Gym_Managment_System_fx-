package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class SgininPage implements Initializable {

    @FXML TextField nameText;
    @FXML TextField passText;
    @FXML Button createBtn;
    @FXML CheckBox adminCheck;

    @FXML
    void createBtnFunc(ActionEvent event){
        System.out.println(nameText.getText());
        System.out.println(passText.getText());
        System.out.println(adminCheck.isSelected());

        if( adminCheck.isSelected() == true) {
            Main.stage.setScene(Main.sceneAdPage);
        }
        else if( adminCheck.isSelected() == false) {
            // should be to Employee page
            Main.stage.setScene(Main.sceneAdPage);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
