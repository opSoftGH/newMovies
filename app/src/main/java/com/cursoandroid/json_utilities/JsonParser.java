package com.cursoandroid.json_utilities;

import android.content.Context;

import com.cursoandroid.models.Movie;
import com.cursoandroid.newmovies.R;

import org.json.JSONArray;
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
            JSONArray arregloDePeliculas = objetoPrincipal.getJSONArray(context.getString(R.string.results_json_param));
            for (int i=0;i<arregloDePeliculas.length();i++){
                JSONObject pelicula = arregloDePeliculas.getJSONObject(i);
                int id= pelicula.getInt(context.getString(R.string.id_json_param));
                String title = pelicula.getString(context.getString(R.string.title_json_param));
                String description = pelicula.getString(context.getString(R.string.description_json_param));
                String poster_path = pelicula.getString(context.getString(R.string.poster_path_json_param));
                poster_path= context.getString(R.string.base_url_image_api+R.string.image_size_default)+poster_path;
                //En la sentencia anterior estaba a discucion lo de la doble diagonal, yo se la quite, si existe error probar agregandola

                Movie movie = new Movie(id,title,description,poster_path);
                peliculas.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
