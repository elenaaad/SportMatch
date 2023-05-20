package com.example.sportmatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventDetailsActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MAPS_ACTIVITY = 1001;
    TextView title;
    ImageView sportImage;
    TextView detailsTitle;
    TextView detailsSport;
    TextView detailsSportInput;
    TextView detailsPlayers;
    TextView detailsPlayersInput;
    TextView detailsLoc;
    TextView detailsLocInput;
    Button detailsBtnMap;
    TextView detailsDate;
    TextView detailsDateInput;
    TextView detailsTime;
    TextView detailsTimeInput;
    TextView detailsDesc;
    TextView detailsDescInput;
    Button detailsBtnParticipate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details_feed);

        title = findViewById(R.id.title);
        sportImage = findViewById(R.id.sportImage);
        detailsTitle = findViewById(R.id.detailsTitle);
        detailsSport = findViewById(R.id.detailsSport);
        detailsSportInput = findViewById(R.id.detailsSportInput);
        detailsPlayers = findViewById(R.id.detailsPlayers);
        detailsPlayersInput = findViewById(R.id.detailsPlayersInput);
        detailsLoc = findViewById(R.id.detailsLoc);
        detailsLocInput = findViewById(R.id.detailsLocInput);
        detailsBtnMap = findViewById(R.id.detailsBtnMap);
        detailsDate = findViewById(R.id.detailsDate);
        detailsDateInput = findViewById(R.id.detailsDateInput);
        detailsTime = findViewById(R.id.detailsTime);
        detailsTimeInput = findViewById(R.id.detailsTimeInput);
        detailsDesc = findViewById(R.id.detailsDesc);
        detailsDescInput = findViewById(R.id.detailsDescInput);
        detailsBtnParticipate = findViewById(R.id.detailsBtnParticipate);

        String valTitle = getIntent().getStringExtra("valTitle");
        detailsTitle.setText(valTitle);

        String valSport = getIntent().getStringExtra("valSport");
        detailsSportInput.setText(valSport);

        String valPlayers = getIntent().getStringExtra("valPlayers");
        detailsPlayersInput.setText(valPlayers);

        String valLoc = getIntent().getStringExtra("valLoc");
        detailsLocInput.setText(valLoc);

        String valDate = getIntent().getStringExtra("valDate");
        detailsDateInput.setText(valDate);

        String valTime = getIntent().getStringExtra("valTime");
        detailsTimeInput.setText(valTime);

        String valDesc = getIntent().getStringExtra("valDesc");
        detailsDescInput.setText(valDesc);

        switch (valSport) {
            case "Volleyball":
                sportImage.setImageResource(R.drawable.volleyball);
                break;
            case "Football":
                sportImage.setImageResource(R.drawable.football);
                break;
            case "Handball":
                sportImage.setImageResource(R.drawable.handball);
                break;
            case "Tennis":
                sportImage.setImageResource(R.drawable.tennis);
                break;
            case "Badminton":
                sportImage.setImageResource(R.drawable.badminton);
                break;
            case "Ping-Pong":
                sportImage.setImageResource(R.drawable.ping_pong);
                break;
            case "Basketball":
                sportImage.setImageResource(R.drawable.basketball);
                break;
            case "Bowling":
                sportImage.setImageResource(R.drawable.bowling);
                break;
        }


        detailsBtnParticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDetailsActivity.this, "Your participation request was sent to admin!", Toast.LENGTH_SHORT).show();
                //TODO: username admin in loc de admin
            }
        });

        ////inceput meniu

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_admin_events:
                    startActivity(new Intent(getApplicationContext(), AdminEventsActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_create_event:
                    startActivity(new Intent(getApplicationContext(), CreateEventActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_events_participates:
                    startActivity(new Intent(getApplicationContext(), OnlyParticipatesEvents.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_view_profile:
                    startActivity(new Intent(getApplicationContext(), ViewProfileActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

            }
            return false;
        });
        ///final meniu


        //MAP
        detailsBtnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(EventDetailsActivity.this, MapsActivity.class);
                intent2.putExtra("selectedLoc", valLoc);
                intent2.putExtra("selectedSport", valSport);
                intent2.putExtra("Activity", "EventDetailsFeed");
                startActivityForResult(intent2, REQUEST_CODE_MAPS_ACTIVITY);
            }
        });



    }

}
