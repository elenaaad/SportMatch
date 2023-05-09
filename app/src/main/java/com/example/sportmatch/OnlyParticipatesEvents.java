package com.example.sportmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OnlyParticipatesEvents extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EventAdapter eventAdapter;
    DatabaseReference eventsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_participates_events);

        mRecyclerView = findViewById(R.id.main_recycler2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getParticipantEvents();

    }

    private void getParticipantEvents() {
        eventsRef= FirebaseDatabase.getInstance().getReference("Events");
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        eventsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Event> events = new ArrayList<>();

                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    Event event = eventSnapshot.getValue(Event.class);
                    if (event.getParticipants() != null && event.getParticipants().contains(userId)) {
                        events.add(event);
                    }

                }
                eventAdapter = new EventAdapter(events);
                eventAdapter.setOnChatClickListener(OnlyParticipatesEvents.this::onChatClick);
                mRecyclerView.setAdapter(eventAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TAG", "Failed to read value.", databaseError.toException());
            }
        });

    }

    public void onChatClick(String eventId) {
        if (eventId != null) {
            Log.d("eventId", eventId);
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("eventId", eventId);
            startActivity(intent);
            /////aici crapa

        } else {
            Log.e("eventId", "Event ID is null");
        }
    }
    private void openChatActivity(Event event) {
        // Implement the logic to launch the ChatActivity when the user clicks on a button
        // associated with an event card.
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("event_title", event.getEventName());
        startActivity(intent);
    }
//
//    ///recyclerview
////    RecyclerView recyclerView;
////    ParentAdapter parentAdapter;
////    ArrayList<AllCategory> allCategoryList;
////    ArrayList<CategoryItemClass> childModelClassList;
////    ArrayList<CategoryItemClass> volleyballList;
////    ArrayList<CategoryItemClass> footballList;
////    ArrayList<CategoryItemClass> handballList;
////    ArrayList<CategoryItemClass> tennisList;
////    ArrayList<CategoryItemClass> badmintonList;
////    ArrayList<CategoryItemClass> pingpongList;
////    ArrayList<CategoryItemClass> basketballList;
////    ArrayList<CategoryItemClass> bowlingList;
////    ///end recyclerview
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_only_participates_events);
////        ////inceput meniu
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setSelectedItemId(R.id.bottom_events_participates);
////
////        ///recyclerview
////        allCategoryList =new ArrayList<>();
////        volleyballList =new ArrayList<>();
////        footballList =new ArrayList<>();
////        tennisList =new ArrayList<>();
////        handballList =new ArrayList<>();
////        basketballList =new ArrayList<>();
////        pingpongList =new ArrayList<>();
////        bowlingList = new ArrayList<>();
////        badmintonList=new ArrayList<>();
////
////        volleyballList.add(new CategoryItemClass(R.drawable.p3));
////        volleyballList.add(new CategoryItemClass(R.drawable.p3));
////        volleyballList.add(new CategoryItemClass(R.drawable.p3));
////        volleyballList.add(new CategoryItemClass(R.drawable.p3));
////        volleyballList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Volleyball Events",volleyballList));
////
////
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        basketballList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Basketball Events",basketballList));
////
////
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        tennisList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Tennis Events",tennisList));
////
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        badmintonList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Badminton Events",badmintonList));
////
////
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        footballList.add(new CategoryItemClass(R.drawable.p3 ));
////        allCategoryList.add(new AllCategory("Football Events",footballList));
////
////
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        handballList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Handball Events",handballList));
////
////
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        bowlingList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Bowling Events",bowlingList));
////
////
////
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        pingpongList.add(new CategoryItemClass(R.drawable.p3));
////        allCategoryList.add(new AllCategory("Ping Pong Events",pingpongList));
////
////        setParentRecycler(allCategoryList);
////        ///end recyclerview
//
//
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.bottom_events_participates:
//                return true;
//                case R.id.bottom_admin_events:
//                    startActivity(new Intent(getApplicationContext(), AdminEventsActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_create_event:
//                    startActivity(new Intent(getApplicationContext(), CreateEventActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_view_profile:
//                    startActivity(new Intent(getApplicationContext(), ViewProfileActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_home:///bottom_home corespunde clasei BottomNavActivity
//                    startActivity(new Intent(getApplicationContext(), BottomNavActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//            }
//            return false;
//        });
//        ////final meniu
//
//
//    }
//    ///recyclerview
////    private void setParentRecycler(ArrayList<AllCategory> allCategoryList)
////    {
////        recyclerView = findViewById(R.id.main_recycler2);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
////        parentAdapter = new ParentAdapter(allCategoryList,this);
////        recyclerView.setAdapter(parentAdapter);
////    }
//    ///end recyclerview
}