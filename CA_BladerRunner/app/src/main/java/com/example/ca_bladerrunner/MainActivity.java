package com.example.ca_bladerrunner;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // uri of RESTful service on Azure
    private String SERVICE_URI = "https://ca2recipeapi.azurewebsites.net/api/recipes/all";          // or https
    private String TAG = "Recipes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // hook fab to register method
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                register(view);
            }
        });
    }

    public void register(View v){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
    // call RESTful service using volley and display results
    public void callService(View v)
    {
        // get TextView for displaying result
        final TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        final TextView textView = (TextView) findViewById(R.id.text);

        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
                StringRequest strObjRequest = new StringRequest(Request.Method.GET, SERVICE_URI,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                    String input = response;
                                Gson gson = new Gson();
                                Type type = new TypeToken<List<Recipes>>(){}.getType();
                                 List<Recipes> recipesList = gson.fromJson(response, type);

                                for(Recipes recipe:recipesList){

                                    //recipesList.add((input,Recipes.class));
                                }


                                //Recipes r = new Gson().fromJson(response, Recipes.class);
                                //Gson gson = new Gson();
                                //Type type = new TypeToken<List<Recipes>>(){}.getType();
                                //List<Recipes> recipesList = gson.fromJson(response, type);

                                //outputTextView.setText(r.toString());
                               // Log.d(TAG, "Displaying data" + r.toString());


                                //Gson gson = new Gson();
//                                Type type = new TypeToken<List<Recipes>>(){}.getType();
//                                List<Recipes> recipesList = gson.fromJson(response, type);

//                                for(Recipes recipe:recipesList){
//                                   // Log.i("Recipe Details", recipe.getRecipe_id() + " " + recipe.getRecipeName() +" " + recipe.getDuration() + " " + recipe.getDiff() +"");
//                                    recipesList.add(new Recipes(gson.fromJson(response, Recipes.class)));
//                                    outputTextView.setText(recipesList.toString());
//
//                                }



//
//                                ArrayList<Recipes>recipelist = new ArrayList<>();
//                                // parse resulting string containing JSON to Greeting object
//                                Recipes recipes = new Gson().fromJson(response, Recipes.class);
//
//
//                                for(int i =0; i < recipelist.size();i++){
//
//                                    outputTextView.setText(recipelist.get(i).toString());
//                                }
//
//                                Log.d(TAG, "Displaying data" + recipes.toString());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                outputTextView.setText(error.toString());
                                Log.d(TAG, "Error" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());
                textView.setText(e1.toString());
            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());
            textView.setText(e2.toString());
        }
    }
}
