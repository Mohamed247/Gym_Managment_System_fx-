package sample.MangeTrainer;

import DataModels.Administrator;
import DataModels.Member;
import DataModels.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;



public class DeleteTrainer implements Initializable {

    @FXML TextField id;
    @FXML Button deleteBtn;

    @FXML
    public void deleteTrainerBtnFunc(ActionEvent actionEvent) {
        int _id = Integer.parseInt(id.getText());
        if (!Trainer.checkTrainerIsPresent(_id)){
            JOptionPane.showMessageDialog(null, "Trainer ID is incorrect.");
            return;
        }
        Administrator.removeTrainer(_id);
        JOptionPane.showMessageDialog(null, "Trainer has been succesfully deleted.");
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
