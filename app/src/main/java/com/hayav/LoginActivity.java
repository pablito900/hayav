package com.hayav;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity{

    CheckBox rememberMeCheckBox;
    EditText userEditText;
    EditText passwordEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rememberMeCheckBox = (CheckBox)findViewById(R.id.RememberMeCheckBox);
        userEditText = (EditText)findViewById(R.id.UserEditText);
        passwordEditText = (EditText)findViewById(R.id.PasswordEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onLoginButtonClick(View view){

        String user = userEditText.getText().toString();
        if (!ValidateUser(user))
        {
            //TODO display error
        }

        String password = passwordEditText.getText().toString();
        if (!ValidatePassword(password))
        {
            //TODO display error
        }

        if (Login(user, password, rememberMeCheckBox.isChecked()))
        {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
        else
        {
            //TODO: display wrong login error
        }
    }

    private boolean ValidateUser(String user) {
        //TODO validate user input
        return true;
    }

    private boolean ValidatePassword(String password) {
        //TODO validate password input
        return true;
    }

    private boolean Login(String user, String password, boolean checked) {
        //TODO implement login
        return true;
    }
}