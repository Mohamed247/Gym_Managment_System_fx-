package sample.MangeMembers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;


import java.net.URL;
import java.util.ResourceBundle;

public class AddMembers implements Initializable
{

   
    @FXML TextField trainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    } 
    
    public void backBtnFunc(ActionEvent actionEvent) { Main.stage.setScene(Main.sceneEmPage); }

    public void addBtnMemberFunc(ActionEvent actionEvent) {
    }
}
