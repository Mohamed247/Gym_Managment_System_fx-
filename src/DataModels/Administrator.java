package DataModels;

import javax.print.attribute.standard.JobKOctets;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class Administrator extends CrewMember{

    public Administrator(){

    }

    public Administrator(String gender,String uname,String pass,int old,String mail,String number){

        super(gender,uname,pass,old,mail,number);

    }

    public static ArrayList<Administrator> getAdmins(){
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\administrators.txt");
        ArrayList<Administrator> admins = new ArrayList<Administrator>();

        for (Object object: objects){
            admins.add(((Administrator)object));
        }

        return admins;
    }
    public static ArrayList<Object> getAdminsAsObjects(ArrayList<Administrator> administrators){
        ArrayList<Object> objects = new ArrayList<Object>();

        for (Administrator a: administrators){
            objects.add((Object)a);
        }
        return objects;
    }
    public static Boolean signIn(String user,String pass){

        ArrayList<Administrator> admins = Administrator.getAdmins();

        for(int i=0;i<admins.size();i++){

            if(admins.get(i).userName.toLowerCase().equals(user.toLowerCase())){

                if(admins.get(i).password.equals(pass))
                    return true;

            }

        }
        return false;
    }

    public static void addTrainer(Trainer train){

        ArrayList<Trainer> trainers = Trainer.getTrainers();

        workers++;

        train.id=workers;

        trainers.add(train);

        ArrayList<Object> objects = Trainer.getTrainersAsObjects(trainers);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objects);
    }

    public static void removeTrainer(int id){

        ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<Member> members = Member.getMembers();
        ArrayList<Class> classes = Class.getClasses();

        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==id)
                trainers.remove(i);
        }
        for(int i=0;i<members.size();i++){

            if(members.get(i).trainerId==id)
                members.get(i).trainerId=-1;

        }
        for(int i=0;i<classes.size();i++){

            if(classes.get(i).trainerId==id)
                classes.get(i).trainerId=-1;
        }

        ArrayList<Object> objectsTrainers = Trainer.getTrainersAsObjects(trainers);
        ArrayList<Object> objectsMembers = Member.getMembersAsObjects(members);
        ArrayList<Object> objectsClasses = Class.getClassesAsObjects(classes);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objectsTrainers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectsMembers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectsClasses);
    }

    public static void editTrainer(int id,Trainer change){
        ArrayList<Trainer> trainers = Trainer.getTrainers();

        for(int i=0;i<trainers.size();i++){

            if(trainers.get(i).id==id) {
                trainers.get(i).age = change.age;
                trainers.get(i).name = change.name;
                trainers.get(i).baseSalary=change.baseSalary;
            }
        }

        ArrayList<Object> objects = Trainer.getTrainersAsObjects(trainers);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objects);
    }
    public static void assignTrainerToMember(Member memb,int trainerId){
        ArrayList<Member> members = Member.getMembers();
        ArrayList<Trainer> trainers = Trainer.getTrainers();
        System.out.println("inside assign function");
        int prevTrainer=-1;
        for(int i=0;i<members.size();i++){
            if(members.get(i).id==memb.id){
                if(members.get(i).trainerId!=-1) {
                    prevTrainer=members.get(i).trainerId;
                }
                members.get(i).trainerId=trainerId;
                System.out.println("found member");
                break;
            }
        }

        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){
                trainers.get(i).memberId.add(memb.id);
                System.out.println("trainer id assigned");
            }
            if(trainers.get(i).id==prevTrainer){
                for(int j=0;j<trainers.get(i).memberId.size();j++){
                    if(trainers.get(i).memberId.get(j)==memb.id){
                        trainers.get(i).memberId.remove(j);
                        System.out.println("trainer id removed");
                    }
                }

            }

        }

        ArrayList<Object> objectTrainers = Trainer.getTrainersAsObjects(trainers);
        ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objectTrainers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);

    }

    public static void addClass(Class classs){
        ArrayList<Class> classes = Class.getClasses();
        classes.add(classs);

        ArrayList<Object> objects = Class.getClassesAsObjects(classes);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objects);

    }
    public static void removeClass(String className){
        ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<Member> members = Member.getMembers();
        ArrayList<Class> classes = Class.getClasses();

        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.toLowerCase().equals(className.toLowerCase()))
                classes.remove(i);

        }
        for(int i=0;i<members.size();i++){

            for(int j=0;j<members.get(i).className.size();j++){

                if(members.get(i).className.get(j).toLowerCase().equals(className.toLowerCase()))
                    members.get(i).className.remove(j);

            }

        }
        for(int i=0;i<trainers.size();i++){
            for(int j=0;j<trainers.get(i).className.size();j++){
                if(trainers.get(i).className.get(j).toLowerCase().equals(className.toLowerCase()))
                    trainers.get(i).className.remove(j);
            }

        }

        ArrayList<Object> objectTrainers = Trainer.getTrainersAsObjects(trainers);
        ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);
        ArrayList<Object> objectClasses = Class.getClassesAsObjects(classes);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objectTrainers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectClasses);


    }
    public static void editClass(String className, Class gymClass){
        ArrayList<Class> classes = Class.getClasses();

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.toLowerCase().equals(className.toLowerCase())) {
                classes.get(i).classDescription=gymClass.classDescription;
                classes.get(i).endHour=gymClass.endHour;
                classes.get(i).startHour=gymClass.startHour;
                classes.get(i).maxNumOfMembers=gymClass.maxNumOfMembers;
                classes.get(i).trainerId=gymClass.trainerId;
                classes.get(i).newMembers=gymClass.newMembers;
                classes.get(i).day=gymClass.day;
                break;
            }
        }
        ArrayList<Object> object = Class.getClassesAsObjects(classes);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", object);
    }
    public static boolean assignTrainerToClass(String className,int trainerId){

        ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<Class> classes = Class.getClasses();

        int prevTrainer=-1;

        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.toLowerCase().equals(className.toLowerCase())){

                if(classes.get(i).trainerId!=-1) {
                    prevTrainer=classes.get(i).trainerId;
                }
                classes.get(i).trainerId=trainerId;
            }
        }
        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){

                if(trainers.get(i).isAvailable(trainerId,className))
                    trainers.get(i).className.add(className);

                else
                    return false;
            }
            if(trainers.get(i).id==prevTrainer){
                for(int j=0;j<trainers.get(i).className.size();j++){
                    if(trainers.get(i).className.get(j).toLowerCase().equals(className.toLowerCase())){
                        trainers.get(i).className.remove(j);
                    }
                }
            }

        }

        ArrayList<Object> objectTrainers = Trainer.getTrainersAsObjects(trainers);
        ArrayList<Object> objectClasses = Class.getClassesAsObjects(classes);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objectTrainers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectClasses);

        return false;
    }
}