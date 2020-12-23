package DataModels;

import java.util.ArrayList;


public class Trainer {
    int id;
    int age;
    double baseSalary = 1000.0;
    String name;
    String gender;
    ArrayList<String> className = new ArrayList<String>();
    ArrayList<Integer> memberId = new ArrayList<Integer>();

    public Trainer (String nam,int old, String gend){
        name=nam;
        age=old;
        gender=gend;
    }

    public final double calcSalary(int trainerId, ArrayList<Trainer>trainers){

        double salary =baseSalary;

        for(int i=0;i<trainers.size();i++) {
            if (trainers.get(i).id == trainerId) {
                salary += (trainers.get(i).memberId.size() * 500) + (trainers.get(i).className.size() * 450);
            }
        }
        return salary;
    }

    public boolean isAvailable(int trainerId,String className,ArrayList<Trainer>trainers,ArrayList<Class>classes){

        String day=null;
        int start=0,end=0;
        ArrayList<String>work=new ArrayList<String>();

        for(int i=0;i<classes.size();i++)
            if(classes.get(i).name.equals(className)){
                day=classes.get(i).day;
                start=classes.get(i).startHour;
                end=classes.get(i).endHour;
            }
        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){
                for(int j=0;j<trainers.get(i).className.size();j++)
                    work.add(trainers.get(i).className.get(j));
            }
        }
        for(int i=0;i<work.size();i++){
            for(int j=0;j<classes.size();i++){

                if(work.get(i).equals(classes.get(j).name)){

                    if(classes.get(j).day.equals(day)){

                        if((classes.get(j).startHour<=start&&classes.get(j).endHour>=start)||(classes.get(j).startHour<=end&&classes.get(j).endHour>=end))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    
}
