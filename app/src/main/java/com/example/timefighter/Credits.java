package com.example.timefighter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        //create menu object and place it on the action button
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sub1) {
            Intent i = new Intent(Credits.this, MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        else if (id == R.id.sub2) {
            Intent i = new Intent(Credits.this, HighScoreList.class);
            startActivity(i);
            finish();
            return true;
        }

        else if (id == R.id.sub3) {
            Intent i = new Intent(Credits.this, Credits.class);
            startActivity(i);
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
}