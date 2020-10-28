package com.helfhealthandfitness;




public class Register  {

    public Register(String name, String regUserName1, String regPassword,String emailA,String age, String gender)
    {
        Name = name;
        ReUsername = regUserName1;
        RePassword = regPassword;
        ReEmail = emailA;
        Age = age;
        Gender = gender;

    }
    String Name;
    String ReUsername;
    String RePassword;
    String ReEmail;
    String Age;
    String Gender;


    public String getName() { return Name; }
    public void setName(String name) {Name = name;}

    public String getReUsername() { return ReUsername; }
    public void setReUsername (String regUserName1){ReUsername = regUserName1;}

    public String getRePassword() { return RePassword; }
    public void setRePassword (String regPassword){RePassword = regPassword;}

    public String getReEmail() { return ReEmail; }
    public void setReEmail (String emailA){ReEmail = emailA;}

    public String getAge() { return Age; }
    public void setAge(String age) { Age = age;}

    public String getGender() { return Gender; }
    public void setGender(String gender) { Gender = gender; }
}


