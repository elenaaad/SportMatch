package com.example.sportmatch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateEventActivity extends AppCompatActivity {
    TextView title;
    TextInputLayout newEventName;
    TextInputEditText newEventNameEdt;
    TextInputLayout newEventSport;
    AutoCompleteTextView autocomplete_sport;
    TextInputLayout newEventPlayers;
    AutoCompleteTextView autocomplete_players;
    TextInputLayout newEventLoc;
    AutoCompleteTextView autocomplete_loc;
    TextInputLayout newEventDate;
    TextInputEditText newEventDateEdt;
    TextInputLayout newEventTime;
    AutoCompleteTextView autocomplete_time;
    TextInputLayout newEventDesc;
    TextInputEditText newEventDescEdt;
    Button buttonCEvent;
    String[] sports = {"Volleyball", "Football", "Handball", "Tennis", "Badminton", "Ping-Pong", "Basketball", "Bowling"};
    ArrayAdapter<String> adapterSports;
    String[] locations = {"SportField1", "SportField2", "SportField3", "SportField4", "SportField5"};
    ArrayAdapter<String> adapterLoc;
    String[] time_openings = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30"};
    ArrayAdapter<String> adapterTime;
    String[] players = {"2 Players", "4 Players", "6 Players", "8 Players"};
    ArrayAdapter<String> adapterPlayers;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newevent);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //TODO: stringuri
        //TODO: Legatura cu baza de date si tabelele
        //TODO: Legatura cu meniul si cu feedul
        //TODO: MAP
        //TODO: Interval de timp?

        title = findViewById(R.id.title);
        newEventName = findViewById(R.id.newEventName);
        newEventNameEdt = findViewById(R.id.newEventNameEdt);
        newEventSport = findViewById(R.id.newEventSport);
        autocomplete_sport = findViewById(R.id.autocomplete_sport);
        newEventPlayers = findViewById(R.id.newEventPlayers);
        autocomplete_players = findViewById(R.id.autocomplete_players);
        newEventLoc = findViewById(R.id.newEventLoc);
        autocomplete_loc = findViewById(R.id.autocomplete_loc);
        newEventDate = findViewById(R.id.newEventDate);
        newEventDateEdt = findViewById(R.id.newEventDateEdt);
        newEventTime = findViewById(R.id.newEventTime);
        autocomplete_time = findViewById(R.id.autocomplete_time);
        newEventDesc = findViewById(R.id.newEventDesc);
        newEventDescEdt = findViewById(R.id.newEventDescEdt);
        buttonCEvent = findViewById(R.id.buttonCEvent);
        mAuth = FirebaseAuth.getInstance();

        adapterSports = new ArrayAdapter<String>(this, R.layout.list_sport, sports);
        autocomplete_sport.setAdapter(adapterSports);

        adapterPlayers = new ArrayAdapter<String>(this, R.layout.list_player, players);
        autocomplete_players.setAdapter(adapterPlayers);

        adapterLoc = new ArrayAdapter<String>(this, R.layout.list_sportfields, locations);
        autocomplete_loc.setAdapter(adapterLoc);

        Calendar calendar = Calendar.getInstance();
        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        newEventDateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePicker.show(getSupportFragmentManager(), "Material_Date_Picker");

                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String dateString = formatter.format(selection);
                        newEventDateEdt.setText(dateString);
                    }
                });
            }
        });

        adapterTime = new ArrayAdapter<String>(this, R.layout.list_time,time_openings);
        autocomplete_time.setAdapter(adapterTime);

//        autocomplete_time.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String time = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), time + " selected", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //TIMEPICKER (ceas pretty:((((()
//        MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
//                .setTimeFormat(TimeFormat.CLOCK_12H)
//                .setHour(calendar.get(Calendar.HOUR_OF_DAY))
//                .setMinute(calendar.get(Calendar.MINUTE))
//                .setTitleText("Select Time")
//                .build();
//
//        newEventTimeEdt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timePicker.show(getSupportFragmentManager(), "Material_Time_Picker" );
//
//                timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int Hour = timePicker.getHour();
//                        int Minute = timePicker.getMinute();
//                        String H = "";
//                        String M = "";
//                        if(Hour/10==0){
//                            H = "0" + Hour;
//                        }
//                        else{
//                            H = String.valueOf(Hour);
//                        }
//                        if(Minute/10==0){
//                            M = "0" + Minute;
//                        }
//                        else{
//                            M = String.valueOf(Minute);
//                        }
//                        newEventTimeEdt.setText(H+":"+M);
//                    }
//                });
//
//
//            }
//        });

        buttonCEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int error = 0;

                String inputTitle = newEventNameEdt.getText().toString().trim();

                String selectedSport = autocomplete_sport.getText().toString().trim();
                if (TextUtils.isEmpty(selectedSport)) {
                    newEventSport.setError(getString(R.string.errorCEsport));
                    error = 1;
                } else {
                    newEventSport.setError(null);
                }

                String selectedPlayers = autocomplete_players.getText().toString().trim();
                if (TextUtils.isEmpty(selectedPlayers)) {
                    newEventPlayers.setError(getString(R.string.errorCEsport));
                    error = 1;
                } else {
                    newEventPlayers.setError(null);
                }

                String selectedLoc = autocomplete_loc.getText().toString().trim();
                if (TextUtils.isEmpty(selectedLoc)) {
                    newEventLoc.setError(getString(R.string.errorCEloc));
                    error = 1;
                } else {
                    newEventLoc.setError(null);
                }

                String selectedDate = newEventDateEdt.getText().toString().trim();
                if (TextUtils.isEmpty(selectedDate)) {
                    newEventDate.setError(getString(R.string.errorCEdate));
                    error = 1;
                } else {
                    newEventDate.setError(null);
                }

                String selectedTime = autocomplete_time.getText().toString().trim();
                if (TextUtils.isEmpty(selectedTime)) {
                    newEventTime.setError(getString(R.string.errorCEtime));
                    error = 1;
                } else {
                    newEventTime.setError(null);
                }

                String inputDesc = newEventDescEdt.getText().toString().trim();

                if(error == 0){
                    Intent intent = new Intent(CreateEventActivity.this, EventPreview .class);

                    if(TextUtils.isEmpty(inputTitle)){
                        intent.putExtra("valueTitle",selectedSport);
                    }
                    else{
                        intent.putExtra("valueTitle",inputTitle);
                    }

                    intent.putExtra("valueSport",selectedSport);
                    intent.putExtra("valuePlayers",selectedPlayers);
                    intent.putExtra("valueLoc",selectedLoc);
                    intent.putExtra("valueDate",selectedDate);
                    intent.putExtra("valueTime",selectedTime);

                    if(TextUtils.isEmpty(inputDesc)){
                        intent.putExtra("valueDesc","None");
                    }
                    else{
                        intent.putExtra("valueDesc",inputDesc);
                    }


                    startActivity(intent);
                }
            }
        });


    }
}
