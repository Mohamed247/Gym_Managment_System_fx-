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


public class SpecificClass implements Initializable , EventHandler<ActionEvent> {

    @FXML Button gymBtn;
    @FXML Button boxingBtn;
    @FXML Button ZumbaBtn;
    @FXML Button OtherClassBtn;
    @FXML ListView memClassList;

    URL url1;
    ResourceBundle resourceBundle1;

    ArrayList<Member> memsArr = new ArrayList<Member>();
    @Override
    public void handle(ActionEvent event) {
        if( event.getSource() == gymBtn){ memsArr = Administrator.viewSpecClass("Gym"); initialize( url1,  resourceBundle1); }
        else if( event.getSource() == boxingBtn){ memsArr = Administrator.viewSpecClass("Boxing"); initialize( url1,  resourceBundle1);}
        else if( event.getSource() == ZumbaBtn){ memsArr = Administrator.viewSpecClass("Zumba"); initialize( url1,  resourceBundle1);}
        else if( event.getSource() == OtherClassBtn){ memsArr = Administrator.getOtherclassesMembers(); initialize( url1,  resourceBundle1);}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        url1 = url;  resourceBundle1 = resourceBundle;

        ObservableList<String> itemMemClassList = FXCollections.observableArrayList();
        for(Member mems : memsArr){

            if(mems.trainerId == -1){
                itemMemClassList.addAll(
                        "ID: "+mems.id+"     Class: "+mems.className+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer: Not available"+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }
            else{
                itemMemClassList.addAll(
                        "ID: "+mems.id+"     Class: "+mems.className+"     Name: "+mems.name+"     Age: "+mems.age+"     Gender:"+mems.gender+"     MobileNumber: "+mems.mobileNum+"\n"+
                                "Pay-Type: "+mems.memberShip+"     Trainer:"+mems.trainerId+"     EndDate: "+mems.endDate.day+"/"+mems.endDate.month+"/"+mems.endDate.year
                );
            }

        }
        memClassList.setItems(itemMemClassList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

}