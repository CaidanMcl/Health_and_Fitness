package com.helfhealthandfitness;

public class WorkerUserSettings {
    public WorkerUserSettings (String usName, String usUsername, String usPassword, String usAge, String usEmail)
    {
        uName = usName;
        uUsername = usUsername;
        uPassword = usPassword;
        uAge = usAge;
        uEmail = usEmail;
    }
    String uName;
    String uUsername;
    String uPassword;
    String uAge;
    String uEmail;

    public String getuName() {
        return uName;
    }

    public void setuName(String usName) {
        uName = usName;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String usUsername) {
        uUsername = usUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String usPassword) {
        uPassword = usPassword;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String usAge) {
        uAge = usAge;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String usEmail) {
        uEmail = usEmail;
    }

}
