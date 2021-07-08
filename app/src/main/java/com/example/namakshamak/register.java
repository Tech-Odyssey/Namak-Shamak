package com.example.namakshamak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {

    // email password reg
    private EditText Name,Email,pass;
    private TextView TextView;
    private Button RegisterButton;
    TextView mlogin;

    //firebase auth instance
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_register);

        Name = findViewById(R.id.editTextTextPersonName2);
        Email = findViewById(R.id.editTextTextPersonName3);
        pass = findViewById(R.id.editTextTextPassword3);
        TextView = findViewById(R.id.textView);
        RegisterButton = findViewById(R.id.button5);
        mlogin = findViewById(R.id.login);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUSer();
            }
        });

        //initializing auth
        auth = FirebaseAuth.getInstance();


    }
    private void createUSer(){
        String email = Email.getText().toString();
        String password = pass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!password.isEmpty()){
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register.this, "Registration Error", Toast.LENGTH_SHORT).show();

                    }
                });
            }else{
                pass.setError("Empty fields are not allowed");
            }
        }else if (email.isEmpty()){
            Email.setError("Empty fields are not allowed");
        }else{
            Email.setError("Please enter correct email");
        }
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }


    public void gotlog(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}