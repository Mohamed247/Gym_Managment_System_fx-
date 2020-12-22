package DataModel;
import java.util.ArrayList;

public class Class{

    protected String name;
    protected Trainer trainer;
    protected int startHour, endHour;
    protected String classType;
    protected int maxNumOfMembers;
    protected ArrayList<Member> newMembers = new ArrayList<Member>();

    public Class(String name, String class_type, int maxNumOfMembers, int startHour, int endHour){

        this.name=name;
        this.classType=class_type;
        this.startHour=startHour;
        this.endHour=endHour;
        this.maxNumOfMembers = maxNumOfMembers;

    }

    public boolean checkAvailability(Class gymClass)
    {
        if(gymClass.newMembers.size() < gymClass.maxNumOfMembers)
            return true;
        else
            return false;
    }

}
