package com.graduation_project.trendway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private Spinner genderSpinner;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button registerButton;

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        setListenersForViews();
    }

    private void initViews() {
        userNameEditText = findViewById(R.id.registe_user_name_edit_text);
        genderSpinner = findViewById(R.id.register_gender_spinner);
        emailEditText = findViewById(R.id.register_email_edit_text);
        phoneEditText = findViewById(R.id.register_phone_edit_text);
        passwordEditText = findViewById(R.id.register_password_edit_text);
        confirmPasswordEditText = findViewById(R.id.register_confirm_password_edit_text);
        registerButton = findViewById(R.id.register_button);
    }

    private void setListenersForViews() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = String.valueOf(userNameEditText.getText());
                if (userName.equals("")){
                    userNameEditText.setError("please enter your user name");
                }
                else if (String.valueOf(emailEditText.getText()).equals("")){
                    emailEditText.setError("please enter your email");
                }else if (!isEmailValid(String.valueOf(emailEditText.getText()))){
                    emailEditText.setError("please enter a valid email");
                }
                else if (String.valueOf(phoneEditText.getText()).equals("")){
                    phoneEditText.setError("please enter your phone");
                }
                else if (String.valueOf(passwordEditText.getText()).equals("")){
                    passwordEditText.setError("please enter your password");
                }
                else if (String.valueOf(confirmPasswordEditText.getText()).equals("")){
                    confirmPasswordEditText.setError("please enter your password");
                }
                else if (!String.valueOf(confirmPasswordEditText.getText()).equals(String.valueOf(passwordEditText.getText()))){
                    confirmPasswordEditText.setError("passwords doesn't match");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("user", userName);
                    startActivity(intent);
                }
            }
        });
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
