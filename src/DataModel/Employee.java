package DataModel;

import java.util.ArrayList;

public class Employee extends CrewMember {

    public Employee(){

    }

    public Employee(Gender gender, String uname, String pass, int old, String mail, String number){

        super(gender,uname,pass,old,mail,number);

    }

    public boolean signIn(String user, String pass, ArrayList<Employee> employees){

        for(int i=0;i<employees.size();i++){

            if(employees.get(i).userName.equals(user)){

                if(employees.get(i).password.equals(pass))
                    return true;

            }

        }

        return false;
    }

    protected void addMember(Member mem, ArrayList<Member> members){

        members.add(mem);
    }
    protected void removeMember(int id, ArrayList<Member> members){

        for(int i=0;i<members.size();i++){

            if(members.get(i).ID==id)
                members.remove(i);

        }

    }
    protected boolean editMember(int id, Member change, ArrayList<Member> members){

        for(int i=0;i<members.size();i++){

            if(members.get(i).ID==id) {
                members.get(i).memberShip = change.memberShip;
                members.get(i).typeOfClasses = change.typeOfClasses;
                members.get(i).mobileNum = change.mobileNum;
                members.get(i).age = change.age;
                members.get(i).trainer = change.trainer;
                members.get(i).name = change.name;
                members.get(i).startDate = change.startDate;
                members.get(i).endDate = change.endDate;
                members.get(i).gender = change.gender;
                return true;
            }
        }
        return false;
    }
    protected void addMemberToClass(int memberId, String className, ArrayList<Member> members, ArrayList<Class> classes){

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.equals(className)&&classes.get(i).checkAvailability(classes.get(i))){
                for(int j=0;j<members.size();j++){
                    if(members.get(j).ID==memberId){
                        members.get(j).typeOfClasses.add(classes.get(i));
                        ((classes.get(i)).newMembers).add(members.get(j));
                    }
                }
            }
        }

    }
    protected void removeMemberFromClass(int memberId, String className, ArrayList<Member> members, ArrayList<Class> classes){

        for(int i=0;i<classes.size();i++){
            if(classes.get(i).name.equals(className)){
                for(int j=0;j<members.size();j++){
                    if(members.get(j).ID==memberId){
                        members.get(j).typeOfClasses.remove(i);
                        classes.get(i).newMembers.remove(j);
                    }
                }
            }
        }

    }


}
