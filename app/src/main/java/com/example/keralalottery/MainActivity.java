package com.example.keralalottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText text1, text2;
Button btn1;
TextView text3;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        text1 = findViewById(R.id.editText);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.textView4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Getting the Username and Mobile Number Entered
                String username = text2.getText().toString();
                String mobileNum = text3.getText().toString();

                //Check for the Username in the Database

                //Generate OTP for the Mobile Number Entered

                //Starting the main Activity if the OTP is Correct
                Intent i = new Intent(getApplicationContext(),Activity2.class);
                startActivity(i);
            }
        });

        //Function to Move to Sign in Window
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
    }
}