package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class approvedornew extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approvedornew);
    }


    public void approved(View view) {


        Intent intent = new Intent(this, registerproceed.class);

        startActivity(intent);

    }

    public void request(View view) {


        Intent intent = new Intent(this, clubapproval.class);

        startActivity(intent);

    }
}
