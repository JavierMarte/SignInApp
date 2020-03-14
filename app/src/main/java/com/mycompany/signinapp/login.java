package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class login extends AppCompatActivity {

 
    EditText username;
    EditText password;
   // EditText cellphone;
  //  EditText schoolemail;

    private FirebaseAuth mAuth;
    private DatabaseReference mFirebaseDatabase;
    private EditText mEmailField;
    private EditText  mPasswordField;
    String TAG = "i";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();
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

                            mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("usernames").child(user.getUid());
                            Log.d(TAG, mFirebaseDatabase.toString());
                            Log.d(TAG, "before memberexec");

                            memberorexec(mFirebaseDatabase, user.getUid());
                            Log.d(TAG, "after memberexec");


                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                           // Log.v();
                            Toast.makeText(login.this, "Authentication failed.",
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


    public void memberorexec(DatabaseReference auth, final String uid) {

        Log.d(TAG, "before auth.addListenerForSingleValueEvent");
        auth.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {

                String userwithoutdot = username.getText().toString().replaceAll("\\.", ",");;

                System.out.println(userwithoutdot);

                Log.d(TAG, "before auth.addListenerForSingleValueEvent");
                if(dataSnapshot.child(userwithoutdot).exists()){

                    System.out.println("in here");
                    System.out.println(dataSnapshot.child(userwithoutdot).child("status").getValue().toString());

                    Toast.makeText(getApplicationContext(),"succesful!!!", Toast.LENGTH_SHORT).show();
                    //if member go to member screen

                    if(dataSnapshot.child(userwithoutdot).child("status").getValue().toString().equals("member")){

                        //if member go to member screen
                        String tag = dataSnapshot.child(userwithoutdot).child("club").getValue().toString();

                        Intent i = new Intent(login.this, memberscreen.class);
                        i.putExtra("clubSelection", tag);
                        startActivity(i);

                    }else if(dataSnapshot.child(userwithoutdot).child("status").getValue().toString().equals("Executive")){
                        //if exec go to analtic or signint

                        Intent i = new Intent(login.this, analytics_signin.class);
                        startActivity(i);
                    }



                }

                Log.d(TAG, "id2->"+ dataSnapshot.getValue().toString());
                //dataSnapshot.getChildren();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });



    }


    public void proceed(View view) {



        password = (EditText) findViewById(R.id.password);

        username = (EditText) findViewById(R.id.email);


        signIn(username.getText().toString(), password.getText().toString());



    }

}
