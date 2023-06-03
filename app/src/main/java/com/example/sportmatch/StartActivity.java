package com.example.sportmatch;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //sursa: https://www.youtube.com/watch?v=To97nvWAgXc&ab_channel=CodeWithKhurshed
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3500);//cat dureaza anumatia din Splash Screen
                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                    overridePendingTransition(R.anim.slide_down, R.anim.slide_up);

                    finish();
                }catch(Exception e){

                }
            }
        };
        thread.start();
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(3100); // Durata animației din splash screen
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Intent intent = new Intent(StartActivity.this, MainActivity.class);
//
//                            // Start splash screen animation
//                            View splashView = findViewById(R.id.splash_view); // Replace splash_view with the correct id of your splash screen view
//                            splashView.animate()
//                                    .translationY(-splashView.getHeight()) // Move splashView upwards by its height
//                                    .setDuration(200) // Duration of animation in milliseconds
//                                    .setInterpolator(new AccelerateDecelerateInterpolator()) // Interpolator for smoother transition
//                                    .withEndAction(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            // Start main activity animation
//                                            startActivity(intent);
//
//                                            finish();
//                                        }
//                                    })
//                                    .start();
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();


    }
}