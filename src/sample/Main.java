package sample;

import DataModels.Administrator;
import DataModels.Class;
import DataModels.Member;
import DataModels.Time;
import DataModels.Trainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static Stage stage;
    public static Scene sceneSignin , sceneAdPage , sceneEmPage;
    public static Scene adSceneAddTrainer , adSceneEditTrainer , adSceneDeleteTrainer;
    public static Scene adSceneAddClass , adSceneEditClass , adSceneDeleteClass;
    public static Scene sceneViewAllMem , sceneSpecClass , sceneSpecMemShip;
    public static Scene emSceneAddMember , emSceneEditMember , emSceneDeleteMember;
    public static Scene sceneEmpViewAllMem , sceneEmpSpecMemShip , sceneEmpSpecClass;

    public static ArrayList<Administrator> administrators = new ArrayList<Administrator>();
    public static ArrayList<DataModels.Employee> employees = new ArrayList<DataModels.Employee>();
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    public static ArrayList<DataModels.Class> classes = new ArrayList<DataModels.Class>();

    @Override
    public void start(Stage primaryStage) throws Exception{


        administrators.add(new Administrator("Male", "Mohamed" , "MA2000" , 33 , "mohamed@gmail.com" , "01119938485"));
        administrators.add( new Administrator("Male", "Ashraf" , "MA2000" , 33 , "Ashraf@gmail.com" , "0111995555585"));
        administrators.add(new Administrator("Female", "Salma" , "MA2000" , 33 , "Salma@gmail.com" , "01119567675"));

        employees.add(new DataModels.Employee("Male","Jhon","MA1000",55,"Jhon@outlook.com","0111284849"));
        employees.add(new DataModels.Employee("Male","Ahmed","MA1000",57,"Ahmed@outlook.com","0113848596"));
        employees.add(new DataModels.Employee("Female","Farah","MA1000",25,"Farah@outlook.com","011199994849"));

        members.add(new Member(23, "01243565656", "Kareem", "Male", "PAYG", new Time(5,12,2000)));
        members.add(new Member(46, "0124377656", "Hazem", "Male", "Term", new Time(4,2,2000)));
        members.add(new Member(30, "0124356656", "Bedo", "Male", "Open", new Time(12,12,2000)));
        members.get(0).className.add("Gym");
        members.get(1).className.add("Boxing");
        members.get(2).className.add("Zumba");

        trainers.add( new Trainer ("Azzam",24, "Male"));  trainers.get(0).id=0;
        trainers.add( new Trainer ("Yara",22, "Female")); trainers.get(1).id=1;
        trainers.add( new Trainer ("Tony",42, "Male"));   trainers.get(2).id=2;
       // System.out.println(trainers.get(0).id);
        members.get(0).trainerId=0;
        members.get(1).trainerId=1;
        members.get(2).trainerId=2;
        classes.add(new DataModels.Class("Gym","it is a class....gym..","Monday",30,5,7));
        classes.add(new DataModels.Class("Zumba","it is a class...zumba..","Sunday",30,5,7));
        classes.add(new DataModels.Class("Boxing","it is a class..boxing...","Friday",30,5,7));

        stage = primaryStage;

        //roots for scenes
        Parent rootSignin = FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Parent rootAdPage = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        Parent rootEmPage = FXMLLoader.load(getClass().getResource("Employee.fxml"));

        Parent rootAdAddTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/AddTrainer.fxml"));
        Parent rootAdEditTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/EditTrainer.fxml"));
        Parent rootAdDeleteTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/DeleteTrainer.fxml"));

        Parent rootAdAddClass = FXMLLoader.load(getClass().getResource("MangeClasses/AddClass.fxml"));
        Parent rootAdEditClass = FXMLLoader.load(getClass().getResource("MangeClasses/EditClass.fxml"));
        Parent rootAdDeleteClass = FXMLLoader.load(getClass().getResource("MangeClasses/DeleteClass.fxml"));

        Parent rootViewAllMem = FXMLLoader.load(getClass().getResource("ViewMembers/allMembers.fxml"));
        Parent rootViewSpecMemShip = FXMLLoader.load(getClass().getResource("ViewMembers/specificMemShip.fxml"));
        Parent rootViewSpecClass = FXMLLoader.load(getClass().getResource("ViewMembers/specificClass.fxml"));

        Parent rootEmAddMember = FXMLLoader.load(getClass().getResource("MangeMembers/AddMembers.fxml"));
        Parent rootEmEditMember = FXMLLoader.load(getClass().getResource("MangeMembers/EditMember.fxml"));
        Parent rootEmDeleteMember = FXMLLoader.load(getClass().getResource("MangeMembers/DeleteMember.fxml"));

        Parent rootEmpViewAllMem = FXMLLoader.load(getClass().getResource("EmpViewMembers/allMembers.fxml"));
        Parent rootEmpViewSpecMemShip = FXMLLoader.load(getClass().getResource("EmpViewMembers/specificMemShip.fxml"));
        Parent rootEmpViewSpecClass = FXMLLoader.load(getClass().getResource("EmpViewMembers/specificClass.fxml"));

        // Scenes
        sceneSignin = new Scene(rootSignin, 500, 500);
        sceneAdPage = new Scene(rootAdPage, 500, 500);
        sceneEmPage = new Scene(rootEmPage, 500, 500);

        adSceneAddTrainer = new Scene(rootAdAddTrainer, 500, 500);
        adSceneEditTrainer = new Scene(rootAdEditTrainer, 500, 500);
        adSceneDeleteTrainer = new Scene(rootAdDeleteTrainer, 500, 500);

        adSceneAddClass = new Scene(rootAdAddClass, 500, 500);
        adSceneEditClass = new Scene(rootAdEditClass, 500, 500);
        adSceneDeleteClass = new Scene(rootAdDeleteClass, 500, 500);

        sceneViewAllMem = new Scene(rootViewAllMem, 500, 500);
        sceneSpecMemShip = new Scene(rootViewSpecMemShip, 500, 500);
        sceneSpecClass = new Scene(rootViewSpecClass, 500, 500);

        emSceneAddMember = new Scene(rootEmAddMember, 500, 500);
        emSceneEditMember = new Scene(rootEmEditMember, 500, 500);
        emSceneDeleteMember = new Scene(rootEmDeleteMember, 500, 500);

        sceneEmpViewAllMem = new Scene(rootEmpViewAllMem, 500, 500);
        sceneEmpSpecMemShip = new Scene(rootEmpViewSpecMemShip, 500, 500);
        sceneEmpSpecClass = new Scene(rootEmpViewSpecClass, 500, 500);

        // set for Stage
        stage.setTitle("Fitness Gym");
        stage.setScene(sceneSignin);
        stage.show();
    }


    public static void main(String[] args) { launch(args); }
}
