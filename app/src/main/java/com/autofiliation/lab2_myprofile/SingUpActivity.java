package com.autofiliation.lab2_myprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class SingUpActivity extends AppCompatActivity {

    private  static final  int GALLERY_REQUEST_CODE=123;
    ImageView imageView;
    Button btnPick;
    Button sendButton;
    String st;

    EditText message_text;
    EditText message_text_surname;
    EditText message_text_birthday;
    EditText message_text_gender;
    EditText message_text_email;
    EditText message_text_aboutme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        imageView = findViewById(R.id.imageView);
        btnPick = findViewById(R.id.button2);



        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"pick an image"),GALLERY_REQUEST_CODE);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null){

            Uri imageData = data.getData();
            imageView.setImageURI(imageData);
        }
    }




    public void sendmessage (View view)
    {

        message_text = (EditText) findViewById(R.id.editTextTextPersonName4);
        message_text_surname = (EditText) findViewById(R.id.editTextsurname);
        message_text_birthday = (EditText) findViewById(R.id.editTextbirthday);
        message_text_gender = (EditText) findViewById(R.id.editTextgender);
        message_text_email = (EditText) findViewById(R.id.editTextmail);
        message_text_aboutme = (EditText) findViewById(R.id.editTextaboutme);
        //imageView = (ImageView) findViewById(R.id.imageView3);



        String message = message_text.getText().toString();
        String message_surname = message_text_surname.getText().toString();
        String message_birthday = message_text_birthday.getText().toString();
        String message_gender = message_text_gender.getText().toString();
        String message_email = message_text_email.getText().toString();
        String message_aboutme = message_text_aboutme.getText().toString();

        Intent intent= new Intent(this ,ProfileActivity.class);

        intent.putExtra("message",message);
        intent.putExtra("message_surname",message_surname);
        intent.putExtra("message_birthday",message_birthday);
        intent.putExtra("message_gender",message_gender);
        intent.putExtra("message_email",message_email);
        intent.putExtra("message_aboutme",message_aboutme);

        Bitmap bitmap = BitmapFactory.decodeResource
                (getResources(), R.drawable.indir); // your bitmap
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        intent.putExtra("byteArray", bs.toByteArray());

        startActivity(intent);
    }
}