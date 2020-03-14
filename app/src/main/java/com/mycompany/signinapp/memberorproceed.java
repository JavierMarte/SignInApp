package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class memberorproceed extends AppCompatActivity {
    Button[] btnWord = new Button[5];
    LinearLayout linear;
    private Firebase myFirebaseRef;
    Iterable<DataSnapshot> list;

    int size;

    public static final String TAG = "signIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberproceeed);
        Firebase.setAndroidContext(this);

        myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/clubs");

        //Intent intent = getIntent();

       // final String url = intent.getStringExtra("FIREBASE_URL");
       // final String boardId = intent.getStringExtra("BOARD_ID");
        //username =boardId;
        //Log.i(TAG, "url:"+url+" for boardId "+boardId);



        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //dataSnapshot.child("clubs").getChildrenCount();
//dataSnapshot.child("clubs").getChildrenCount()
                System.out.println("clubs->");
                System.out.println(dataSnapshot.getChildrenCount());

                size = (int) dataSnapshot.getChildrenCount();

                list = dataSnapshot.getChildren();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //User user = snapshot.getValue(User.class);
                    System.out.println(snapshot.getKey());
                }
                System.out.println(list);
                //System.out.println(list.forEach(list));
                test();
                }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });







    }
    private void test() {

        linear = (LinearLayout) findViewById(R.id.linear);




        if(size > 0){
            int i = 0;
            for (DataSnapshot snapshot : list) {
                //User user = snapshot.getValue(User.class);
                btnWord[i] = new Button(this);
                btnWord[i].setHeight(50);
                btnWord[i].setWidth(50);
                btnWord[i].setTag(snapshot.getKey());
                btnWord[i].setText(snapshot.getKey());
                btnWord[i].setOnClickListener(btnClicked);
                linear.addView(btnWord[i]);
                System.out.println(snapshot.getKey());
                i++;
            }

        }else{

                System.out.println("no size");

        }

    }
    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Object tag = v.getTag();
            Toast.makeText(getApplicationContext(), "clicked button" + tag.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(memberorproceed.this, createaccount.class);
            intent.putExtra("clubSelection", tag.toString());
            //intent.putExtra("BOARD_ID", key);
            startActivity(intent);
        }
    };

    EditText id;


    public void onetime(View view) {


        Intent intent = new Intent(this, createaccount.class);

        startActivity(intent);


    }


}
