package com.mycompany.signinapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class temp extends AppCompatActivity {

/*

not a real working file to be implemented into prod!


 */

    private FirebaseAuth mAuth;
    private EditText mEmailField;
    private EditText  mPasswordField;
    String TAG = "i";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);

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


        mEmailField = findViewById(R.id.email);
        mPasswordField = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);

//        if (!validateForm()) {
//            return;
//        }
//
//        showProgressBar();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(temp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
//                        if (!task.isSuccessful()) {
//                            mStatusTextView.setText(R.string.auth_failed);
//                        }
                       // hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }


    public void proceed(View view){

        signIn(mEmailField.getText().toString(),mPasswordField.getText().toString());

    }

    public void newuser(View view) {

        Intent intent = new Intent(this, memberorexec.class);

        startActivity(intent);

    }
    public void existing(View view) {

        Intent intent = new Intent(this, login.class);

        startActivity(intent);

    }

}
