package sample;

import DataModels.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static Stage stage;
    public static Scene sceneSignin , sceneAdPage , sceneEmPage;
    public static Scene adSceneAddTrainer , adSceneEditTrainer , adSceneDeleteTrainer , adSceneViewAllTrainers ;
    public static Scene adSceneAddClass , adSceneEditClass , adSceneDeleteClass, adSceneViewAllClasses;
    public static Scene sceneViewAllMem , sceneSpecClass , sceneSpecMemShip;
    public static Scene emSceneAddMember , emSceneEditMember , emSceneDeleteMember;
    public static Scene sceneEmpViewAllMem , sceneEmpSpecMemShip , sceneEmpSpecClass;

    public static ArrayList<Object> administrators = new ArrayList<Object>();
    public static ArrayList<Object> employees = new ArrayList<Object>();
    public static ArrayList<Object> members = new ArrayList<Object>();
    public static ArrayList<Object> trainers = new ArrayList<Object>();
    public static ArrayList<Object> classes = new ArrayList<Object>();

    @Override
    public void start(Stage primaryStage) throws Exception{


        administrators.add(new Administrator("Male", "Mohamed" , "A2000" , 20 , "mohamed@gmail.com" , "01119938485"));
        administrators.add( new Administrator("Male", "Kareem" , "A2000" , 20 , "Ashraf@gmail.com" , "0111995555585"));
        administrators.add(new Administrator("Female", "Salma" , "A2000" , 20 , "Salma@gmail.com" , "01119567675"));

        employees.add(new DataModels.Employee("Male","Agina","A1000",20,"Jhon@outlook.com","0111284849"));
        employees.add(new DataModels.Employee("Male","Bedo","A1000",20,"Ahmed@outlook.com","0113848596"));
        employees.add(new DataModels.Employee("Female","Rawan","A1000",19,"Farah@outlook.com","011199994849"));

        members.add(new Member(22, "01243565656", "Kemo", "Male", "PAYG", new Time(5,12,2000)));
        members.add(new Member(24, "01243776566", "Mezo", "Male", "Term", new Time(4,2,2000)));
        members.add(new Member(20, "01243566565", "Rewrew", "Female", "Open", new Time(12,12,2000)));
        ((Member)members.get(0)).className.add("Gym");
        ((Member)members.get(1)).className.add("Boxing");
        ((Member)members.get(2)).className.add("Zumba");

        trainers.add( new Trainer ("Azzam",24, "Male"));  ((Trainer)trainers.get(0)).id=0;
        trainers.add( new Trainer ("Yara",22, "Female")); ((Trainer)trainers.get(1)).id=1;
        trainers.add( new Trainer ("Tony",42, "Male"));   ((Trainer)trainers.get(2)).id=2;
       // System.out.println(trainers.get(0).id);
        ((Member)members.get(0)).trainerId=0;
        ((Member)members.get(1)).trainerId=1;
        ((Member)members.get(2)).trainerId=2;
        classes.add(new GymClass("Gym","it is a class....gym..","Monday",30,5,7));
        classes.add(new GymClass("Zumba","it is a class...zumba..","Sunday",89,6,7));
        classes.add(new GymClass("Boxing","it is a class..boxing...","Friday",20,5,7));

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\administrators.txt", administrators);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", classes);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", members);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\employees.txt", employees);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", trainers);



        stage = primaryStage;

        //roots for scenes
        Parent rootSignin = FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Parent rootAdPage = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        Parent rootEmPage = FXMLLoader.load(getClass().getResource("Employee.fxml"));

        Parent rootAdAddTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/AddTrainer.fxml"));
        Parent rootAdEditTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/EditTrainer.fxml"));
        Parent rootAdDeleteTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/DeleteTrainer.fxml"));
        Parent rootAdViewAllTrainers = FXMLLoader.load(getClass().getResource("MangeTrainer/ViewAllTrainers.fxml"));


        Parent rootAdAddClass = FXMLLoader.load(getClass().getResource("MangeClasses/AddClass.fxml"));
        Parent rootAdEditClass = FXMLLoader.load(getClass().getResource("MangeClasses/EditClass.fxml"));
        Parent rootAdDeleteClass = FXMLLoader.load(getClass().getResource("MangeClasses/DeleteClass.fxml"));
        Parent rootViewAllClasses = FXMLLoader.load(getClass().getResource("MangeClasses/ViewAllClasses.fxml"));

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
        adSceneViewAllTrainers = new Scene(rootAdViewAllTrainers, 500, 500);

        adSceneAddClass = new Scene(rootAdAddClass, 500, 500);
        adSceneEditClass = new Scene(rootAdEditClass, 500, 500);
        adSceneDeleteClass = new Scene(rootAdDeleteClass, 500, 500);
        adSceneViewAllClasses = new Scene( rootViewAllClasses, 500, 500);


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
