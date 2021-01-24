package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPage implements Initializable , EventHandler<ActionEvent> {

    @FXML Button addTrainer;
    @FXML Button editTrainer;
    @FXML Button deleteTrainer;

    @FXML Button addClass;
    @FXML Button editClass;
    @FXML Button deleteClass;

    @FXML Button viewAllMemInfo;
    @FXML Button viewSpecClass;
    @FXML Button viewSpecMemShip;

    @FXML Button logoutBtn;


    @Override
    public void handle(ActionEvent event) {

        if( event.getSource() == addTrainer){ Main.stage.setScene(Main.adSceneAddTrainer); }
        else if( event.getSource() == editTrainer){ Main.stage.setScene(Main.adSceneEditTrainer); }
        else if( event.getSource() == deleteTrainer){ Main.stage.setScene(Main.adSceneDeleteTrainer); }

        else if( event.getSource() == addClass){ Main.stage.setScene(Main.adSceneAddClass); }
        else if( event.getSource() == editClass){ Main.stage.setScene(Main.adSceneEditClass); }
        else if( event.getSource() == deleteClass){ Main.stage.setScene(Main.adSceneDeleteClass); }

        else if( event.getSource() == viewAllMemInfo){ Main.stage.setScene(Main.sceneViewAllMem); }
        else if( event.getSource() == viewSpecClass){ Main.stage.setScene(Main.sceneSpecClass); }
        else if( event.getSource() == viewSpecMemShip){ Main.stage.setScene(Main.sceneSpecMemShip); }

        else if( event.getSource() == logoutBtn){ Main.stage.setScene(Main.sceneSignin); }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
