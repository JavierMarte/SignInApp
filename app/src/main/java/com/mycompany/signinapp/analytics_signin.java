package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class analytics_signin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analytic_signin);
    }


    public void signin(View view) {


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    public void analytics(View view) {

        //anayltics
        Intent intent = new Intent(this, analytics.class);

        startActivity(intent);

    }
}
