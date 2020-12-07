package com.graduation_project.trendway;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView userNameTextView;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent.hasExtra("user")){
            user = new User();
            user.setUserName(intent.getStringExtra("user"));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        setListenersForViews();
    }

    private void initViews() {
        userNameTextView = findViewById(R.id.username_text_view);
        if (getIntent().getExtras()==null)
            user = new User("omar_ahmed", "1234");
    }

    private void setListenersForViews() {
        userNameTextView.setText(user.getUserName());
    }
}
