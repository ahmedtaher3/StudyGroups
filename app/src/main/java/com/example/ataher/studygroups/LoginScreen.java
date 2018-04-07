package com.example.ataher.studygroups;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ataher.studygroups.Helper.HelperMethods;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginScreen extends AppCompatActivity {

     Button SignUp , SignIn ;
    EditText EmailEditText, passwordEditText;
    TextView reset_pass;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    ProgressBar progressBar ;
    String full_name;
    String fb_user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();
        EmailEditText = (EditText) findViewById(R.id.loginScreen_input_username);
        passwordEditText = (EditText) findViewById(R.id.loginScreen_input_password);
        SignUp = (Button) findViewById(R.id.loginScreen_signUpBtn);
        SignIn = (Button) findViewById(R.id.loginScreen_signInBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginScreen.this , SignUp.class));

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             login();

            }
        });


        }

    private void login() {

        String email = EmailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            HelperMethods.showDialog(LoginScreen.this , "please Wait" , "Login in...");

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {

                                Toast.makeText(LoginScreen.this, task.getException().toString(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(LoginScreen.this, Home.class));
                                HelperMethods.hideDialog(LoginScreen.this );
                            }

                        }
                    });


        } else {
            Toast.makeText(this, "Please Complete Credentials", Toast.LENGTH_LONG).show();
        }

    }
}
