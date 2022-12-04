package com.example.timefighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

import kotlinx.coroutines.Delay;


public class splash extends AppCompatActivity {


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();


        Intent intent = new Intent(this, MainActivity.class);
        // Check which checkbox was clicked

        switch (view.getId()) {

            case R.id.skip_splash:
                if (checked) {


                    countDownTimer.cancel();
                    startActivity(intent);


                } else

                    break;

        }


    }


    CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long l) {

            setContentView(R.layout.activity_splash);
            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(splash.this, MainActivity.class);

            startActivity(intent);
            finish();
        }
    }.start();


}









