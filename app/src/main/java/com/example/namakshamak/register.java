package com.example.namakshamak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class register extends AppCompatActivity {

    public static final String TAG1 = "TAG";
    public static final String TAG = "TAG";
    // email password reg
    private EditText Name, Email, pass;
    private TextView TextView;
    private Button RegisterButton;



    //userID
    String userID;

    //for custom login method by password and email :))
    TextView mlogin;

    //button for google sign in
    Button b1;
    //button for facebook sign in
    private LoginButton loginButton;
    CallbackManager callbackManager;

    int RC_SIGN_IN = 65;

    //firebase auth instance
    private FirebaseAuth auth;
    // google sign in client
    GoogleSignInClient mGoogleSignInClient;

    //firestore
    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_register);
        // connection our instance buttons/textviews to the buttons/textviews on activity_register.xml
        Name = findViewById(R.id.editTextTextPersonName2);
        Email = findViewById(R.id.editTextTextPersonName3);
        pass = findViewById(R.id.editTextTextPassword3);
        TextView = findViewById(R.id.textView);
        RegisterButton = findViewById(R.id.button5);
        //for custom login
        mlogin = findViewById(R.id.logindir);

        //firestore instantiation
        firestore = FirebaseFirestore.getInstance();



        //facebook button linking
        loginButton = findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //1st method for authorizing login through facebook
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                firebaseAuthWithFacebook(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
            }
        });


        //linking buttons for google
        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUSer();
            }
        });

        //initializing auth
        auth = FirebaseAuth.getInstance();


    }
    //creating/registering user through our email and password
    private void createUSer() {
        String email = Email.getText().toString();
        String password = pass.getText().toString();
        String fullname = Name.getText().toString().trim();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty() && password.length()>6) {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                //
                                userID = auth.getCurrentUser().getUid();
                                DocumentReference documentReference = firestore.collection("users").document(userID);
                                Map<String,Object> user = new HashMap<>();
                                user.put("fname",Name);
                                user.put("email",email);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d("TAG","onSuccess: user profile created for"+userID);
                                    }public void onFailure(@NonNull Exception e){
                                        Log.d("TAG","onFailure"+e.toString());
                                    }
                                });
                                startActivity(new Intent(register.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register.this, "Registration Error", Toast.LENGTH_SHORT).show();

                    }
                });
            } else {
                pass.setError("Password should greater than 6 characters");
            }
        } else if (email.isEmpty()) {
            Email.setError("Empty fields are not allowed");
        } else {
            Email.setError("Please enter correct email");
        }
        //what happens after clicking on register button
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }


    public void gotlog(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }

    // signing in using google
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // onActivityResult for google and facebook authorizing
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode,resultCode,data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    // for google auth
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = auth.getCurrentUser();

                            Intent intent = new Intent(register.this, Home.class);
                            startActivity(intent);
                            Toast.makeText(register.this, "Sign in with google", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(register.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    // for facebook auth
    private void firebaseAuthWithFacebook(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        final AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Logged In with Facebook", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(register.this, Home.class);
                            startActivity(intent);
                        }
                    }
                });
    }

}