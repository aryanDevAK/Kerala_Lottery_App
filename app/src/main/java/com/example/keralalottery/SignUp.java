package com.example.keralalottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
Button btn1;
TextView loginText;
EditText name,mobile,emailId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Initializing Buttons using the Function
        initializeBtn();

        //Adding functionality to the Sign in Button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting the Strings input by the user
                String input_name = name.getText().toString();
                String mobileNum = mobile.getText().toString();
                String email = emailId.getText().toString();

                //Store the Strings in the Database

                //Verify by the mobile Number by the OTP
            }
        });

        //Setting the Logint button to direct to login
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void initializeBtn(){
        btn1 = findViewById(R.id.button3);
        loginText = findViewById(R.id.textView6);
        name = findViewById(R.id.editText3);
        mobile = findViewById(R.id.editText4);
        emailId = findViewById(R.id.editText5);
    }
}