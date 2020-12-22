package sample.ViewMembers;

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
import java.util.ResourceBundle;

public class SpecificMemShip implements Initializable , EventHandler<ActionEvent> {


    @FXML Button PAYG_Btn;
    @FXML Button monthBtn;
    @FXML Button yearBtn;
    @FXML ListView memShipList;

    int payType = 0;

    @Override
    public void handle(ActionEvent event)
    {
        if( event.getSource() == PAYG_Btn){ payType =1; }
        else if( event.getSource() == monthBtn){ payType =2; }
        else if( event.getSource() == yearBtn){ payType =3; }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> itemMemShipList = FXCollections.observableArrayList();
        for(int i = 1 ; i< 31 ; i++){
            // check payType
            itemMemShipList.addAll(
                    "ID: "+i+"     Name: "+i+"     Age: "+i+"     Gender:"+i+"     MobileNumber: "+"01119999123"+"\n"+
                            "Pay-Type: "+"3-Month"+"     Trainer:"+" Ahmed"+"     EndDate: "+" 10/4/2021"
            );

        }
        memShipList.setItems(itemMemShipList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }
}