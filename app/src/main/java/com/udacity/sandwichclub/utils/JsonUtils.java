package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        if (json == null){
            //UI-ing error handling should be done outside of this function
            return null;
        }

        //initialize
        String foodName = new String();
        List<String> alsoKnownAs = new ArrayList<String>();
        String placeOfOrigin = new String();
        String descrip = new String();
        String image = new String();
        List<String> ingred = new ArrayList<String>();

        //populate
        try{
            JSONObject foodJson = new JSONObject(json);
            JSONObject nameJson = foodJson.getJSONObject("name");
            foodName = nameJson.getString("mainName");

            //TODO alsoKnownAs population into List
            // JSONArray alsoKnownAsArr = nameJson.getJSONArray("alsoKnownAs");

            placeOfOrigin = foodJson.getString("placeOfOrigin");
            descrip = foodJson.getString("description");
            image = foodJson.getString("image");

            //TODO ingred population into List

            return new Sandwich(foodName, alsoKnownAs, placeOfOrigin, descrip, image, ingred);

        } catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }
}
