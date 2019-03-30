package com.example.phil.bladerunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;

import com.example.phil.bladerunner.adapters.ListViewAdapter;
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
    // Declare Variables

    ListViewAdapter adapter;
    EditText editSearch;
    Recipes[] recipeNameList;
    ArrayList<Recipes> arraylist = new ArrayList<Recipes>();


    private ArrayAdapter adapterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeList = (ListView) findViewById(R.id.list_recipes);
        editSearch = (EditText) findViewById(R.id.simpleSearchView);
        getRecipes();
        recipeNameList = new Recipes[]{};



        adapter = new ListViewAdapter(this,arraylist);

        recipeList.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().equals("")){
                    getRecipes();
                }
                else{
                    searchItem(s.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    public void searchItem(String itemToSearch){

        for(Recipes item:recipeNameList){
            if(itemToSearch != item.getRecipeName()){
                arraylist.remove(item);
            }
        }

        adapter.notifyDataSetChanged();
    }


    public void getRecipes() {
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
    public ListView populate() {
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
        return recipeList;
    }
}