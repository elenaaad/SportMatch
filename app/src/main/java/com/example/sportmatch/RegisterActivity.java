package com.example.sportmatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextPassword2;
    EditText editTextBirthDate;
    EditText editTextFullName;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupButtonClicked(v);
            }
        });

        editTextUsername =(EditText) findViewById(R.id.register_username);
        editTextPassword =(EditText) findViewById(R.id.register_password);
        editTextPassword2 =(EditText) findViewById(R.id.register_password2);
        editTextBirthDate =(EditText) findViewById(R.id.register_birthdate);
        editTextFullName =(EditText) findViewById(R.id.register_fullname);
        mAuth = FirebaseAuth.getInstance();
    }
    //check if the username is already in use - copiat de pe stackoverflow
    //https://stackoverflow.com/questions/61523624/android-firebase-database-check-if-username-is-already-use
    public void isValidUsername(UserExistsCallback callback) {
        String username = editTextUsername.getText().toString();
        FirebaseDatabase.getInstance().getReference().child("users").orderByChild("username").equalTo(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    callback.onCallback(false);
                    editTextUsername.setError("This username already exists");
                } else {
                    callback.onCallback(true);
                    Log.d("createUsername", "true");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException(); // never ignore errors
            }
        });
    }
    public void signupButtonClicked(View v){
        String txtUserName = editTextUsername.getText().toString().trim();
        String txtPassword = editTextPassword.getText().toString().trim();
        String txtPassword2 = editTextPassword2.getText().toString().trim();
        String txtBirthDate = editTextBirthDate.getText().toString().trim();
        String txtFullName = editTextFullName.getText().toString().trim();

        if(txtUserName.isEmpty() ){
            editTextUsername.setError("Please enter all the fields");
            editTextUsername.requestFocus();
        }
        else if(txtPassword.isEmpty()){
            editTextPassword.setError("Please enter all the fields");
            editTextUsername.requestFocus();
        }
        else if(txtPassword2.isEmpty()){
            editTextPassword2.setError("Please enter all the fields");
            editTextUsername.requestFocus();
        }
        else if(txtBirthDate.isEmpty()){
            editTextBirthDate.setError("Please enter all the fields");
            editTextUsername.requestFocus();
        }
        else if(txtFullName.isEmpty()) {
            editTextFullName.setError("Please enter all the fields");
            editTextUsername.requestFocus();
        }
        //else if(txtPassword.equals(txtPassword2)){
        //    editTextPassword.setError("Passwords do not match");
        //    editTextPassword2.setError("Passwords do not match");
        //}
        else{
            //check if the username is already in use
            isValidUsername(new UserExistsCallback() {
                @Override
                public void onCallback(boolean exists) {
                    System.out.println("User exists: "+exists);
                }
            });
            //create the user in the database - generated with copilot
            mAuth.createUserWithEmailAndPassword(txtUserName,txtPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                User user = new User(txtUserName, txtPassword, txtBirthDate, txtFullName);
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(RegisterActivity.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                                    Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                    //startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                                } else {
                                                    Toast.makeText(RegisterActivity.this, "User failed to register", Toast.LENGTH_LONG).show();

                                                    //display a failure message
                                                }
                                            }
                                        });
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, "User failed to register", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }
    }
}