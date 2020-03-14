package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createaccount extends AppCompatActivity {
    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);

        TextView  club = (TextView) findViewById(R.id.textView9);
        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        tag = getIntent().getStringExtra("clubSelection");
        club.setText(tag);
        System.out.println(sessionId);
        mAuth = FirebaseAuth.getInstance();

    }

    EditText username;
    EditText password;
    EditText studentid;
    EditText schoolemail;
    Firebase myFirebaseRef;

    private DatabaseReference mFirebaseDatabase;

    private FirebaseAuth mAuth;
    String TAG = "i";
    public void finalize(View view) {


        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editTextname);
        studentid = (EditText) findViewById(R.id.editTextID);
        schoolemail = (EditText) findViewById(R.id.editTextID2);

        //Firebase.setAndroidContext(this);

       //myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");

        createAccount(username.getText().toString(), password.getText().toString());

/*
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child("usernames").child(username.getText().toString()).exists()){

                   // Toast.makeText(getApplicationContext(), "username already exists" , Toast.LENGTH_SHORT).show();

                    //print out already exists
                }else{
                    createAccount(username.getText().toString(), password.getText().toString());

                    //create();
                }




            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });

*/
        /*


        get intent info here
         */





    }

    private void createAccount(final String email, final String password) {
        Log.d(TAG, "createAccount:" + email);
//        if (!validateForm()) {
//            return;
//        }
//
//        showProgressBar();

        // [START create_user_with_email]

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                           // mAuth.signInWithCredential(task.);

                            Toast.makeText(createaccount.this, "Authentication success.",Toast.LENGTH_SHORT).show();

                            mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("usernames");
                            signIn(user.getEmail(),  password);


                           // updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(createaccount.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]

                        //hideProgressBar();

                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);

//        if (!validateForm()) {
//            return;
//        }
//
//        showProgressBar();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d(TAG, user.getUid());
                            Log.d(TAG, user.getEmail());
                            //Log.d(TAG, user.getIdToken(true).getResult().toString());
                            mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("usernames");

                            create(mFirebaseDatabase, user.getUid());
                            //memberorexec(mFirebaseDatabase);



                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            // Log.v();
                            Toast.makeText(createaccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
//                        if (!task.isSuccessful()) {
//                            mStatusTextView.setText(R.string.auth_failed);
//                        }
                        // hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    public void create(DatabaseReference auth, String uid){




//check usernames before finalzing to ensure no repeat users
        String userwithoutdot = username.getText().toString().replaceAll("\\.", ",");


        auth.child(uid).child(userwithoutdot).child("club").setValue(tag);
        auth.child(uid).child(userwithoutdot).child("email").setValue(schoolemail.getText().toString());
//pull name from prev intent or ask user
        auth.child(uid).child(userwithoutdot).child("name").setValue(schoolemail.getText().toString());
        auth.child(uid).child(userwithoutdot).child("password").setValue(password.getText().toString());

        //needs to be changed to take either exec member or godtier status maybe get it from previous inteent ot setup different java files of create accoutn
        auth.child(uid).child(userwithoutdot).child("status").setValue("member");

        auth.child(uid).child(userwithoutdot).child("studentId").setValue(studentid.getText().toString());
        auth.child(uid).child(userwithoutdot).child("username").setValue(username.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }


}
