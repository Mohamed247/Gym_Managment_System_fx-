package DataModel;

import java.util.ArrayList;

public class Administrator extends CrewMember {

    public Administrator(){

    }

    public Administrator(Gender gender, String uname, String pass, int old, String mail, String number){

        super(gender,uname,pass,old,mail,number);

    }

    public Administrator signIn(String user, String pass, ArrayList<Administrator> admins){

        for(int i=0;i<admins.size();i++){

            if(admins.get(i).userName.equals(user)){

                if(admins.get(i).password.equals(pass))
                    return admins.get(i);

            }

        }

        return null;
    }

    protected void addTrainer(Trainer train, ArrayList<Trainer> trainers){

        workers++;

        train.id=workers;

        trainers.add(train);
    }
    protected void removeTrainer(int id, ArrayList<Trainer> trainers){

        for(int i=0;i<trainers.size();i++){

            if(trainers.get(i).id==id)
                trainers.remove(i);

        }

    }
    protected void editTrainer(int id, Trainer change, ArrayList<Trainer> trainers){

        for(int i=0;i<trainers.size();i++){

            if(trainers.get(i).id==id) {
                trainers.get(i).age = change.age;
                trainers.get(i).name = change.name;
            }
        }
    }
    protected boolean assignTrainerToMember(int memberId, int trainerId, ArrayList<Trainer> trainers, ArrayList<Member> members){

        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){
                for(int j=0;j<members.size();j++){
                    if(members.get(j).ID==memberId){
                        members.get(j).trainer=trainers.get(i);
                        trainers.get(i).trainees.add(members.get(j));
                        return true;
                    }
                }
            }
        }
        return false;
    }
    protected void addClass(Class clas, ArrayList<Class> classes){

        classes.add(clas);
    }
    protected void removeClass(String className, ArrayList<Class> classes){

        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.equals(className))
                classes.remove(i);

        }
    }
    protected void editMClass(Class className, Class gymClass, ArrayList<Class> classes){
        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.equals(className)) {
                classes.get(i).name = gymClass.name;
                classes.get(i).classType=gymClass.classType;
                classes.get(i).endHour=gymClass.endHour;
                classes.get(i).startHour=gymClass.startHour;
                classes.get(i).maxNumOfMembers=gymClass.maxNumOfMembers;
                classes.get(i).trainer=gymClass.trainer;
                classes.get(i).newMembers=gymClass.newMembers;
                break;
            }
        }
    }
    protected boolean assignTrainerToClass(String className, int trainerId, ArrayList<Trainer> trainers, ArrayList<Class> classes){

        Member mem;
        Trainer train;

        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){
                for(int j=0;j<classes.size();j++){
                    if(classes.get(j).name.equals(className)){
                        classes.get(j).trainer=trainers.get(i);
                        trainers.get(i).sessions.add(classes.get(j));
                    }
                }
            }
        }
        return false;
    }

}
