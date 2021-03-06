package com.cursoandroid.newmovies;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cursoandroid.adapters.MoviesAdapter;
import com.cursoandroid.json_utilities.JsonParser;
import com.cursoandroid.listeners.NetworkConnectionInterface;
import com.cursoandroid.models.Movie;
import com.cursoandroid.network.NetworkConnection;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements NetworkConnectionInterface{

    private String tag = MainActivity.class.getSimpleName();
    private RecyclerView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (RecyclerView)findViewById(R.id.listaPeliculas);
        lista.setLayoutManager(new GridLayoutManager(this,2));
        lista.setHasFixedSize(true);


        NetworkConnection connection = new NetworkConnection(this,this);
        connection.execute();
    }

    @Override
    public void OnSuccessFullyRespose(String respose) {
        ArrayList<Movie> peliculas = JsonParser.getMovies(this,respose);
        MoviesAdapter adapter = new MoviesAdapter(this,peliculas);
        lista.setAdapter(adapter);
    }

    @Override
    public void OnFaliedRespose(String response) {

    }
}

/*
        Uri uriExample;

        Esta forma de escribir la URL es igual a la que aparece adelante pero es obsoleta
        Uri.Builder builder = Uri.parse("http://www.google.com").buildUpon();
        builder.appendPath("users");
        builder.appendPath("params");
        builder.appendQueryParameter("id","54564654");
        builder.appendQueryParameter("name","Francisco");
        uriExample=builder.build();
        Log.d(tag,"Url: "+uriExample.toString());

        uriExample = Uri.parse("http://www.google.com").buildUpon()
                .appendPath("users")
                .appendPath("params")
                .appendQueryParameter("id","54564654")
                .appendQueryParameter("name","Francisco")
                .build();
        */