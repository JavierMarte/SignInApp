package com.mycompany.signinapp;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.firebase.client.Firebase;

public class clubapproval extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    EditText clubname;
    EditText ownername;
    EditText id;
    EditText schoolemail;

    public void approvalclick(View view) {


        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");


        clubname = (EditText) findViewById(R.id.editText);
        ownername = (EditText) findViewById(R.id.editText2);
        id = (EditText) findViewById(R.id.editTextname);
        schoolemail = (EditText) findViewById(R.id.editTextID);



        if ((clubname.getText().length() == 0 || schoolemail.getText().length() == 0) || (schoolemail.getText().length() == 0 || schoolemail.getText().length() == 0)) {

            Toast.makeText(getApplicationContext(), "error!!", Toast.LENGTH_SHORT).show();
        } else {


            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("owner").setValue(ownername.getText().toString());
            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("studentid").setValue(id.getText().toString());
            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("schoolemail").setValue(schoolemail.getText().toString());


        }


    }

}
