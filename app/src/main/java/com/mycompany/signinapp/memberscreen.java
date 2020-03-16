package com.mycompany.signinapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class memberscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberscreen);


        String tag = getIntent().getStringExtra("clubSelection");
        TextView id = (TextView) findViewById(R.id.textView9);
        id.setText(tag);

        //ImageView image_view = (ImageView) findViewById(R.id.imageView3);



        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode("https://www.youtube.com/", BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            ((ImageView) findViewById(R.id.imageView3)).setImageBitmap(bmp);

        } catch (WriterException e) {
            e.printStackTrace();
        }


//        try {
//            // generate a 150x150 QR code
//            Bitmap bm = encodeAsBitmap(barcode_content, BarcodeFormat.QR_CODE, 150, 150);
//
//            if(bm != null) {
//                image_view.setImageBitmap(bm);
//            }
//        } catch (WriterException e) { //eek }

    }

    EditText clubname;
    EditText ownername;
    EditText id;
    EditText schoolemail;

    public void approvalclick(View view) {


//        Firebase.setAndroidContext(this);
//
//        Firebase myFirebaseRef = new Firebase("https://signinapp-50107.firebaseio.com/");
//
//
//        clubname = (EditText) findViewById(R.id.editText);
//        ownername = (EditText) findViewById(R.id.editText2);
//        id = (EditText) findViewById(R.id.editTextname);
//        schoolemail = (EditText) findViewById(R.id.editTextID);
//
//
//
//        if ((clubname.getText().length() == 0 || schoolemail.getText().length() == 0) || (schoolemail.getText().length() == 0 || schoolemail.getText().length() == 0)) {
//
//            Toast.makeText(getApplicationContext(), "error!!", Toast.LENGTH_SHORT).show();
//        } else {
//
//
//            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("owner name").setValue(ownername.getText().toString());
//            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("studentid").setValue(id.getText().toString());
//            myFirebaseRef.child("clubapproval").child(clubname.getText().toString()).child("schoolemail").setValue(schoolemail.getText().toString());
//
//
//        }


    }

}
