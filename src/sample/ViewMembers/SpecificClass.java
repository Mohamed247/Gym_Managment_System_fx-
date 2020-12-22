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

public class SpecificClass implements Initializable , EventHandler<ActionEvent> {

    @FXML Button gymBtn;
    @FXML Button boxingBtn;
    @FXML Button ZumbaBtn;
    @FXML ListView memClassList;

    int classNum=0;
    @Override
    public void handle(ActionEvent event) {
        if( event.getSource() == gymBtn){ classNum =1; }
        else if( event.getSource() == boxingBtn){ classNum =2; }
        else if( event.getSource() == ZumbaBtn){ classNum =3; }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> itemMemClassList = FXCollections.observableArrayList();
        for(int i = 1 ; i< 31 ; i++){
            // check classNum
            itemMemClassList.addAll(
                    "ID: "+i+"     Name: "+i+"     Age: "+i+"     Gender:"+i+"     MobileNumber: "+"01119999123"+"\n"+
                            "Pay-Type: "+"3-Month"+"     Trainer:"+" Ahmed"+"     EndDate: "+" 10/4/2021"
            );

        }
        memClassList.setItems(itemMemClassList);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }


}