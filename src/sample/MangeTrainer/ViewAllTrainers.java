package sample.MangeTrainer;

import DataModels.Administrator;
import DataModels.Member;
import DataModels.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAllTrainers implements Initializable {
    @FXML
    ListView allTrainerList;
    @FXML Button refreshBtn;
    URL url2;
    ResourceBundle resourceBundle2;

    @FXML
    void refreshBtn(){
        initialize(url2,resourceBundle2);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("You are in ViewALLTrainers Now.");
        url2 = url;   resourceBundle2 = resourceBundle;
        ArrayList<Trainer>trainerArr=Trainer.getTrainers();

        ObservableList<String> itemAlltrainerList = FXCollections.observableArrayList();
        for(Trainer trainer : trainerArr){
            if(trainer.id==-1){
                itemAlltrainerList.addAll("Trainer: Not available"
                );
            }
            else{
                itemAlltrainerList.addAll("ID: "+trainer.id+
                        "     Name: "+trainer.name+"     Age: "+trainer.age+"     Gender:"+trainer.gender+
                                "     Salary: "+trainer.baseSalary
                );
            }

        }
        allTrainerList.setItems(itemAlltrainerList);
    }
    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneAdPage);
    }


}
