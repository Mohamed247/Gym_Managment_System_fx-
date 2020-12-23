package sample.MangeMembers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class EditMemebr implements Initializable {

    public void editMemberFunc(ActionEvent actionEvent) {
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
