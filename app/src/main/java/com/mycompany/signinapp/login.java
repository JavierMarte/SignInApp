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


public class login extends AppCompatActivity {

 
    EditText username;
    EditText password;
   // EditText cellphone;
  //  EditText schoolemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }



    public void proceed(View view) {



        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");


        password = (EditText) findViewById(R.id.editText8);

        username = (EditText) findViewById(R.id.editText12);
       // cellphone = (EditText) findViewById(R.id.editcellphone);
       // schoolemail = (EditText) findViewById(R.id.editschoolemail);

        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                System.out.println(username.getText().toString());


                if(dataSnapshot.child("usernames").child(username.getText().toString()).exists()){

                    System.out.println("in here");
                    System.out.println(dataSnapshot.child("usernames").child(username.getText().toString()).child("status").getValue().toString());

                    Toast.makeText(getApplicationContext(),"succesful!!!", Toast.LENGTH_SHORT).show();
                    //if member go to member screen

                    if(dataSnapshot.child("usernames").child(username.getText().toString()).child("status").getValue().toString().equals("member")){

                            //if member go to member screen
                        String tag = dataSnapshot.child("usernames").child(username.getText().toString()).child("club").getValue().toString();

                        Intent i = new Intent(login.this, memberscreen.class);
                        i.putExtra("clubSelection", tag);
                        startActivity(i);

                    }else if(dataSnapshot.child("usernames").child(username.getText().toString()).child("status").getValue().toString().equals("Executive")){
                            //if exec go to analtic or signint

                        Intent i = new Intent(login.this, analytics_signin.class);
                        startActivity(i);
                    }






                }



            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(getApplicationContext(),"error uploading to server!!", Toast.LENGTH_SHORT).show();

            }


        });


        System.out.println(password.getText().toString());

       // String passwordstr = password.getText().toString();
        if(password.getText().length() == 0 || username.getText().length() == 0){

            Toast.makeText(getApplicationContext(),"error!!", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(getApplicationContext(),password.getText(), Toast.LENGTH_SHORT).show();
                if(password.getText().toString().equals("1")){

                    System.out.println("in here");
                    //go to anal and signin
                    //if exec status go to anal and signin
                    Intent i = new Intent(this, analytics_signin.class);
                    startActivity(i);

                }

                if(false){


                    //if member go to qr code
                }


        }





    }

}
