package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class registeractivity extends AppCompatActivity {

 
    EditText username;
    EditText password;
   // EditText cellphone;
  //  EditText schoolemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }



    public void proceed(View view) {



//        Firebase.setAndroidContext(this);
//
//        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");
//
//
        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.password);
       // cellphone = (EditText) findViewById(R.id.editcellphone);
       // schoolemail = (EditText) findViewById(R.id.editschoolemail);

        System.out.println(password.getText().toString());
        if(password.getText().length() == 0 || username.getText().length() == 0){

            Toast.makeText(getApplicationContext(),"error!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),password.getText(), Toast.LENGTH_SHORT).show();

                if(password.equals("1")){
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);

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
