package com.example.finalattempt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView btnSignUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btnSignUp2 = findViewById(R.id.btnSignUp2);
        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the next activity
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });
    }
}

