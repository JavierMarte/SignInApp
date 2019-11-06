package com.mycompany.signinapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class splashactivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen2);

//        VideoView videoview = (VideoView) findViewById(R.id.videoView);
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.backgroundvideo);
//
//        //DisplayMetrics metrics = new DisplayMetrics();
//        //getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        //videoview.setLayoutParams(new LinearLayout.LayoutParams(metrics.widthPixels, metrics.heightPixels));
//        videoview.getLayoutParams().width = 1700;
//        videoview.getLayoutParams().height = 4000;
//        videoview.setVideoURI(uri);
//        videoview.start();

    }
    public void entertomain2(View view) {

        Intent intent = new Intent(this, mainoption.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
       // String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }



}
