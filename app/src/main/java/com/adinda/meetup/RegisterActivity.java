package com.adinda.meetup;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Cursor cursor;
    DataHelper dbHelper;
    Button register;
    TextView login;
    EditText password, username, email;

    private NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DataHelper(this);

        username = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputPassword);
        email = findViewById(R.id.inputEmail);

        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.tvLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO user ( username,email,password) VALUES ('" +
                        username.getText().toString() + "','" +
                        email.getText().toString() + "','" +
                        password.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                emptyEditText();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void emptyEditText(){
        username.setText(null);
        email.setText(null);
        password.setText(null);
    }
}
