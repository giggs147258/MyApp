package com.example.kornchrismas.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton back;
    private MediaPlayer musicBg,soundBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back = (ImageButton) findViewById(R.id.buttonBack);
        musicBg = MediaPlayer.create(this, R.raw.musicbg3);
        soundBt = MediaPlayer.create(this, R.raw.soundbt);

        musicBg.start();
        musicBg.setLooping(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                soundBt.start();
                startActivity(intent);
                musicBg.stop();
            }
        });

    }
}
