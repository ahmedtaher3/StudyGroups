package com.example.ataher.studygroups;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ataher.studygroups.Helper.HelperMethods;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    EditText userName, userfullname, userPassword, userMail, passwordAgain, userPhone, userlevel, usercollegee;
    Button SignUp_Btn , SignIn_Btn;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        progressDialog = new ProgressDialog(this);


        userName = (EditText) findViewById(R.id.SignUp_input_name);
        userlevel = (EditText) findViewById(R.id.SignUp_input_leveel);
        usercollegee = (EditText) findViewById(R.id.SignUp_input_collegee);
        userfullname = (EditText) findViewById(R.id.SignUp_input_full_name);
        userPassword = (EditText) findViewById(R.id.SignUp_input_password);
        userMail = (EditText) findViewById(R.id.SignUp_input_email);
        passwordAgain = (EditText) findViewById(R.id.SignUp_passwordAgain);
        userPhone = (EditText) findViewById(R.id.SignUp_input_phone);
        SignUp_Btn = (Button) findViewById(R.id.SignUp_signUpBtn);
        SignIn_Btn = (Button) findViewById(R.id.SignUp_signInBtn);

        SignIn_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(SignUp.this, LoginScreen.class);
                startActivity(nextIntent);
            }
        });

        SignUp_Btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void SignUp() {


        final String email = userMail.getText().toString();
        final String password = userPassword.getText().toString();
        final String ConfirmPassword = passwordAgain.getText().toString();
        final String name = userName.getText().toString();
        final String mobile = userPhone.getText().toString();
        final String level = userlevel.getText().toString();
        final String college = usercollegee.getText().toString();
        final String fullname = userfullname.getText().toString();


        progressDialog.setTitle("Pleas Wait");
        progressDialog.setMessage("Signing Up...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(mobile)) {

            if (Objects.equals(password, ConfirmPassword)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                if (!task.isSuccessful()) {

                                    try {
                                        throw task.getException();
                                    } catch (Exception e) {

                                        Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                } else

                                {
                                    try {
                                        String user_id = mAuth.getCurrentUser().getUid();
                                        HelperMethods.User_id = user_id;
                                        DatabaseReference currentuser_db = mDatabase.child(user_id);

                                        currentuser_db.child("username").setValue(name);
                                        currentuser_db.child("email").setValue(email);
                                        currentuser_db.child("mobile").setValue(mobile);
                                        currentuser_db.child("Level").setValue("none");
                                        currentuser_db.child("College").setValue("none");
                                        currentuser_db.child("cover_image").setValue("none");
                                        currentuser_db.child("profile_image").setValue("https://firebasestorage.googleapis.com/v0/b/clashbook-3a339.appspot.com/o/default-user-icon-profile.png?alt=media&token=27cc7679-276a-497e-90a5-b558c26275ab");

                                        Toast.makeText(SignUp.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignUp.this, LoginScreen.class));
                                    } catch (Exception e) {

                                        Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
                                    }


                                }

                                progressDialog.dismiss();

                            }
                        });
            } else {
                Toast.makeText(this, "Your Password not matches", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }

        } else {
            Toast.makeText(this, "Please Complete Credentials", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }

    }

}
