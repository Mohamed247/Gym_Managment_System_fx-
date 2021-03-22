package DataModels;

import java.io.Serializable;

public class Time implements Serializable {

   public int day, month, year;

    public Time(int day, int month, int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
}
