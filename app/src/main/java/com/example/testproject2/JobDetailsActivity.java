package com.example.testproject2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JobDetailsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jobdetails);

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){


            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            TextView name = findViewById(R.id.jddesc);
            name.setText(imageUrl);
        //    setImage(imageUrl, imageName);
        }
    }
}
