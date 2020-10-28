package com.helfhealthandfitness;

public class helfClass {
    public helfClass(String userName, String uPassword){
        Username = userName;
        Password = uPassword;
    }
    String Username;
    String Password;
    public String getUsername() {
        return Username;
    }

    public void setUsername(String userName) {
        Username = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String uPassword) {
        Password = uPassword;
    }


}
