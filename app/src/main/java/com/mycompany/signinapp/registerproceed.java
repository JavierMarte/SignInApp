package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class registerproceed extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerproceed);

    }


    public void onetime(View view) {

        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");


        System.out.println("hello");
        //addListenerForSingleValueEvent()
        //myFirebaseRef.child("OneTimeCodes").child(clubname.getText().toString()).child("owner name").setValue(ownername.getText().toString());

        //Firebase ref =  myFirebaseRef.child("OneTimeCodes").child("12304").getRef();

       // System.out.println(val);


        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());


                Toast.makeText(getApplicationContext(),"uploaded to server!!", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(getApplicationContext(),"error uploading to server!!", Toast.LENGTH_SHORT).show();

            }


        });



//12304

//        if ((clubname.getText().length() == 0 || schoolemail.getText().length() == 0) || (schoolemail.getText().length() == 0 || schoolemail.getText().length() == 0)) {
//
//            Toast.makeText(getApplicationContext(), "error!!", Toast.LENGTH_SHORT).show();
//        } else {
//
//
//            myFirebaseRef.child("OneTimeCodes").child(clubname.getText().toString()).child("owner name").setValue(ownername.getText().toString());
//            String val =  myFirebaseRef.child("OneTimeCodes").child("12345").getKey();
//            System.out.println(val);
//         //   myFirebaseRef.child("OneTImeCodes").child(clubname.getText().toString()).child("studentid").setValue(id.getText().toString());
//          //  myFirebaseRef.child("OneTImeCodes").child(clubname.getText().toString()).child("schoolemail").setValue(schoolemail.getText().toString());
//
//
//        }

        //code exist

        if(false){
            //make sure to delete otc later
            //the otc should have club info with it

            //
            Intent intent = new Intent(this, createaccount.class);

            startActivity(intent);

        }else{

            //wrong code
        }





    }


}
