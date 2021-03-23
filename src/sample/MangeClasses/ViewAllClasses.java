package sample.MangeClasses;

import DataModels.Administrator;
import DataModels.Member;
import DataModels.GymClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAllClasses implements Initializable {

    @FXML ListView allClasses;
    @FXML Button refreshBtn;
    URL url1;
    ResourceBundle resourceBundle1;
    @FXML void refreshBtn(){
        initialize(url1,resourceBundle1);
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("You are in ViewAllClasses Now.");
        url1 = url;   resourceBundle1 = resourceBundle;
        ArrayList<GymClass>classArr= GymClass.getClasses();

        ObservableList<String> itemAllClassesList = FXCollections.observableArrayList();
        for(GymClass cl : classArr){
            itemAllClassesList.addAll("Name: "+cl.name+"     Day: " + cl.day+"     Start Hour: "+ cl.startHour+"     End Hour: "+ cl.endHour+ "     Class Description: "+cl.classDescription+ "     Maximum number of members in this class: "+ cl.maxNumOfMembers);
        }
        itemAllClassesList.setAll(itemAllClassesList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }
}
