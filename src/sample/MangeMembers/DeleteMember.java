package sample.MangeMembers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteMember implements Initializable {

    public Button deleteBtn;
public TextField ID;
    public void deleteMemberBtnFunc(ActionEvent actionEvent) {
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
