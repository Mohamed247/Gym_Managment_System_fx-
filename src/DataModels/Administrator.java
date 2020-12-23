package DataModels;

import java.util.ArrayList;

public class Administrator extends CrewMember {


    public Administrator(){

    }

    public Administrator(String gender,String uname,String pass,int old,String mail,String number){

        super(gender,uname,pass,old,mail,number);

    }

    public static Boolean signIn(String user,String pass, ArrayList<Administrator>admins){

        for(int i=0;i<admins.size();i++){

            if(admins.get(i).userName.equals(user)){

                if(admins.get(i).password.equals(pass))
                    return true;

            }

        }
        return false;
    }

    protected void addTrainer(Trainer train,ArrayList<Trainer>trainers){

        workers++;

        train.id=workers;

        trainers.add(train);
    }
    protected void removeTrainer(int id,ArrayList<Trainer>trainers,ArrayList<Member>members,ArrayList<Class>classes){

        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==id)
                trainers.remove(i);
        }
        for(int i=0;i<members.size();i++){

            if(members.get(i).trainerId==id)
                members.get(i).trainerId=0;

        }
        for(int i=0;i<classes.size();i++){

            if(classes.get(i).trainerId==id)
                classes.get(i).trainerId=0;

        }
    }
    protected void editTrainer(int id,Trainer change,ArrayList<Trainer>trainers){

        for(int i=0;i<trainers.size();i++){

            if(trainers.get(i).id==id) {
                trainers.get(i).age = change.age;
                trainers.get(i).name = change.name;
                trainers.get(i).baseSalary=change.baseSalary;
            }
        }
    }
    protected void assignTrainerToMember(int memberId,int trainerId,ArrayList<Trainer>trainers,ArrayList<Member>members){

        int prevTrainer=0;

        for(int i=0;i<members.size();i++){

            if(members.get(i).id==memberId){

                if(members.get(i).trainerId!=0) {
                    prevTrainer=members.get(i).trainerId;
                }
                members.get(i).trainerId=trainerId;
            }
        }

        for(int i=0;i<trainers.size();i++){

            if(trainers.get(i).id==trainerId){

                trainers.get(i).memberId.add(memberId);
            }
            if(trainers.get(i).id==prevTrainer){

                for(int j=0;j<trainers.get(i).memberId.size();j++){

                    if(trainers.get(i).memberId.get(j)==memberId){

                        trainers.get(i).memberId.remove(j);
                    }
                }

            }

        }

    }
    protected void addClass(Class clas,ArrayList<Class>classes){

        classes.add(clas);
    }
    protected void removeClass(String className,ArrayList<Trainer>trainers,ArrayList<Member>members,ArrayList<Class>classes){

        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.equals(className))
                classes.remove(i);

        }
        for(int i=0;i<members.size();i++){

            for(int j=0;j<members.get(i).className.size();j++){

                if(members.get(i).className.get(j).equals(className))
                    members.get(i).className.remove(j);

            }

        }
        for(int i=0;i<trainers.size();i++){
            for(int j=0;j<trainers.get(i).className.size();j++){
                if(trainers.get(i).className.get(j).equals(className))
                    trainers.get(i).className.remove(j);
            }

        }

    }
    protected void editMClass(String className, Class gymClass, ArrayList<Class> classes){

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.equals(className)) {
                classes.get(i).classType=gymClass.classType;
                classes.get(i).endHour=gymClass.endHour;
                classes.get(i).startHour=gymClass.startHour;
                classes.get(i).maxNumOfMembers=gymClass.maxNumOfMembers;
                classes.get(i).trainerId=gymClass.trainerId;
                classes.get(i).newMembers=gymClass.newMembers;
                classes.get(i).day=gymClass.day;
                break;
            }
        }
    }
    protected boolean assignTrainerToClass(String className,int trainerId,ArrayList<Trainer>trainers,ArrayList<Class>classes){

        int prevTrainer=0;

        for(int i=0;i<classes.size();i++){

            if(classes.get(i).name.equals(className)){

                if(classes.get(i).trainerId!=0) {
                    prevTrainer=classes.get(i).trainerId;
                }
                classes.get(i).trainerId=trainerId;
            }
        }
        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){

                if(trainers.get(i).isAvailable(trainerId,className,trainers,classes))
                    trainers.get(i).className.add(className);

                else
                    return false;
            }
            if(trainers.get(i).id==prevTrainer){
                for(int j=0;j<trainers.get(i).className.size();j++){
                    if(trainers.get(i).className.get(j).equals(className)){
                        trainers.get(i).className.remove(j);
                    }
                }
            }

        }

        return false;
    }
}