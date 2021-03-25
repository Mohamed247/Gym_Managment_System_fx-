package DataModels;

import java.io.Serializable;
import java.util.ArrayList;


public class Trainer implements Serializable {
    public int id;
    public int age;
    public double baseSalary = 1000.0;
    public String name;
    public String gender;
    ArrayList<String> className = new ArrayList<String>();
    ArrayList<Integer> memberId = new ArrayList<Integer>();

    public Trainer(String nam, int old, String gend) {
        name = nam;
        age = old;
        gender = gend;
    }

    public static boolean checkTrainerIsPresent(int newId) {
        for (Trainer t : getTrainers()) {
            if (t.id == newId) return true;
        }
        return false;
    }

    public static ArrayList<Trainer> getTrainers() {
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\trainers.txt");
        ArrayList<Trainer> trainers = new ArrayList<Trainer>();

        for (Object object : objects) {
            trainers.add(((Trainer) object));
        }

        return trainers;
    }


    public static ArrayList<Object> getTrainersAsObjects(ArrayList<Trainer> trainers) {
        ArrayList<Object> objects = new ArrayList<Object>();

        for (Trainer a : trainers) {
            objects.add((Object) a);
        }
        return objects;
    }

    public final double calcSalary(int trainerId) {
        ArrayList<Trainer> trainers = Trainer.getTrainers();
        double salary = baseSalary;

        for (int i = 0; i < trainers.size(); i++) {
            if (trainers.get(i).id == trainerId) {
                salary += (trainers.get(i).memberId.size() * 500) + (trainers.get(i).className.size() * 450);
            }
        }


        return salary;
    }

    public boolean isAvailable(int trainerId,String day, int startHour, int endHour) {
        ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<GymClass> gymClasses = GymClass.getClasses();

        ArrayList<String> work = new ArrayList<String>();

        for (int i = 0; i < gymClasses.size(); i++) {

            if (gymClasses.get(i).trainerId == trainerId) {

                if (gymClasses.get(i).day.toLowerCase().equals(day.toLowerCase())) {

                    if ((gymClasses.get(i).startHour >= startHour && gymClasses.get(i).startHour <= endHour) || (gymClasses.get(i).endHour >= startHour && gymClasses.get(i).endHour <= endHour))
                        return false;
                   // if(gymClasses.get(i).startHour == startHour && gymClasses.get(i).endHour == endHour)
                     //   return false;
                }

            }


        }
        return true;


    }

}
       /* ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<GymClass> gymClasses = GymClass.getClasses();

        String day="";
        int start=0,end=0;

        for(int i = 0; i< gymClasses.size(); i++)
            if(gymClasses.get(i).name.toLowerCase().equals(className.toLowerCase())){
                day= gymClasses.get(i).day;
                start= gymClasses.get(i).startHour;
                end= gymClasses.get(i).endHour;
            }
        for(int i=0;i<trainers.size();i++){
            if(trainers.get(i).id==trainerId){
                for(int j=0;j<trainers.get(i).className.size();j++){

                    if(trainers.get(i).className.get(j).toLowerCase().equals(gymClasses.get(j).name.toLowerCase())){

                        if(gymClasses.get(j).day.toLowerCase().equals(day.toLowerCase())){

                            if((gymClasses.get(j).startHour>=start && gymClasses.get(j).startHour<=end)||(gymClasses.get(j).endHour>=start && gymClasses.get(j).endHour<=end))
                               return false;
                             //if(gymClasses.get(j).startHour==start && gymClasses.get(j).endHour==end)
                              //  return false;
                        }
                    }
                }
                trainers.get(i).className.add(className);
                break;
            }
        }
        return true;
    */
    
