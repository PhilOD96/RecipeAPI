package com.example.phil.bladerunner.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Recipes {

    private String Id;
    private String Name;
    private String Difficulty;
    private double Duration;

    public Recipes(JSONObject object) {
        try {
            this.Id = object.getString("recipe_id");
            this.Name = object.getString("recipeName");
            this.Difficulty = object.getString("difficulty");
            this.Duration = object.getDouble("duration");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Recipes(String Name, String Difficulty, double Duration) {
        this.Name = Name;
        this.Difficulty = Difficulty;
        this.Duration = Duration;
    }

    public String getRecipeId() {
        return this.Id;
    }

    public String getRecipeName() {
        return this.Name;
    }

    public void setRecipeName(String Name) {
        this.Name = Name;
    }

    public double getRecipeDuration() {
        return this.Duration;
    }

    public void setRecipeDuration(double Duration) {
        this.Duration = Duration;
    }

    public String getRecipeDifficulty() {
        return this.Difficulty;
    }

    public void setRecipeDifficulty(String Difficulty) {
        this.Difficulty = Difficulty;
    }
}