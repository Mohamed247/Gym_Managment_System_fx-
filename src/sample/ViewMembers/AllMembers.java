package sample.ViewMembers;

import DataModels.Administrator;
import DataModels.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sample.Main;
import static sample.Main.members;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllMembers implements Initializable {

    @FXML ListView allMemList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Member>memsArr = Administrator.viewAll(members);

        ObservableList<String> itemAllMemList = FXCollections.observableArrayList();
        for(Member mems : memsArr){

            itemAllMemList.addAll(
                    
            );
            itemAllMemList.addAll(
                    "ID: "+i+"     Name: "+i+"     Age: "+i+"     Gender:"+i+"     MobileNumber: "+"01119999123"+"\n"+
                         "Pay-Type: "+"3-Month"+"     Trainer:"+" Ahmed"+"     EndDate: "+" 10/4/2021"
            );

        }
        allMemList.setItems(itemAllMemList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }
}
