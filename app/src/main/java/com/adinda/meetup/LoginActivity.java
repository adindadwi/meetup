package com.adinda.meetup;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    EditText Uname, Pwd;
    Button login;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        Uname = findViewById(R.id.edtUsr);
        Pwd = findViewById(R.id.edtPwd);
        login = findViewById(R.id.btnLogin);

        TextView register = (TextView) findViewById(R.id.tvRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = '" +
                        Uname.getText().toString() + "' AND password = '" +
                        Pwd.getText().toString() + "'", null);
                cursor.moveToFirst();

                if (cursor.getCount() > 0)
                {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("username", cursor.getString(0).toString());
                    intent.putExtra("password", cursor.getString(1).toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Username or Password is Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
