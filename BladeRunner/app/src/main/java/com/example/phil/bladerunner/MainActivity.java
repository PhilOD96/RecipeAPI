package com.example.phil.bladerunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.phil.bladerunner.adapters.RecipeAdapter;
import com.example.phil.bladerunner.clients.RecipeRestClient;
import com.example.phil.bladerunner.models.Recipes;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

public class MainActivity extends AppCompatActivity {

    private ListView recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRecipes();
    }

    private void getRecipes() {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));

        RecipeRestClient.get(MainActivity.this, "all", headers.toArray(new Header[headers.size()]),
                null, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        ArrayList<Recipes> recipeArray = new ArrayList<Recipes>();
                        RecipeAdapter recipeAdapter = new RecipeAdapter(MainActivity.this, recipeArray);

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                recipeAdapter.add(new Recipes(response.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        recipeList = (ListView) findViewById(R.id.list_recipes);
                        recipeList.setAdapter(recipeAdapter);
                    }
                });
    }
}