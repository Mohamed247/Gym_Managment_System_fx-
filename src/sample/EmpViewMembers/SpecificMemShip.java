package sample.EmpViewMembers;

import DataModels.Administrator;
import DataModels.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class SpecificMemShip implements Initializable , EventHandler<ActionEvent> {


    @FXML Button PAYG_Btn;
    @FXML Button monthBtn;
    @FXML Button yearBtn;
    @FXML ListView memShipList;

    URL url1;
    ResourceBundle resourceBundle1;

    ArrayList<Member> memsArr = new ArrayList<Member>();

    @Override
    public void handle(ActionEvent event)
    {
        if( event.getSource() == PAYG_Btn){ memsArr = Administrator.viewSpecMembership("PAYG"); initialize( url1,  resourceBundle1); }
        else if( event.getSource() == monthBtn){ memsArr = Administrator.viewSpecMembership("Open"); initialize( url1,  resourceBundle1);}
        else if( event.getSource() == yearBtn){ memsArr = Administrator.viewSpecMembership("Term");; initialize( url1,  resourceBundle1);}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        url1 = url;  resourceBundle1 = resourceBundle;

        ObservableList<String> itemMemShipList = FXCollections.observableArrayList();
        for(Member mems : memsArr){

            if(mems.trainerId == -1){
                itemMemShipList.addAll(
                        "ID: "+mems.id+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer: Not available"+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }
            else{
                itemMemShipList.addAll(
                        "ID: "+mems.id+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer:"+mems.trainerId+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }

        }
        memShipList.setItems(itemMemShipList);
    }


    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }
}