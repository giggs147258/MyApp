package com.example.kornchrismas.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton back;
    private MediaPlayer musicBg,soundBt;
    private EditText email,pass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back = (ImageButton) findViewById(R.id.btBack);
        email = (EditText) findViewById(R.id.emailtext);
        pass = (EditText) findViewById(R.id.passtext);
        musicBg = MediaPlayer.create(this, R.raw.musicbg3);
        soundBt = MediaPlayer.create(this, R.raw.soundbt);
        firebaseAuth = FirebaseAuth.getInstance();

        musicBg.start();
        musicBg.setLooping(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RegisterActivity.this, MainActivity.class);
                soundBt.start();
                startActivity(intent2);
                musicBg.stop();
            }
        });
    }

    public void Register (View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this,"Please wait...","Process", true);
        (firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registratation Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            musicBg.stop();
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
