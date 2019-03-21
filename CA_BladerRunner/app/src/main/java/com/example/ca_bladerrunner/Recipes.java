package com.example.ca_bladerrunner;

public class Recipes {


    public int Recipe_id;
    public String RecipeName;
    public String Difficulty;
    public double Duration;


    public Recipes(int Recipe_id, String RecipeName,String Difficulty,double duration){

        this.Recipe_id = Recipe_id;
        this.RecipeName = RecipeName;
        this.Difficulty = Difficulty;
        this.Duration = duration;
    }
    public Recipes(){}

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRN(String name){this.RecipeName = name;}
    public void setID(int id ){this.Recipe_id = id;}
    public void setDu(double d ){this.Duration = d;}
    public void setDi(String di){this.Difficulty = di;}




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
