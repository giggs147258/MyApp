package com.example.kornchrismas.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton login,register;
    private EditText user;
    private MediaPlayer musicBg,soundBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.editTextUser);
        login = (ImageButton) findViewById(R.id.buttonLogin);
        register = (ImageButton) findViewById(R.id.buttonRegis);
        musicBg = MediaPlayer.create(this, R.raw.musicbg);
        soundBt = MediaPlayer.create(this, R.raw.soundbt);

        musicBg.start();
        musicBg.setLooping(true);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("name",user.getText().toString());
                soundBt.start();
                startActivity(intent);
                musicBg.stop();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
                soundBt.start();
                startActivity(intent2);
                musicBg.stop();
            }
        });

    }
}
