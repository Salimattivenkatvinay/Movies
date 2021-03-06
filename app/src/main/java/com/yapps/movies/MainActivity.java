package com.yapps.movies;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

public class MainActivity extends AppCompatActivity {

    MovieDb movie;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieTask mt = new MovieTask();
        mt.execute();


    }

    protected class MovieTask extends AsyncTask<Void, Void, MovieDb> {

        protected MovieDb doInBackground(Void... v) {
            TmdbMovies movies = new TmdbApi("7e8f60e325cd06e164799af1e317d7a7").getMovies();
            movie = movies.getMovie(5353, "en");
            return movie;
        }

        protected void onPostExecute(MovieDb movie) {
            // Do something with movie
            Toast.makeText(getApplicationContext(),movie.toString(),Toast.LENGTH_LONG).show();
        }
    }
}


