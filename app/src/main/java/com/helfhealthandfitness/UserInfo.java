package com.helfhealthandfitness;

public class UserInfo {
    public UserInfo (String weight, String height, String monday, String tuesday,String wednesday,String thursday,String friday,String saturday,String sunday)
    {
        Weight = weight;
        Height = height;
        Monday = monday;
        Tuesday = tuesday;
        Wednesday = wednesday;
        Thursday = thursday;
        Friday = friday;
        Saturday = saturday;
        Sunday = sunday;


    }
    String Weight;
    String Height;
    String Monday;
    String Tuesday;
    String Wednesday;
    String Thursday;
    String Friday;
    String Saturday;
    String Sunday;

    public String getWeight() { return Weight; }
    public void setWeight(String weight) {Weight = weight;}

    public String getHeight() { return Height; }
    public void setHeight (String height){Height = height;}

    public String getMonday() { return Monday; }
    public void setMonday (String monday){Monday = monday;}

    public String getTuesday() { return Tuesday; }
    public void setTuesday(String tuesday) { Tuesday = tuesday;}

    public String getWednesday() { return Wednesday; }
    public void setWednesday(String wednesday) { Wednesday = wednesday;}

    public String getThursday() { return Thursday; }
    public void setThursday(String thursday) { Thursday = thursday;}

    public String getFriday() { return Friday; }
    public void setFriday(String friday) { Friday = friday;}

    public String getSaturday() { return Saturday; }
    public void setSaturday(String saturday) { Saturday = saturday;}

    public String getSunday() { return Sunday; }
    public void setSunday(String sunday) { Sunday = sunday;}



}
