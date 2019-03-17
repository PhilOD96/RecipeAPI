package com.example.androidfrontend;

public class Recipes {

    private String openLibraryId;

    private int Recipe_id;
    private String RecipeName;
    private String Difficulty;
    private double Duration;


    public String getOpenLibraryId() {
        return openLibraryId;
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
