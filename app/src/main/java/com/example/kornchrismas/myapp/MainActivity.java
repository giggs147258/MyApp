package com.example.kornchrismas.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ImageButton register;
    private EditText email,pass;
    private MediaPlayer musicBg,soundBt;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPass);
        register = (ImageButton) findViewById(R.id.buttonRegis);
        musicBg = MediaPlayer.create(this, R.raw.musicbg);
        soundBt = MediaPlayer.create(this, R.raw.soundbt);
        firebaseAuth = FirebaseAuth.getInstance();

        musicBg.start();
        musicBg.setLooping(true);

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

    public void Login (View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Please wait...","Processing...",true);
        (firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            intent.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(intent);
                            musicBg.stop();
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
