package DataModels;
import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {

    protected String name;
    protected int trainerId=0;
    protected int startHour, endHour;
    protected String day;
    protected String classDescription;
    protected int maxNumOfMembers;
    protected ArrayList<Integer> newMembers = new ArrayList<Integer>();

    public Class(String name,String class_descrp,String day,int maxNumOfMembers,int startHour,int endHour){

        this.name=name;
        this.classDescription=class_descrp;
        this.startHour=startHour;
        this.endHour=endHour;
        this.maxNumOfMembers = maxNumOfMembers;
        this.day=day;

    }
    public static ArrayList<Class> getClasses(){
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\classes.txt");
        ArrayList<Class> classes = new ArrayList<Class>();

        for (Object object: objects){
            classes.add(((Class)object));
        }

        return classes;
    }
    public static ArrayList<Class> getOtherClasses(){
        ArrayList<Class> classes = getClasses();
        ArrayList<Class> otherClasses = new ArrayList<Class>();
        for (Class cl : classes){
            if (cl.name.toLowerCase().equals("gym") ||
                cl.name.toLowerCase().equals("zumba") ||
                cl.name.toLowerCase().equals("boxing")) continue;

            otherClasses.add(cl);
        }

        return otherClasses;
    }

    public static ArrayList<Object> getClassesAsObjects(ArrayList<Class> classes){
        ArrayList<Object> objects = new ArrayList<Object>();

        for (Class a: classes){
            objects.add((Object)a);
        }
        return objects;
    }

    public boolean checkAvailability(Class gymClass)
    {
        if(gymClass.newMembers.size() < gymClass.maxNumOfMembers)
            return true;
        else
            return false;
    }

}
