package sample.MangeClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class AddClass implements Initializable , EventHandler<ActionEvent> {

    @FXML TextField name;
    @FXML TextField trainer;
    @FXML TextField day;
    @FXML TextField startTime;
    @FXML TextField endTime;
    @FXML TextArea description;
    @FXML Button addBtn;

    @Override
    public void handle(ActionEvent event) {
        if( event.getSource() == addBtn )
        {
            System.out.println(name);
            System.out.println(trainer);
            System.out.println(day);
            System.out.println(startTime);
            System.out.println(endTime);
            System.out.println(description);
        }
    }



    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
