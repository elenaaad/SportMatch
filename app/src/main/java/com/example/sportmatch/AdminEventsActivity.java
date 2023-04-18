package com.example.sportmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AdminEventsActivity extends AppCompatActivity {

    ///recyclerview
    RecyclerView recyclerView;
    ParentAdapter parentAdapter;
    ArrayList<AllCategory> allCategoryList;
    ArrayList<CategoryItemClass> childModelClassList;
    ArrayList<CategoryItemClass> volleyballList;
    ArrayList<CategoryItemClass> footballList;
    ArrayList<CategoryItemClass> handballList;
    ArrayList<CategoryItemClass> tennisList;
    ArrayList<CategoryItemClass> badmintonList;
    ArrayList<CategoryItemClass> pingpongList;
    ArrayList<CategoryItemClass> basketballList;
    ArrayList<CategoryItemClass> bowlingList;
    ///end recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_events);


        ///recyclerview
        allCategoryList =new ArrayList<>();
        volleyballList =new ArrayList<>();
        footballList =new ArrayList<>();
        tennisList =new ArrayList<>();
        handballList =new ArrayList<>();
        basketballList =new ArrayList<>();
        pingpongList =new ArrayList<>();
        bowlingList = new ArrayList<>();
        badmintonList=new ArrayList<>();

        volleyballList.add(new CategoryItemClass(R.drawable.p3));
        volleyballList.add(new CategoryItemClass(R.drawable.p3));
        volleyballList.add(new CategoryItemClass(R.drawable.p3));
        volleyballList.add(new CategoryItemClass(R.drawable.p3));
        volleyballList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Volleyball Events",volleyballList));


        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        basketballList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Basketball Events",basketballList));


        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        tennisList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Tennis Events",tennisList));

        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        badmintonList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Badminton Events",badmintonList));


        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        footballList.add(new CategoryItemClass(R.drawable.p3 ));
        allCategoryList.add(new AllCategory("Football Events",footballList));


        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        handballList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Handball Events",handballList));


        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        bowlingList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Bowling Events",bowlingList));



        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        pingpongList.add(new CategoryItemClass(R.drawable.p3));
        allCategoryList.add(new AllCategory("Ping Pong Events",pingpongList));

        setParentRecycler(allCategoryList);
        ///end recyclerview

        ////inceput meniu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_admin_events);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_admin_events:
                    return true;
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), BottomNavActivity.class));
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
        ////final meniu
    }
    ///recyclerview
    private void setParentRecycler(ArrayList<AllCategory> allCategoryList)
    {
        recyclerView = findViewById(R.id.main_recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentAdapter = new ParentAdapter(allCategoryList,this);
        recyclerView.setAdapter(parentAdapter);
    }
    ///end recyclerview
}