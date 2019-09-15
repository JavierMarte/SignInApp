package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText studentid;
    EditText cellphone;
    EditText schoolemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void enter(View view) {

        //Intent i = new Intent(this, collection.class);
        //startActivity(i);

        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");


        name = (EditText) findViewById(R.id.editname);
        studentid = (EditText) findViewById(R.id.editstudentid);
        cellphone = (EditText) findViewById(R.id.editcellphone);
        schoolemail = (EditText) findViewById(R.id.editschoolemail);


        if(name.getText().length() == 0 || schoolemail.getText().length() == 0){

            Toast.makeText(getApplicationContext(),"error!!", Toast.LENGTH_SHORT).show();
        }else{


        myFirebaseRef.child(name.getText().toString()).child("studentID").setValue(studentid.getText().toString());
        myFirebaseRef.child(name.getText().toString()).child("cellphone").setValue(cellphone.getText().toString());
        myFirebaseRef.child(name.getText().toString()).child("schoolemail").setValue(schoolemail.getText().toString());


        }

        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());
                schoolemail.getText().clear();
                name.getText().clear();
                studentid.getText().clear();
                cellphone.getText().clear();
                Toast.makeText(getApplicationContext(),"uploaded to server!!", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(getApplicationContext(),"error uploading to server!!", Toast.LENGTH_SHORT).show();

            }


        });





    }

}
