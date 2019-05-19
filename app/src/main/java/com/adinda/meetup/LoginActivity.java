package com.adinda.meetup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String UName = "nameKey";
    SharedPreferences sharedpreferences;

    String tname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        Uname = findViewById(R.id.edtUsr);
        Pwd = findViewById(R.id.edtPwd);
        login = findViewById(R.id.btnLogin);
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        TextView register = (TextView) findViewById(R.id.tvRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un=Uname.getText().toString();
                String pw=Pwd.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = '" +
                        Uname.getText().toString() + "' AND password = '" +
                        Pwd.getText().toString() + "'", null);
                cursor.moveToFirst();

                if (cursor.getCount() > 0)
                {
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putString(UName,un);
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("username", cursor.getString(0).toString());
                    intent.putExtra("password", cursor.getString(1).toString());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
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

    public String  loadSession(){
        SharedPreferences sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        tname=sharedPreferences.getString(UName,"");
        return tname;
    }
}
