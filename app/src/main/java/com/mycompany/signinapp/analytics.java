package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class analytics extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analytics);
    }


    public void approved(View view) {


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    public void request(View view) {

//anayltics
        Intent intent = new Intent(this, clubapproval.class);

        startActivity(intent);

    }
}
