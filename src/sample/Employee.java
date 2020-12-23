package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Employee implements Initializable, EventHandler<ActionEvent> {
@FXML Button addMember;
@FXML
Button editMember;
@FXML Button deleteMember;


@FXML Button viewAllMemInfo;
@FXML Button viewSpecClass;
@FXML Button viewSpecMemShip;

@FXML Button logoutBtn;

    @Override
    public void handle(ActionEvent event) {
        if( event.getSource() == addMember){ Main.stage.setScene(Main.emSceneAddMember); }
        else if( event.getSource() == editMember){ Main.stage.setScene(Main.emSceneEditMember); }
        else if( event.getSource() == deleteMember){ Main.stage.setScene(Main.emSceneDeleteMember); }

        else if( event.getSource() == viewAllMemInfo){ Main.stage.setScene(Main.sceneViewAllMem); }
        else if( event.getSource() == viewSpecClass){ Main.stage.setScene(Main.sceneSpecClass); }
        else if( event.getSource() == viewSpecMemShip){ Main.stage.setScene(Main.sceneSpecMemShip); }

        else if( event.getSource() == logoutBtn){ Main.stage.setScene(Main.sceneSignin); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
