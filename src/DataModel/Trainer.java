package DataModel;

import java.util.ArrayList;

enum Gender { Male, Female }

public class Trainer {
    int id;
    int age;
    double baseSalary = 1000.0;
    String name;
    Gender gender;
    ArrayList<Class> sessions = new ArrayList<Class>();
    ArrayList<Member> trainees = new ArrayList<Member>();

    public Trainer (String nam, int old, Gender gend){
        name=nam;
        age=old;
        gender=gend;
    }

    public final double calcSalary(int trainerId, ArrayList<Trainer> trainers){

        double salary =baseSalary;

        for(int i=0;i<trainers.size();i++) {

            if (trainers.get(i).id == trainerId) {
                salary += (trainers.get(i).trainees.size() * 500) + (trainers.get(i).sessions.size() * 450);
            }
        }

        return salary;
    }

    //public static boolean isAvailable(Trainer trainer, Class gymClass){
    // check if class coincides with the same time
    // }
    
}
