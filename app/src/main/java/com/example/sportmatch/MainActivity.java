package com.example.sportmatch;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //TODO: DUPA SIGN IN SAU SIGN UP DE LEGAT CU FEEDUL

    //TODO: Elena: prima pag cu 2 butoane log in si sign up
    //TODO: Elena: pagina de register(frontendul la ce a facut Cata) (gata)
    //TODO: Debora: terminat profile details + edit
    //TODO: Debora: log out
    //TODO: Raluca: Feed cu RecycleView
    //TODO: Bianca: Backend CreateNewEvent(si tabele din baza de date)
    //TODO: Bianca: Edit Event Details
    //TODO: Cata: Ia previewEvent si adauga chat si view member list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = (Button)findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        Button buttonRegister = (Button)findViewById(R.id.button_register);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        /////final meniu


    }

}