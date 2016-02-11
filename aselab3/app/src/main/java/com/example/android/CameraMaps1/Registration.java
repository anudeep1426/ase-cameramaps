package com.example.android.CameraMaps1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Registration extends AppCompatActivity {
    ImageButton picButton, locButton;
    int TAKE_PHOTO_CODE = 1993;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    public void setImage(View v)
    {
        picButton = (ImageButton) findViewById(R.id.profileImage);
        picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, TAKE_PHOTO_CODE);
            }
        });
    }

    public void registerButton(View v)
    {
        Button reg = (Button) findViewById(R.id.register);

        if(v.getId() == R.id.register)
        {
            Intent h = new Intent(Registration.this, home.class);
            startActivity(h);
        }
       /* reg.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                Intent h = new Intent(Registration.this, home.class);
                startActivity(h);
            }
        });*/
    }
    public void setLocation(View v)
    {
        locButton = (ImageButton) findViewById(R.id.location);
        //Intent m = new Intent(Registration.this, mapActivity.class);
        //startActivity(m);

    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode, resultcode, data);

        if(requestcode == TAKE_PHOTO_CODE && resultcode == RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            picButton.setImageBitmap(photo);
            Log.d("Image successful","success");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
