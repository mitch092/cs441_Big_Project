package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForgotPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        EditText email = (EditText) findViewById(R.id.email);
    }

    public void onSubmit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}