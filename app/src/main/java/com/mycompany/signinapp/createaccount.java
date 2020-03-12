package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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
    }

    EditText username;
    EditText password;
    EditText studentid;
    EditText schoolemail;
    Firebase myFirebaseRef;

    public void finalize(View view) {


        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editTextname);
        studentid = (EditText) findViewById(R.id.editTextID);
        schoolemail = (EditText) findViewById(R.id.editTextID2);

        //Firebase.setAndroidContext(this);

        myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");


        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child("usernames").child(username.getText().toString()).exists()){

                   // Toast.makeText(getApplicationContext(), "username already exists" , Toast.LENGTH_SHORT).show();

                    //print out already exists
                }else{

                    create();
                }




            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });


        /*


        get intent info here
         */





    }



    public void create(){

//check usernames before finalzing to ensure no repeat users
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("club").setValue(tag);
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("email").setValue(schoolemail.getText().toString());
//pull name from prev intent or ask user
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("name").setValue(schoolemail.getText().toString());
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("password").setValue(password.getText().toString());

        //needs to be changed to take either exec member or godtier status maybe get it from previous inteent ot setup different java files of create accoutn
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("status").setValue("member");

        myFirebaseRef.child("usernames").child(username.getText().toString()).child("studentId").setValue(studentid.getText().toString());
        myFirebaseRef.child("usernames").child(username.getText().toString()).child("username").setValue(username.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }


}
