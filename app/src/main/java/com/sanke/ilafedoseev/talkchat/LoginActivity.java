package com.sanke.ilafedoseev.talkchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by ilafedoseev on 03/10/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText emailUser;
    private EditText passwodUser;
    private Button btnLogin;
    private TextView btnRegistration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "No user is logged in");
                } else {
                    // User is signed out
                    Log.d(TAG, "User is already logged in");
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                // ...
            }
        };

        if (mAuth == null) {
            Log.d(TAG, "No user is logged in");
        } else {
            Log.d(TAG, "User is already logged in");
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        emailUser = (EditText) findViewById(R.id.userEmail);
        passwodUser = (EditText) findViewById(R.id.userPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistration = (TextView) findViewById(R.id.btnRegistration);

        btnLogin.setOnClickListener(this);
        btnRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            singIn(emailUser.getText().toString(), passwodUser.getText().toString());
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        } else if (view.getId() == R.id.btnRegistration) {
            reaistration(emailUser.getText().toString(), passwodUser.getText().toString());
        }
    }

    public void singIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login complete", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login is fail, try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void reaistration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Registration complete", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Registration is fail, try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
