package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


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



//        Firebase.setAndroidContext(this);
//
//        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");
//
//
        password = (EditText) findViewById(R.id.editText8);
        username = (EditText) findViewById(R.id.editText12);
       // cellphone = (EditText) findViewById(R.id.editcellphone);
       // schoolemail = (EditText) findViewById(R.id.editschoolemail);

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
//
//        myFirebaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                System.out.println(dataSnapshot.getValue());
//                schoolemail.getText().clear();
//                name.getText().clear();
//                studentid.getText().clear();
//                cellphone.getText().clear();
//                Toast.makeText(getApplicationContext(),"uploaded to server!!", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//                Toast.makeText(getApplicationContext(),"error uploading to server!!", Toast.LENGTH_SHORT).show();
//
//            }
//
//
//        });





    }

}
