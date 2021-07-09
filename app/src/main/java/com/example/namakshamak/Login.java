package com.example.namakshamak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mlogin_btn;
    TextView mCreateBtn,ResetPassword;
    // space for new here sign up button
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.editTextTextPersonName);
        mPassword = findViewById(R.id.editTextTextPassword);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }
        mlogin_btn = findViewById(R.id.lgn);
        mCreateBtn = findViewById(R.id.signin);
        ResetPassword = findViewById(R.id.resetpass);

        mlogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }

            private void loginUser() {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if(!password.isEmpty()){
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Logged In", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Login.this, Home.class));
                                        finish();
                                    }else{
                                        mPassword.setError("Please enter correct password");
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this, "Login Error", Toast.LENGTH_SHORT).show();
                        }
                        });
                    }else{
                        mPassword.setError("Please enter correct password");
                    }
                }else{
                    mEmail.setError("Please enter correct email");
                }
            }
        });
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });
        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetmail = new EditText(v.getContext());
                final AlertDialog.Builder PasswordResetDialogue = new AlertDialog.Builder(v.getContext());
                PasswordResetDialogue.setTitle("Reset Password");
                PasswordResetDialogue.setMessage("Enter your email to receive reset link");
                PasswordResetDialogue.setView(resetmail);

                PasswordResetDialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetmail.getText().toString();
                        auth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Login.this, "Reset Link set to your mail", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull  Exception e) {
                                Toast.makeText(Login.this, "Error ! Reset link is Not sent "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                PasswordResetDialogue.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                PasswordResetDialogue.create().show();
            }
        });
    }






}