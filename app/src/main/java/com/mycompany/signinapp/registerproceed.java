package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class registerproceed extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerproceed);
    }

    EditText clubname;
    EditText ownername;
    EditText id;
    EditText schoolemail;

    public void onetime(View view) {


        Intent intent = new Intent(this, createaccount.class);

        startActivity(intent);

    }


}
