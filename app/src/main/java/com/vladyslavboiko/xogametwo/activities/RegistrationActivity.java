package com.vladyslavboiko.xogametwo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladyslavboiko.xogametwo.R;
import com.vladyslavboiko.xogametwo.UserAuthException;
import com.vladyslavboiko.xogametwo.VerifyEditTextValues;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailET;
    private EditText nickNameET;
    private EditText passET;
    private EditText rtPassEt;

    private Button regButton;

    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailET = (EditText) findViewById(R.id.reg_email_edittext);
        nickNameET = (EditText) findViewById(R.id.reg_nickname_edittext);
        passET = (EditText) findViewById(R.id.reg_password_edittext);
        rtPassEt = (EditText) findViewById(R.id.reg_password_ret_edittext);

        regButton = (Button) findViewById(R.id.register_button);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String pass = passET.getText().toString();
                String email = emailET.getText().toString();
                String username = nickNameET.getText().toString();
                if (pass.equals(rtPassEt.getText().toString())) {
                    try {
                        VerifyEditTextValues.verifyComplex(email, username, pass);
                        registrationOnClick();
                    } catch (UserAuthException e) {
                        e.printStackTrace();
                        Toast.makeText(RegistrationActivity.this, e.getAuthExceptionCause(), Toast.LENGTH_SHORT).show();
                    }
                }else Toast.makeText(RegistrationActivity.this, "NOT EQUAL", Toast.LENGTH_SHORT).show();
            }
        });

        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        mAuthListener = new com.google.firebase.auth.FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(RegistrationActivity.this, LogInActivity.class);
                    startActivity(intent);
                } else {
                }
            }
        };
        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();
    }


    public void registrationOnClick() {
        mAuth.createUserWithEmailAndPassword(emailET.getText().toString(), passET.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Успешно зарегистрирован!", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            mRef.child("Users").child(user.getUid()).child("Name").setValue(nickNameET.getText().toString());
                        } else
                            Toast.makeText(RegistrationActivity.this, R.string.reg_err, Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
