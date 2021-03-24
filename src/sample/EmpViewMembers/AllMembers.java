package sample.EmpViewMembers;

import DataModels.Administrator;
import DataModels.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class AllMembers implements Initializable {

    @FXML ListView allMemList;
    @FXML Button refreshBtn;

    URL url1;
    ResourceBundle resourceBundle1;

    @FXML
    void refreshBtn(){
        initialize(url1,resourceBundle1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        url1 = url;   resourceBundle1 = resourceBundle;



        ObservableList<String> itemAllMemList = FXCollections.observableArrayList();
        for(Member mems : Member.getMembers()){
            String classes = "";
            for (String gc: mems.className){
                classes = classes.concat(gc);
                classes = classes.concat(" ");
            }
            if(mems.trainerId==-1){
                itemAllMemList.addAll(
                        "ID: "+mems.id+"     Name: "+"     Classes: "+classes+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer: Not available"+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }
            else{
                itemAllMemList.addAll(
                        "ID: "+mems.id+"     Name: "+mems.name+"     Classes: "+classes+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
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
