package sample.EmpViewMembers;

import DataModels.Administrator;
import DataModels.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.Main.members;

public class AllMembers implements Initializable {

    @FXML ListView allMemList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Member>memsArr = Administrator.viewAll(members);

        ObservableList<String> itemAllMemList = FXCollections.observableArrayList();
        for(Member mems : memsArr){
            if(mems.trainerId==-1){
                itemAllMemList.addAll(
                        "ID: "+mems.id+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer: Not available"+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }
            else{
                itemAllMemList.addAll(
                        "ID: "+mems.id+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer:"+mems.trainerId+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }

        }
        allMemList.setItems(itemAllMemList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }
}
