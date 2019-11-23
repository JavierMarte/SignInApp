package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class createaccount extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);
    }

    EditText clubname;
    EditText ownername;
    EditText id;
    EditText schoolemail;

    public void finalize(View view) {


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }


}
