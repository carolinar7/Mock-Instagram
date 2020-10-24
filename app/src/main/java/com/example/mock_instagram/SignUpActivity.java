package com.example.mock_instagram;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    EditText etSignUsername;
    EditText etSignPassword;
    Button btnCreateSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etSignUsername = findViewById(R.id.etSignUsername);
        etSignPassword = findViewById(R.id.etSignPassword);
        btnCreateSignUp = findViewById(R.id.btnCreateSignUp);

        btnCreateSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etSignUsername.getText().toString();
                String password = etSignPassword.getText().toString();
                if (username.equals("") || password.equals("")) {
                    Log.i(TAG, "Username or Password is too short");
                    Toast.makeText(SignUpActivity.this, "Username or Password is invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
                signUp(username, password);
            }
        });
    }

    private void signUp(String username, String password) {
        Log.i(TAG, "Creating account in sign up");
        ParseUser user = new ParseUser();

        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Sign up failed", e);
                    Toast.makeText(SignUpActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SignUpActivity.this, "Sign up was successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
