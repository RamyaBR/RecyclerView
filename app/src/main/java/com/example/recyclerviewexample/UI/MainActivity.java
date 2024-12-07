package com.example.recyclerviewexample.UI;
import android.graphics.Movie;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexample.Data.Movies;
import com.example.recyclerviewexample.Data.Movies;
import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.Utils.MoviesWrapper;
import com.example.recyclerviewexample.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    protected String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            String jsonString = readJsonFromAsset();

            if (jsonString != null) {
                // Parse JSON using Gson
                Gson gson = new Gson();
                MoviesWrapper moviesWrapper = gson.fromJson(jsonString, MoviesWrapper.class);

                // Print movies
               /* for (Movies movie : moviesWrapper.getMovies()) {
                    System.out.println("ramya"+movie);
                }*/
                var customAdapter = new CustomAdapter(moviesWrapper.getMovies(), this);
                recyclerView.setAdapter(customAdapter);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readJsonFromAsset()
    {
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open("sampledata.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initDataset() {
        mDataset = new String[5];
        for (int i = 0; i < 5; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }
}