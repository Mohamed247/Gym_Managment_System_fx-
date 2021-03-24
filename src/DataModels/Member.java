package DataModels;

import java.io.Serializable;
import java.util.ArrayList;


public class Member implements Serializable {
    public int id, age;
    public String name, memberShip, mobileNum;
    public String gender;
    public ArrayList<String> className=new ArrayList<String>();
    public int trainerId = -1;
    public Time startDate,endDate;
    public static int membersId=0;

    public Member(int age, String mobileNum, String name, String gender, String member_ship, Time startDate)
    {
        membersId++;
        this.id=membersId;
        this.age=age;
        this.mobileNum = mobileNum;
        this.name=name;
        this.gender=gender;
        this.memberShip = member_ship;
        this.startDate=startDate;
        endDate=startDate;

        setEndDate();

    }

    public static boolean checkMemberIsPresent(int _id){
        for (Member m: getMembers()){
            if (m.id == _id) return true;
        }
        return false;
    }
    public static ArrayList<Member> getMembers(){
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\members.txt");
        ArrayList<Member> members = new ArrayList<Member>();

        for (Object object: objects){
            members.add(((Member)object));
        }

        return members;
    }

    public static ArrayList<Object> getMembersAsObjects(ArrayList<Member> members){
        ArrayList<Object> objects = new ArrayList<Object>();

        for (Member a: members){
            objects.add((Object)a);
        }
        return objects;
    }

    public int getPayment(Member mem){

        if(mem.memberShip.toUpperCase().equals("PAYG"))
            return 20;

        else if(mem.memberShip.toLowerCase().equals("open"))
            return 300;

        else
            return 2500;

    }

    public void setEndDate(){
        if(this.memberShip.toUpperCase().equals("PAYG")) {

            if(startDate.day==30&&(startDate.month==4||startDate.month==6||startDate.month==9||startDate.month==11)){

                endDate.day=1;
                endDate.month++;

            }
            else if(startDate.day==28&&startDate.month==2){

                endDate.day=1;
                endDate.month++;

            }
            else if(startDate.day==31 &&
                    (startDate.month==10||startDate.month==8||
                            startDate.month==7||startDate.month==5||startDate.month==3||
                            startDate.month==1)){

                endDate.day=1;
                endDate.month++;

            }
            else if(startDate.month==12&&startDate.day==31){

                endDate.day=1;
                endDate.month=1;
                endDate.year++;

            }
            else
                endDate.day++;

        }

        else if(this.memberShip.toLowerCase().equals("open")){

            if(endDate.month==12) {
                endDate.month = 1;
                endDate.year++;
            }
            else
                endDate.month++;
        }

        else
            endDate.year++;

    }

}
