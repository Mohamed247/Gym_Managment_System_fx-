package DataModels;

import java.util.ArrayList;

public class Employee extends CrewMember {


    public Employee(){

    }

    public Employee(String gender,String uname,String pass,int old,String mail,String number){

        super(gender,uname,pass,old,mail,number);

    }
    public static ArrayList<Employee> getEmployees(){
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\employees.txt");
        ArrayList<Employee> employees = new ArrayList<Employee>();

        for (Object object: objects){
            employees.add(((Employee)object));
        }

        return employees;
    }

public static ArrayList<Object> getEmployeesAsObjects(ArrayList<Employee> employees){

        ArrayList<Object> objects = new ArrayList<Object>();

        for (Employee a: employees){
            objects.add((Object)a);
        }
        return objects;
    }

    public static Boolean signIn(String user,String pass){
        ArrayList<Employee> employees = Employee.getEmployees();

        for(int i=0;i<employees.size();i++){

            if(employees.get(i).userName.toLowerCase().equals(user.toLowerCase())){

                if(employees.get(i).password.equals(pass))
                    return true;

            }
        }

        return false;
    }
    public static void addMember(Member mem){
        ArrayList<Member>members = Member.getMembers();
        members.add(mem);

        ArrayList<Object> memberObjects = new ArrayList<Object>();
        for (Member member: members){
            memberObjects.add((Object)member);
        }


        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", memberObjects);
    }
    public static void removeMember(int id){

        ArrayList<Member> members = Member.getMembers();
        ArrayList<Trainer> trainers = Trainer.getTrainers();
        ArrayList<GymClass> gymClasses = GymClass.getClasses();

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
        for(int i = 0; i< gymClasses.size(); i++){
            for(int j = 0; j< gymClasses.get(i).newMembers.size(); j++){
                if(gymClasses.get(i).newMembers.get(j)==id)
                    gymClasses.get(i).newMembers.remove(j);
            }
        }

        ArrayList<Object> objectTrainers = Trainer.getTrainersAsObjects(trainers);
        ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);
        ArrayList<Object> objectClasses = GymClass.getClassesAsObjects(gymClasses);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\trainers.txt", objectTrainers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectClasses);
    }
    public static boolean editMember(int id, Member change, int trainerID, ArrayList<String> classNamee){
        ArrayList<Member> members = Member.getMembers();
        for (String s: classNamee){
            if (!GymClass.checkAvailability(s)) return false;
        }
        for(int i=0;i<members.size();i++){
            ArrayList<String> classNames = new ArrayList<String>();

            if(members.get(i).id==id) {
                members.get(i).memberShip = change.memberShip;
                for (String className: classNamee){
                    if (className.length() != 0)
                        classNames.add(className); //
                }

                members.get(i).className = classNames; //
                members.get(i).mobileNum = change.mobileNum;
                members.get(i).age = change.age;
                members.get(i).trainerId = trainerID;
                members.get(i).name = change.name;
                members.get(i).startDate = change.startDate;
                members.get(i).endDate = change.endDate;
                members.get(i).gender = change.gender;

                ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);

                WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);

                return true;
            }
        }
        return false;
    }
    public static boolean addMemberToClass(Member member,ArrayList<String> classNamee){

        ArrayList<Member> members = Member.getMembers();
        ArrayList<GymClass> gymClasses = GymClass.getClasses();
        boolean found = false;
        for(int i = 0; i< gymClasses.size(); i++){
            for (String className: classNamee){
                if(gymClasses.get(i).name.toLowerCase().equals(className.toLowerCase())&& gymClasses.get(i).checkAvailability(gymClasses.get(i))){
                    
                            member.className.add(className);
                            ((gymClasses.get(i)).newMembers).add(member.id);
                            found = true;
                        }
               
            }

        }
        if (!found){
            return false;
        }
        ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);
        ArrayList<Object> objectClasses = GymClass.getClassesAsObjects(gymClasses);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectClasses);
        return true;
    }
    public static void removeMemberFromClass(int memberId,String className){

        ArrayList<Member> members = Member.getMembers();
        ArrayList<GymClass> gymClasses = GymClass.getClasses();

        for(int i = 0; i< gymClasses.size(); i++){
            if(gymClasses.get(i).name.toLowerCase().equals(className.toLowerCase())){
                for(int j = 0; j< gymClasses.get(i).newMembers.size(); j++){
                    if(gymClasses.get(i).newMembers.get(j)==memberId)
                        gymClasses.get(i).newMembers.remove(j);
                }
            }
        }

        for(int j=0;j<members.size();j++){
            if(members.get(j).id==memberId){
                for(int i=0;i<members.get(j).className.size();i++){
                    if(members.get(j).className.get(i).toLowerCase().equals(className.toLowerCase()))
                        members.get(j).className.remove(i);
                }
            }
        }

        ArrayList<Object> objectMembers = Member.getMembersAsObjects(members);
        ArrayList<Object> objectClasses = GymClass.getClassesAsObjects(gymClasses);

        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\members.txt", objectMembers);
        WriterReaderSingleton.getInstance().writeObjectsToFile("src\\classes.txt", objectClasses);
    }

}
