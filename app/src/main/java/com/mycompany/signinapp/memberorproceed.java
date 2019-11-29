package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class memberorproceed extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberproceeed);
    }

    EditText clubname;
    EditText ownername;
    EditText id;
    EditText schoolemail;

    public void onetime(View view) {


        Intent intent = new Intent(this, createaccount.class);

        startActivity(intent);



        //generate list



     //   ArrayList<String> list = new ArrayList<String>();
      //  list.add("item1");
     //   list.add("item2");

        //instantiate custom adapter



       // MyCustomAdapter adapter = new MyCustomAdapter(list, this);

        //handle listview and assign adapter


    //    ListView lView = (ListView)findViewById(R.id.my_listview);
     //   lView.setAdapter(adapter);

    }


}
