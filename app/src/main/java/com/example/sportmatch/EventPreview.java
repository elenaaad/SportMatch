package com.example.sportmatch;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class EventPreview extends AppCompatActivity {
    Button previewBtnEdit;
    ImageView sportImage;
    TextView previewTitle;
    TextView previewSport;
    TextView previewSportInput;
    TextView previewPlayers;
    TextView previewPlayersInput;
    TextView previewLoc;
    TextView previewLocInput;
    Button previewBtnMap;
    TextView previewDate;
    TextView previewDateInput;
    TextView previewTime;
    TextView previewTimeInput;
    TextView previewDesc;
    TextView previewDescInput;
    Button previewBtnAddEv;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpreview);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        previewBtnEdit = findViewById(R.id.previewBtnEdit);
        sportImage = findViewById(R.id.sportImage);
        previewTitle = findViewById(R.id.previewTitle);
        previewSport = findViewById(R.id.previewSport);
        previewSportInput = findViewById(R.id.previewSportInput);
        previewPlayers = findViewById(R.id.previewPlayers);
        previewPlayersInput = findViewById(R.id.previewPlayersInput);
        previewLoc = findViewById(R.id.previewLoc);
        previewLocInput = findViewById(R.id.previewLocInput);
        previewBtnMap = findViewById(R.id.previewBtnMap);
        previewDate = findViewById(R.id.previewDate);
        previewDateInput = findViewById(R.id.previewDateInput);
        previewTime = findViewById(R.id.previewTime);
        previewTimeInput = findViewById(R.id.previewTimeInput);
        previewDesc = findViewById(R.id.previewDesc);
        previewDescInput = findViewById(R.id.previewDescInput);
        previewBtnAddEv = findViewById(R.id.previewBtnAddEv);

        //TODO: editButton sa duca la pag de edit event


        mAuth = FirebaseAuth.getInstance();

        String valueTitle = getIntent().getStringExtra("valueTitle").toUpperCase();
        previewTitle.setText(valueTitle);

        String valueSport = getIntent().getStringExtra("valueSport");
        previewSportInput.setText(valueSport);

        String valuePlayers = getIntent().getStringExtra("valuePlayers");
        previewPlayersInput.setText(valuePlayers);

        String valueLoc = getIntent().getStringExtra("valueLoc");
        previewLocInput.setText(valueLoc);

        String valueDate = getIntent().getStringExtra("valueDate");
        previewDateInput.setText(valueDate);

        String valueTime = getIntent().getStringExtra("valueTime");
        previewTimeInput.setText(valueTime);

        String valueDesc = getIntent().getStringExtra("valueDesc");
        previewDescInput.setText(valueDesc);


        switch (valueSport) {
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




    }

}
