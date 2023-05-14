package com.example.sportmatch;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //TODO: DUPA SIGN IN SAU SIGN UP DE LEGAT CU FEEDUL

    //TODO: Elena: prima pag cu 2 butoane log in si sign up
    //TODO: Elena: pagina de register(frontendul la ce a facut Cata)
    //TODO: Debora: terminat profile details + edit
    //TODO: Debora: log out
    //TODO: Raluca: Admin
    //TODO: Bianca: Tabele din baza de date
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


        /////doar temporar spre meniu
        Button menuBtn=(Button)findViewById(R.id.buttonMenu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BottomNavActivity.class));
            }
        });
        /////final meniu



        //BAZA DE DATE INFO SPORT & LOC

//        DBManagement db = new DBManagement();
//
//        Sport volei = new Sport("Volleyball", 14, 4);
//        db.addSport(volei);
//        Sport fotbal = new Sport("Football", 22, 6);
//        db.addSport(fotbal);
//        Sport handbal = new Sport("Handball", 28, 6);
//        db.addSport(handbal);
//        Sport tenis = new Sport("Tennis", 4, 2);
//        db.addSport(tenis);
//        Sport badminton = new Sport("Badminton", 4, 2);
//        db.addSport(badminton);
//        Sport pingpong = new Sport("Ping-Pong", 4, 2);
//        db.addSport(pingpong);
//        Sport baschet = new Sport("Basketball", 24, 10);
//        db.addSport(baschet);
//        Sport bowling = new Sport("Bowling", 15, 2);
//        db.addSport(bowling);
//
//        //VolleyBall
//        SportLocation v1 =  new SportLocation("Volleyball Arena", "Drumul Potcoavei", 36, 4, volei);
//        db.addLocation(v1);
//        SportLocation v2 =  new SportLocation("Sport Arena", "Bujorului", 80, 3, volei);
//        db.addLocation(v2);
//        SportLocation v3 =  new SportLocation("Complex Sportiv Tineretului", "Tineretului", 61, 4, volei);
//        db.addLocation(v3);
//        SportLocation v4 =  new SportLocation("Sport Arena Academia", "Oltetului", 30, 2, volei);
//        db.addLocation(v4);
//        SportLocation v5 =  new SportLocation("Parcul Tineretului", "Liviu Rebreanu", 30, 4, volei);
//        db.addLocation(v5);
//        SportLocation v6 =  new SportLocation("Arena Națională", "Bulevardul Decebal", 2, 3, volei);
//        db.addLocation(v6);
//
//        //Football
//        SportLocation f1 =  new SportLocation("Arena Sport One", "Toporași", 2, 4, fotbal);
//        db.addLocation(f1);
//        SportLocation f2 =  new SportLocation("Sport Arena", "Calea Vitan", 106, 3, fotbal);
//        db.addLocation(f2);
//        SportLocation f3 =  new SportLocation("Terenuri Sportive ProSport", "Dr. Staicovici", 31, 5, fotbal);
//        db.addLocation(f3);
//        SportLocation f4 =  new SportLocation("Arena Soccer Park", "Viilor", 44, 5, fotbal);
//        db.addLocation(f4);
//        SportLocation f5 =  new SportLocation("Fotbal Park Pipera", "Barajului", 14, 1, fotbal);
//        db.addLocation(f5);
//
//        //Handball
//        SportLocation h1 =  new SportLocation("Complex Sportiv Național Lia Manoliu", "Bulevardul Basarabia", 7, 2, handbal);
//        db.addLocation(h1);
//        SportLocation h2 =  new SportLocation("Sport Arena", "Calea Vitan", 106, 3, handbal);
//        db.addLocation(h2);
//        SportLocation h3 =  new SportLocation("Arena Sport One", "Toporași", 2, 4, handbal);
//        db.addLocation(h3);
//        SportLocation h4 =  new SportLocation("Parcul Carol", "Călărași", 0, 3, handbal);
//        db.addLocation(h4);
//        SportLocation h5 =  new SportLocation("Clubul Sportiv Municipal Bucureșt", "Măgurele", 26, 1, handbal);
//        db.addLocation(h5);
//
//        //Tennis
//        SportLocation t1 =  new SportLocation("Tenis Club Pro", "Mihai Eminescu", 145, 2, tenis);
//        db.addLocation(t1);
//        SportLocation t2 =  new SportLocation("Stejarii Country Club", "Jandarmeriei", 31, 1, tenis);
//        db.addLocation(t2);
//        SportLocation t3 =  new SportLocation("Tennis Arena", "Lânărie", 44, 3, tenis);
//        db.addLocation(t3);
//        SportLocation t4 =  new SportLocation("Sport Arena", "Virtutea", 1, 6, tenis);
//        db.addLocation(t4);
//        SportLocation t5 =  new SportLocation("Arena Tennis Park", "Dezrobirii", 37, 5, tenis);
//        db.addLocation(t5);
//
//        //Badminton
//        SportLocation d1 =  new SportLocation("Sport Arena", "Râmnicu Vâlcea", 30, 3, badminton);
//        db.addLocation(d1);
//        SportLocation d2 =  new SportLocation("AFI Cotroceni", "Bd. Vasile Milea", 4, 6, badminton);
//        db.addLocation(d2);
//        SportLocation d3 =  new SportLocation("Club Arena", "Calea Floreasca", 16, 1, badminton);
//        db.addLocation(d3);
//        SportLocation d4 =  new SportLocation("Oxygen Wellness", "Calea 13 Septembrie", 221, 5, badminton);
//        db.addLocation(d4);
//        SportLocation d5 =  new SportLocation("Elvira Popescu Badminton Club", "Olteniței", 23, 4, badminton);
//        db.addLocation(d5);
//
//        //Ping-Pong
//        SportLocation p1 =  new SportLocation("King Pong", "Episcopiei", 2, 3, pingpong);
//        db.addLocation(p1);
//        SportLocation p2 =  new SportLocation("Sport Arena", "Tuzla", 7, 3, pingpong);
//        db.addLocation(p2);
//        SportLocation p3 =  new SportLocation("Viva Club", "Sirenelor", 101, 5, pingpong);
//        db.addLocation(p3);
//        SportLocation p4 =  new SportLocation("Play Ping Pong", "Olari", 12, 2, pingpong);
//        db.addLocation(p4);
//        SportLocation p5 =  new SportLocation("Ping-Pong Club", "Doamnei", 9, 3, pingpong);
//        db.addLocation(p5);
//
//        //Basketball
//        SportLocation b1 =  new SportLocation("Complex Sportiv Regal", "Zidurilor", 5, 5, baschet);
//        db.addLocation(b1);
//        SportLocation b2 =  new SportLocation("Arena Mall", "Bulevardul Vitan-Barzesti", 7, 4, baschet);
//        db.addLocation(b2);
//        SportLocation b3 =  new SportLocation("World Class Health Academy", "Calea Floreasca", 169, 1, baschet);
//        db.addLocation(b3);
//        SportLocation b4 =  new SportLocation("Academia de Baschet Hagi", "Foisorului ", 160, 3, baschet);
//        db.addLocation(b4);
//        SportLocation b5 =  new SportLocation("Sala Sporturilor Dinamo", "Şoseaua Ştefan cel Mare", 7, 2, baschet);
//        db.addLocation(b5);
//
//        //Bowling
//        SportLocation w1 =  new SportLocation("Bucuresti Mall", " Calea Vitan", 55, 3, bowling);
//        db.addLocation(w1);
//        SportLocation w2 =  new SportLocation("Sun Plaza", "Calea Văcărești", 391, 4, bowling);
//        db.addLocation(w2);
//        SportLocation w3 =  new SportLocation("Mega Mall", "Pierre de Coubertin", 3, 2, bowling);
//        db.addLocation(w3);
//        SportLocation w4 =  new SportLocation("Plaza Romania", "Bd. Timișoara", 26, 6, bowling);
//        db.addLocation(w4);
//        SportLocation w5 =  new SportLocation("Liberty Center", " Progresului", 151, 5, bowling);
//        db.addLocation(w5);


    }

}