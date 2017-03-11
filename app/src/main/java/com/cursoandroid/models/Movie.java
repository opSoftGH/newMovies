package com.cursoandroid.models;

/**
 * Created by 209489355 on 11/03/2017.
 */

public class Movie {
    private int id;
    private String tittle;
    private String description;
    private String poster_path;

    public Movie(int id, String tittle, String description, String poster_path) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}

