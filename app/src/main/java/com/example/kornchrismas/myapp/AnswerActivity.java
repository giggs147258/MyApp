package com.example.kornchrismas.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class AnswerActivity extends AppCompatActivity {

    private TextView score;
    private ImageButton back;
    private Button again;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        again = (Button) findViewById(R.id.buttonAgain);
        back = (ImageButton) findViewById(R.id.butBack);
        score = (TextView) findViewById(R.id.textScore);
        firebaseAuth = FirebaseAuth.getInstance();

        score.setText(String.valueOf(getIntent().getExtras().getInt("Score")));

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnswerActivity.this, MVCActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AnswerActivity.this, LoginActivity.class);
                intent2.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                startActivity(intent2);
            }
        });

    }

}

