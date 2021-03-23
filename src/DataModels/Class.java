package DataModels;
import java.util.ArrayList;

public class Class{

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

    public boolean checkAvailability(Class gymClass)
    {
        if(gymClass.newMembers.size() < gymClass.maxNumOfMembers)
            return true;
        else
            return false;
    }

}
