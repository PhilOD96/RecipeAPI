package com.example.phil.bladerunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.phil.bladerunner.R;
import com.example.phil.bladerunner.models.Recipes;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipes> {
    private static class ViewHolder {
        TextView id;
        TextView name;
    }

    public RecipeAdapter(Context context, ArrayList<Recipes> recipes) {
        super(context, R.layout.item_recipe, recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recipes recipe = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_recipe, parent, false);

            viewHolder.id = (TextView) convertView.findViewById(R.id.value_recipe_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.value_recipe_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.id.setText(recipe.getRecipeId());
        viewHolder.name.setText(recipe.getRecipeName());

        return convertView;
    }
}