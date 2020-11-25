package com.helfhealthandfitness;

public class GoalsWorkerClass {
    public GoalsWorkerClass(String gWeight,String gCalories)
    {
        weightGoal = gWeight;
        caloricGoal = gCalories;
    }
    String weightGoal;
    String caloricGoal;

    public GoalsWorkerClass()
    {
        //empty constructor
    }


    public String getweightGoal() {
        return weightGoal;
    }

    public void setweightGoal(String gWeight) {
        weightGoal = gWeight;
    }

    public String getcaloricGoal() {
        return caloricGoal;
    }

    public void setcaloricGoal(String gCalories) {
        caloricGoal = gCalories;
    }

    public String ToString()
    {
        return "Weight goal " + weightGoal + "/n" +"Calories intake goal" + caloricGoal;
    }



}
