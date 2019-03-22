package com.example.ca_bladerrunner;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recipes {

    @SerializedName("recipe_id")
    public int Recipe_id;
    @SerializedName("recipeName")
    public String RecipeName;
    @SerializedName("difficulty")
    public String Difficulty;
    @SerializedName("duration")
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


    // Returns a Book given the expected JSON
    public static Recipes fromJson(JSONObject jsonObject) {
        Recipes recipe = new Recipes();
        try {

            recipe.RecipeName = jsonObject.has("recipeName") ? jsonObject.getString("recipeName") : "";
            recipe.Difficulty = jsonObject.has("difficulty") ? jsonObject.getString("difficulty") : "";
            //recipe.Duration = jsonObject.has("duration") ? jsonObject.getDouble("duration") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return recipe;
    }
    public String toString()
    {
        return "RECIPE \n"+"Recipe Name : \t" + RecipeName + "\n"+ "Difficulty : \t"  + Difficulty + "\n" + "Duration :\t"+Duration;
    }

    // Decodes array of book json results into business model objects
    public static ArrayList<Recipes> fromJson(JSONArray jsonArray) {
        ArrayList<Recipes> listOfrecipes = new ArrayList<Recipes>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject recipesJson = null;
            try {
                recipesJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Recipes recipe= Recipes.fromJson(recipesJson);
            if (recipe != null) {
                listOfrecipes.add(recipe);
            }
        }
        return listOfrecipes;
    }


}
