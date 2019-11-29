package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class memberorexec extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberorexec);
    }


    public void member(View view) {

//new member option
        Intent intent = new Intent(this, memberorproceed.class);

        startActivity(intent);

    }

    public void exec(View view) {


        Intent intent = new Intent(this, approvedornew.class);

        startActivity(intent);

    }
}
