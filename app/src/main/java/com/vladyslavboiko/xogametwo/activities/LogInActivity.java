package com.vladyslavboiko.xogametwo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vladyslavboiko.xogametwo.R;
import com.vladyslavboiko.xogametwo.UserAccount;

public class LogInActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    private EditText mMailEditText;
    private EditText mPassEditText;

    private Button logInButton;
    private Button registerButton;

    private TextView forgetPassText;

    private UserAccount user;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar_login);
        mMailEditText = (EditText) findViewById(R.id.editText);
        mPassEditText = (EditText) findViewById(R.id.editText2);

        logInButton = (Button) findViewById(R.id.log_in_button);
        registerButton = (Button) findViewById(R.id.register_button);

        forgetPassText = (TextView) findViewById(R.id.log_forget);

        //Firebase objects to AUTH
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    //Signed in
                } else { ///not sined in
                }
            }
        };

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mMailEditText.getText().toString();
                String pass = mPassEditText.getText().toString();

                createUser();
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mMailEditText.getText().toString();
                String pass = mPassEditText.getText().toString();

                logInUser(email, pass);
            }
        });

    }

    private void createUser() {
        Intent goForRegister = new Intent(this, RegistrationActivity.class);
        startActivity(goForRegister);
    }

    public void logInUser(String email, String passcode) {
        //progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, passcode).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser mUser = mAuth.getCurrentUser();
                    user = new UserAccount(mUser.getEmail(), mUser.getDisplayName());
                    Intent menuIntent = new Intent(LogInActivity.this, MainMenuActivity.class);
                    startActivity(menuIntent);

                } else {
                  //  progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LogInActivity.this, "cant log in", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        mAuth.addAuthStateListener(mAuthListener);

        super.onStart();
    }

    @Override
    protected void onStop() {

        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {


        super.onSaveInstanceState(outState);
    }
}
