package DataModels;

import java.util.ArrayList;

public class Employee extends CrewMember {


    public Employee(){

    }

    public Employee(String gender,String uname,String pass,int old,String mail,String number){

        super(gender,uname,pass,old,mail,number);

    }

    public static Boolean signIn(String user,String pass,ArrayList<Employee>employees){

        for(int i=0;i<employees.size();i++){

            if(employees.get(i).userName.equals(user)){

                if(employees.get(i).password.equals(pass))
                    return true;

            }
        }

        return false;
    }
    public static void addMember(Member mem,ArrayList<Member>members){

        members.add(mem);
    }
    public static void removeMember(int id,ArrayList<Member>members,ArrayList<Trainer>trainers,ArrayList<Class>classes){

        for(int i=0;i<members.size();i++){
            if(members.get(i).id==id)
                members.remove(i);
        }
        for(int i=0;i<trainers.size();i++){
            for(int j=0;j<trainers.get(i).memberId.size();j++){
                if(trainers.get(i).memberId.get(j)==id)
                    trainers.get(i).memberId.remove(j);
            }

        }
        for(int i=0;i<classes.size();i++){
            for(int j=0;j<classes.get(i).newMembers.size();j++){
                if(classes.get(i).newMembers.get(j)==id)
                    classes.get(i).newMembers.remove(j);
            }
        }
    }
    public static boolean editMember(int id, Member change, ArrayList<Member> members){

        for(int i=0;i<members.size();i++){

            if(members.get(i).id==id) {
                members.get(i).memberShip = change.memberShip;
                members.get(i).className = change.className;
                members.get(i).mobileNum = change.mobileNum;
                members.get(i).age = change.age;
                members.get(i).trainerId = change.trainerId;
                members.get(i).name = change.name;
                members.get(i).startDate = change.startDate;
                members.get(i).endDate = change.endDate;
                members.get(i).gender = change.gender;
                return true;
            }
        }
        return false;
    }
    public static void addMemberToClass(int memberId,String className,ArrayList<Member>members,ArrayList<Class>classes){

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.equals(className)&&classes.get(i).checkAvailability(classes.get(i))){
                for(int j=0;j<members.size();j++){
                    if(members.get(j).id==memberId){
                        members.get(j).className.add(className);
                        ((classes.get(i)).newMembers).add(memberId);
                    }
                }
            }
        }

    }
    public static void removeMemberFromClass(int memberId,String className,ArrayList<Member>members,ArrayList<Class>classes){

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.equals(className)){
                for(int j=0;j<classes.get(i).newMembers.size();j++){
                    if(classes.get(i).newMembers.get(j)==memberId)
                        classes.get(i).newMembers.remove(j);
                }
            }
        }

        for(int j=0;j<members.size();j++){
            if(members.get(j).id==memberId){
                for(int i=0;i<members.get(j).className.size();i++){
                    if(members.get(j).className.get(i).equals(className))
                        members.get(j).className.remove(i);
                }
            }
        }
    }

}
