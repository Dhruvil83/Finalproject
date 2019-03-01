package com.example.dhruvil.spit_it_out.activities;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dhruvil.spit_it_out.R;

import java.io.File;

public class camera extends AppCompatActivity {
    ImageButton imageButton;
    ImageView imageView;
    final int REQUEST_IMAGE_CAPTURE = 2;
    String folder_main = "Spit_It";
    Uri urisaveimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageButton=findViewById(R.id.camera);
        imageView=findViewById(R.id.setimage);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

    }    private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = new File(Environment.getExternalStorageDirectory(), folder_main);
        File images = new File(Environment.getExternalStorageDirectory() + "/" + folder_main, "Images");
        File image=new File(images,System.currentTimeMillis()+"images.png");
        urisaveimage=Uri.fromFile(image);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,urisaveimage);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode ==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

                imageView.setImageURI(urisaveimage);
            }
        }
    }

