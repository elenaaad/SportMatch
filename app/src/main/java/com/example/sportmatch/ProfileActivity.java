package com.example.sportmatch;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference userRef = database.getReference("Users").child(userId);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("fullName").getValue(String.class);
                TextView nameTextView = findViewById(R.id.fullname_field);
                nameTextView.setText(name);
                TextInputLayout nameTextInputLayout = findViewById(R.id.full_name_profile);
                TextInputEditText nameEditText = (TextInputEditText) nameTextInputLayout.getEditText();
                nameEditText.setText(name);


                String email = dataSnapshot.child("username").getValue(String.class);
                TextInputLayout emailTextInputLayout = findViewById(R.id.email_profile);
                TextInputEditText emailEditText = (TextInputEditText) emailTextInputLayout.getEditText();
                emailEditText.setText(email);

                String bio = dataSnapshot.child("bio").getValue(String.class);
                TextInputLayout bioTextInputLayout = findViewById(R.id.bio_profile);
                TextInputEditText bioEditText = (TextInputEditText) bioTextInputLayout.getEditText();
                bioEditText.setText(bio);

                String birthdate = dataSnapshot.child("birthDate").getValue(String.class);
                LocalDate birthdateObj = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    birthdateObj = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }
                LocalDate now = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    now = LocalDate.now();
                }
                int varsta = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                     varsta = Period.between(birthdateObj, now).getYears();
                }
                TextInputLayout birthdateTextInputLayout = findViewById(R.id.age_profile);
                TextInputEditText birthdateEditText = (TextInputEditText) birthdateTextInputLayout.getEditText();
                birthdateEditText.setText(String.valueOf(varsta));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });







        Button button_editprofile = (Button)findViewById(R.id.button_editprofile);
        button_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
            }
        });


        Button logoutButton = findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // nimic
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }


}