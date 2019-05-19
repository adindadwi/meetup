package com.adinda.meetup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adinda.meetup.R;

public class BuatEvent extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText ename, edesc, edate, eplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_event);

        dbHelper = new DataHelper(this);
        ename = (EditText) findViewById(R.id.editText1);
        edesc = (EditText) findViewById(R.id.editText2);
        edate = (EditText) findViewById(R.id.editText3);
        eplace = (EditText) findViewById(R.id.editText4);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into event(event_name, event_description, event_date, event_place) values('" +
                        ename.getText().toString() + "','" +
                        edesc.getText().toString() + "','" +
                        edate.getText().toString() + "','" +
                        eplace.getText().toString() +")");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                GroupActivity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
