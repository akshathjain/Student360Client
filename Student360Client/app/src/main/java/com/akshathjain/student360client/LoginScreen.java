package com.akshathjain.student360client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    private EditText usernameEntry;
    private EditText passwordEntry;
    String userName;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        usernameEntry = (EditText) findViewById(R.id.username_entry);
        passwordEntry = (EditText) findViewById(R.id.password_entry);
    }

    public void login(View v) {
        userName = usernameEntry.getText().toString();
        password = passwordEntry.getText().toString();
    }
}
