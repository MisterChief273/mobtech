package com.example.timefighter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timefighter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding = null;
    TextView gamescore_text;
    TextView timeleft_text;
    Button tap_button;

    private int score = 0;
    private boolean gameStarted = false;
    private CountDownTimer timer;
    private final long INIT_COUNT = 60000;
    private final long INTERVAL = 1000;

    public boolean onCreateOptionsMenu(Menu menu) {
        //create menu object and place it on the action button
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sub1) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
       else if (id == R.id.sub2) {
            Intent i = new Intent(MainActivity.this, HighScoreList.class);
            startActivity(i);
            finish();
            return true;
        }

        else if (id == R.id.sub3) {
            Intent i = new Intent(MainActivity.this, Credits.class);
            startActivity(i);
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamescore_text = findViewById(R.id.game_score_text_view);
        timeleft_text = findViewById(R.id.time_left_text_view);
        tap_button = findViewById(R.id.tap_me_button);

        tap_button.setOnClickListener(view ->  {
            incrementScore();


        });

        resetGame();




    }//end of onCreate







    private void incrementScore() {
        if (!gameStarted)
            startGame();
        score++;

        String text = getString(R.string.your_score,score);
        gamescore_text.setText(text);

    }
    private void resetGame() {

        score = 0;
        String text = getString(R.string.your_score,score);
        gamescore_text.setText(text);

        String timeLeft = getString(R.string.time_left, 60);
        timeleft_text.setText(timeLeft);

        gameStarted = false;
        //continue with the countdown object
        timer = new CountDownTimer(INIT_COUNT, INTERVAL) {
            @Override
            public void onTick(long l) {
                int second = (int)l / 1000;//convert back to second
                String timeLeft = getString(R.string.time_left,second);
                timeleft_text.setText(timeLeft);




            }

            @Override
            public void onFinish() {
                endGame();
            }
        };
    }
    private void  startGame() {
        timer.start();
        gameStarted = true;

    }
    private void endGame() {
        Toast.makeText(this,
                getString(R.string.game_over_message, score),
                Toast.LENGTH_LONG).show();

        resetGame();

    }



}


//end of class