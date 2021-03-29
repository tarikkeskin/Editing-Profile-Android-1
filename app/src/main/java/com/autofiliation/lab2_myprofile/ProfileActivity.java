package com.autofiliation.lab2_myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {



    TextView msgText;
    TextView msgText_surname;
    TextView msgText_birtday;
    TextView msgText_gender;
    TextView msgText_email;
    TextView msgText_aboutme;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Bundle b = getIntent().getExtras();
        String msg = b.getString("message");
        String msg_surname = b.getString("message_surname");
        String msg_birthday = b.getString("message_birthday");
        String msg_gender= b.getString("message_gender");
        String msg_email= b.getString("message_email");
        String msg_aboutme= b.getString("message_aboutme");

        msgText = (TextView) findViewById(R.id.textView11);
        msgText_surname = (TextView) findViewById(R.id.textView12);
        msgText_birtday = (TextView) findViewById(R.id.textView13);
        msgText_gender = (TextView) findViewById(R.id.textView14);
        msgText_email = (TextView) findViewById(R.id.textView15);
        msgText_aboutme = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView3) ;

        msgText.setText(msg);
        msgText_surname.setText(msg_surname);
        msgText_birtday.setText(msg_birthday);
        msgText_gender.setText(msg_gender);
        msgText_email.setText(msg_email);
        msgText_aboutme.setText(msg_aboutme);

        if(getIntent().hasExtra("byteArray")) {
            //ImageView imv= new ImageView(this);
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            imageView.setImageBitmap(bitmap);
        }





    }
}