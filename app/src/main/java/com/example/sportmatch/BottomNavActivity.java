package com.example.sportmatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BottomNavActivity extends AppCompatActivity {

    ///recyclerview
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;


    ParentAdapterBottom parentAdapter;
    ArrayList<AllCategory> allCategoryList;
    ArrayList<Event> volleyballList;
    ArrayList<Event> footballList;
    ArrayList<Event> handballList;
    ArrayList<Event> tennisList;
    ArrayList<Event> badmintonList;
    ArrayList<Event> pingpongList;
    ArrayList<Event> basketballList;
    ArrayList<Event> bowlingList;
    ///end recyclerview

    String[] item={"2 players","<= 4 players","<= 6 players","All"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String>  adapterItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);


        AlertDialog.Builder builder=new AlertDialog.Builder(BottomNavActivity.this);
        builder.setCancelable(false);
//        builder.setView(R.layout.progress_layout)??????
        AlertDialog dialog=builder.create();
        dialog.show();


        ///start of retrieve data from firebase
        allCategoryList =new ArrayList<>();
        volleyballList =new ArrayList<>();
        footballList =new ArrayList<>();
        tennisList =new ArrayList<>();
        handballList =new ArrayList<>();
        basketballList =new ArrayList<>();
        pingpongList =new ArrayList<>();
        bowlingList = new ArrayList<>();
        badmintonList=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Events");

        eventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot itemSnapshot:snapshot.getChildren())
                {
                    Event event = itemSnapshot.getValue(Event.class);
                    switch(event.getSport()) {
                        case "Volleyball":
                            volleyballList.add(event);
                            break;
                        case "Football":
                            footballList.add(event);
                            break;
                        case "Handball":
                            handballList.add(event);
                            break;
                        case "Tennis":
                            tennisList.add(event);
                            break;
                        case "Badminton":
                            badmintonList.add(event);
                            break;
                        case "Ping-Pong":
                            pingpongList.add(event);
                            break;
                        case "Basketball":
                            basketballList.add(event);
                            break;
                        case "Bowling":
                            bowlingList.add(event);
                            break;
                    }


                }
                allCategoryList.add(new AllCategory("Ping Pong Events",pingpongList));
                allCategoryList.add(new AllCategory("Volleyball Events",volleyballList));
                allCategoryList.add(new AllCategory("Basketball Events",basketballList));
                allCategoryList.add(new AllCategory("Bowling Events",bowlingList));
                allCategoryList.add(new AllCategory("Handball Events",handballList));
                allCategoryList.add(new AllCategory("Football Events",footballList));
                allCategoryList.add(new AllCategory("Badminton Events",badmintonList));
                allCategoryList.add(new AllCategory("Tennis Events",tennisList));
                setParentRecycler(allCategoryList);
                parentAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });
        ///end of retrieve data from firebase


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




        ///beginning filter
        autoCompleteTextView =findViewById(R.id.auto_complete_txt);
        adapterItems= new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(BottomNavActivity.this,"Filter: " + item,Toast.LENGTH_SHORT).show();

                ArrayList<AllCategory> filteredList = new ArrayList<>();
                if (item.isEmpty() || item.equals("All")) {
                    filteredList.addAll(allCategoryList);
                } else {
                    for (AllCategory category : allCategoryList) {
                        ArrayList<Event> filteredEvents = new ArrayList<>();
                        for (Event event : category.getEventList()) {
                            if (item.equals("2 players") && event.getNrPlayers().contains("2")) {
                                filteredEvents.add(event);
                            }
                            else if (item.equals("<= 4 players") && (event.getNrPlayers().contains("1") || event.getNrPlayers().contains("2") ||
                                    event.getNrPlayers().contains("3")||event.getNrPlayers().contains("4"))) {
                                filteredEvents.add(event);
                            }
                            else if (item.equals("<= 6 players") && (!event.getNrPlayers().contains("7")  && !event.getNrPlayers().contains("8"))) {
                                filteredEvents.add(event);
                            }
                        }
                        if (!filteredEvents.isEmpty()) {
                            filteredList.add(new AllCategory(category.getTitle(), filteredEvents));
                        }
                    }
                }
                setParentRecycler(filteredList);
            }
        });

        ///end filter

    }


    ///recyclerview
    private void setParentRecycler(ArrayList<AllCategory> allCategoryList)
    {
        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentAdapter = new ParentAdapterBottom(allCategoryList,this);
        recyclerView.setAdapter(parentAdapter);
    }

    ///end recyclerview


}