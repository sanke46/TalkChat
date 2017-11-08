package com.sanke.ilafedoseev.talkchat.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sanke.ilafedoseev.talkchat.MainActivity;
import com.sanke.ilafedoseev.talkchat.R;
import com.sanke.ilafedoseev.talkchat.Model.User;


/**
 * Created by ilafedoseev on 04/10/2017.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RegistrationActivity";

    // Registration input
    private EditText newUserName;
    private EditText newUserEmail;
    private EditText newUserPassword;
    private Button btnCreateAccount;
    private boolean status = true;

    // Firebase instance
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        // Test of login user or not
        if (mAuth.getCurrentUser() != null) {
            finish();
            Log.v(TAG,"** USER arleady login **");
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        newUserName = (EditText) findViewById(R.id.newUserName);
        newUserEmail = (EditText) findViewById(R.id.newUserEmail);
        newUserPassword = (EditText) findViewById(R.id.newUserPassword);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCreateAccount) {
            registration(newUserName.getText().toString(), newUserEmail.getText().toString(), newUserPassword.getText().toString());
        }
    }

    /** Registration method */
    public void registration(String name, String email, String password) {

        Log.d(TAG, "onClick: Submit pressed.");
        name = newUserName.getText().toString().trim();
        email = newUserEmail.getText().toString().trim();
        password  = newUserPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this,"Please enter name",Toast.LENGTH_SHORT).show();
            return;
        } else if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        } else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        final String finalName = name;
        final String finalPassword = password;
        final String finalEmail = email;

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String userID = user.getUid();
                    User userInformation = new User(finalName, finalPassword, finalEmail,status);
                    myRef.child(userID).setValue(userInformation);
                    Toast.makeText(RegistrationActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registration is fail, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
