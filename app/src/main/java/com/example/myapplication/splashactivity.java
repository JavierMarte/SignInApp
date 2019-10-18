package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class splashactivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.backgroundvideo);

        //DisplayMetrics metrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //videoview.setLayoutParams(new LinearLayout.LayoutParams(metrics.widthPixels, metrics.heightPixels));
        videoview.getLayoutParams().width = 1700;
        videoview.getLayoutParams().height = 4000;
        videoview.setVideoURI(uri);
        videoview.start();

    }





}
