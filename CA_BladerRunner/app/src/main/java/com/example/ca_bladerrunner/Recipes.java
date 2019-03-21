package com.example.ca_bladerrunner;

public class Recipes {


    private int Recipe_id;
    private String RecipeName;
    private String Difficulty;
    private double Duration;


    public Recipes(int Recipe_id, String RecipeName,String Difficulty,double duration){

        this.Recipe_id = Recipe_id;
        this.RecipeName = RecipeName;
        this.Difficulty = Difficulty;
        this.Duration = duration;
    }

    public String getRecipeName() {
        return RecipeName;
    }


    public int getRecipe_id(){
        return Recipe_id;
    }


    public String getDiff(){

        return Difficulty;
    }

    public double getDuration(){

        return Duration;
    }



    public String toString()
    {
        return RecipeName + " " + Difficulty + Duration;
    }


}
