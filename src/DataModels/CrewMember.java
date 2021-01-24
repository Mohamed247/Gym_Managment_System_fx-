package DataModels;

import java.util.*;

public abstract class CrewMember {

    public final int id;
    protected String gender;
    protected String userName;
    protected String password;
    protected int age;
    protected String email;
    protected String mobileNumber;
    public static int workers = 0;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public CrewMember(){

        workers++;

        id=workers;

    }
    public CrewMember(String gender,String uname,String pass,int old,String mail,String number){

        workers++;
        id=workers;
        this.gender=gender;
        userName=uname;
        password=pass;
        age=old;
        email=mail;
        mobileNumber=number;
    }

      public static ArrayList<Member> viewSpecClass(String className,ArrayList<Member>members){

          ArrayList<Member>memb=new ArrayList<Member>();

          for(int i=0;i<members.size();i++){

              for(int j = 0; j<members.get(i).className.size(); j++){

                  if(members.get(i).className.get(j).equals(className)){

                      memb.add(members.get(i));
                  }
              }
          }
          return memb;
      }

      public static ArrayList<Member> viewAll(ArrayList<Member>members){

          return members;
      }
      public static ArrayList<Member> viewSpecMembership(String memberShip,ArrayList<Member>members){

          ArrayList<Member>memb=new ArrayList<Member>();

          for(int i=0;i<members.size();i++){

              if(members.get(i).memberShip.equals(memberShip)){

                  memb.add(members.get(i));
              }

          }

          return memb;
      }

}