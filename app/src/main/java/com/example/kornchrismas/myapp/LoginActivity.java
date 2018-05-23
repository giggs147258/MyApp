package com.example.kornchrismas.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private ImageButton back,game,firebase;
    private TextView email;
    private MediaPlayer musicBg,soundBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextView) findViewById(R.id.textViewUser);
        back = (ImageButton) findViewById(R.id.buttonBack);
        game = (ImageButton) findViewById(R.id.buttonGame);
        firebase = (ImageButton) findViewById(R.id.buttonFirebase);
        musicBg = MediaPlayer.create(this, R.raw.musicbg2);
        soundBt = MediaPlayer.create(this, R.raw.soundbt);

        musicBg.start();
        musicBg.setLooping(true);

        email.setText(getIntent().getExtras().getString("Email"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                soundBt.start();
                startActivity(intent);
                musicBg.stop();
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, MVCActivity.class);
                soundBt.start();
                startActivity(intent2);
                musicBg.stop();
            }
        });

        firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(LoginActivity.this, FirebaseActivity.class);
                soundBt.start();
                startActivity(intent3);
                musicBg.stop();
            }
        });

    }

}
