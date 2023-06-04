package com.example.sportmatch;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private FirebaseAuth mAuth;
    //todo: add a button to go to register activity
    //todo: add a button to go to forgot password activity

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF = "pref";
    private static final String Username = "username";
    private static final String Password = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        usernameEditText = findViewById(R.id.activity_main_usernameEditText);
        passwordEditText = findViewById(R.id.activity_main_passwordEditText);
        loginButton = findViewById(R.id.button_login);
        DatabaseReference usersRef = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);

//        String U = sharedPreferences.getString(Username, null);
//        if(U != null){
//            Intent intent = new Intent(LoginActivity.this, BottomNavActivity.class);
//            startActivity(intent);
//        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    usernameEditText.setError("Please enter a valid email address");
                    usernameEditText.requestFocus();
                }
                if (password.isEmpty()) {
                    passwordEditText.setError("Please enter a password");
                    passwordEditText.requestFocus();
                }
                else {

                    mAuth.signInWithEmailAndPassword(username, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString(Username, username);
                                        editor.putString(Password, password);
                                        editor.apply();


                                        //Request.createRequestTable();
                                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                                        //to chanche the activity to menuactivity
                                        //Intent intent = new Intent(LoginActivity.this, BottomNavActivity.class);
                                        Intent intent = new Intent(LoginActivity.this, BottomNavActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }

            }
        });
    }
}