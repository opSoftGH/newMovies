package com.cursoandroid.json_utilities;

import android.content.Context;

import com.cursoandroid.models.Movie;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 209489355 on 11/03/2017.
 */

public class JsonParser {
    public static ArrayList<Movie> getMovies(Context context, String JsonString){
        ArrayList<Movie> peliculas = new ArrayList<>();
        try {
            JSONObject objetoPrincipal = new JSONObject(JsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
