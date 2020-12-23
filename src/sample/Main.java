package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    public static Scene sceneSignin , sceneAdPage;
    public static Scene adSceneAddTrainer , adSceneEditTrainer , adSceneDeleteTrainer;
    public static Scene adSceneAddClass , adSceneEditClass , adSceneDeleteClass;
    public static Scene sceneViewAllMem , sceneSpecClass , sceneSpecMemShip;
    public static Scene emSceneEditMember,emSceneAddMember,emSceneDeleteMember;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        //roots for scenes
        Parent rootSignin = FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Parent rootAdPage = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));

        Parent rootAdAddTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/AddTrainer.fxml"));
        Parent rootAdEditTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/EditTrainer.fxml"));
        Parent rootAdDeleteTrainer = FXMLLoader.load(getClass().getResource("MangeTrainer/DeleteTrainer.fxml"));

        Parent rootAdAddClass = FXMLLoader.load(getClass().getResource("MangeClasses/AddClass.fxml"));
        Parent rootAdEditClass = FXMLLoader.load(getClass().getResource("MangeClasses/EditClass.fxml"));
        Parent rootAdDeleteClass = FXMLLoader.load(getClass().getResource("MangeClasses/DeleteClass.fxml"));

        Parent rootViewAllMem = FXMLLoader.load(getClass().getResource("ViewMembers/allMembers.fxml"));
        Parent rootViewSpecMemShip = FXMLLoader.load(getClass().getResource("ViewMembers/specificMemShip.fxml"));
        Parent rootViewSpecClass = FXMLLoader.load(getClass().getResource("ViewMembers/specificClass.fxml"));

        Parent rootemAddMember = FXMLLoader.load(getClass().getResource("MangeMembers/AddMember.fxml"));
        Parent rootemEditMember = FXMLLoader.load(getClass().getResource("MangeMembers/EditMember.fxml"));
        Parent rootemDeleteMember = FXMLLoader.load(getClass().getResource("MangeMembers/DeleteMember.fxml"));
        // Scenes
        sceneSignin = new Scene(rootSignin, 670, 500);
        sceneAdPage = new Scene(rootAdPage, 670, 500);

        adSceneAddTrainer = new Scene(rootAdAddTrainer, 670, 500);
        adSceneEditTrainer = new Scene(rootAdEditTrainer, 670, 500);
        adSceneDeleteTrainer = new Scene(rootAdDeleteTrainer, 670, 500);

        adSceneAddClass = new Scene(rootAdAddClass, 670, 500);
        adSceneEditClass = new Scene(rootAdEditClass, 670, 500);
        adSceneDeleteClass = new Scene(rootAdDeleteClass, 670, 500);

        sceneViewAllMem = new Scene(rootViewAllMem, 670, 500);
        sceneSpecMemShip = new Scene(rootViewSpecMemShip, 670, 500);
        sceneSpecClass = new Scene(rootViewSpecClass, 670, 500);

        emSceneAddMember = new Scene(rootemAddMember, 670, 500);
        emSceneEditMember = new Scene(rootemEditMember, 670, 500);
        emSceneDeleteMember = new Scene(rootemDeleteMember, 670, 500);

        // set for Stage
        stage.setTitle("Glory Gym");
        stage.setScene(sceneSignin);
        stage.show();
    }


    public static void main(String[] args) { launch(args); }
}
