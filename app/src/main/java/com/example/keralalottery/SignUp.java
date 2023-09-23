package com.example.keralalottery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUp extends AppCompatActivity {
    Button signUpBtn;
    TextView loginText;
    EditText name, mobile, emailId, edtOTP;
    private FirebaseAuth mAuth;
    private Button verifyOTPBtn, generateOTPBtn;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeViews();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Getting the Strings input by the user
                String input_name = name.getText().toString();
                String mobileNum = mobile.getText().toString();
                String email = emailId.getText().toString();

                // Store the Strings in the Database

                // Verify by the mobile Number by the OTP
            }
        });

        // Setting the Login button to direct to login
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });

        getOtpFunction();
    }

    public void initializeViews() {
        loginText = findViewById(R.id.textView6);
        name = findViewById(R.id.inputName);
        mobile = findViewById(R.id.inputPhone);
        emailId = findViewById(R.id.inputEmail);
        edtOTP = findViewById(R.id.inputOtp);
        verifyOTPBtn = findViewById(R.id.signUpBtn);
        generateOTPBtn = findViewById(R.id.verifyOtp);
    }

    public void getOtpFunction() {
        mAuth = FirebaseAuth.getInstance();

        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mobile.getText().toString())) {
                    Toast.makeText(SignUp.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    String phone = "+91" + mobile.getText().toString();
                    sendVerificationCode(phone);
                }
            }
        });

        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                    Toast.makeText(SignUp.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    verifyCode(edtOTP.getText().toString());
                }
            }
        });
    }

    private void sendVerificationCode(String number) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallBack)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Successfully verified the OTP, you can take appropriate action here.
                            // For example, you can navigate to the next screen or perform some other task.
                            Intent i = new Intent(SignUp.this, Activity2.class); // Replace NextActivity with your desired activity
                            startActivity(i);
                            finish();
                        } else {
                            // Verification failed, display an error message.
                            Toast.makeText(SignUp.this, "Verification failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Callback method for phone auth provider.
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    verificationId = s;
                }

                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    final String code = phoneAuthCredential.getSmsCode();
                    if (code != null) {
                        edtOTP.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            };
}
