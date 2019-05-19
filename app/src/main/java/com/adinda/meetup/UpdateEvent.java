package com.adinda.meetup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEvent extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText ename, edesc, edate, eplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_event);

        dbHelper = new DataHelper(this);
        ename = (EditText) findViewById(R.id.editText1);
        edesc = (EditText) findViewById(R.id.editText2);
        edate = (EditText) findViewById(R.id.editText3);
        eplace = (EditText) findViewById(R.id.editText4);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT event_name,event_description, event_date, event_place FROM evennt WHERE event_name = '" +
                getIntent().getStringExtra( "event_name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            ename.setText(cursor.getString(0).toString());
            edesc.setText(cursor.getString(1).toString());
            edate.setText(cursor.getString(1).toString());
            eplace.setText(cursor.getString(1).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update event set " +
                        "event_name='"+ ename.getText().toString() +
                        "', event_description='" + edesc.getText().toString() +
                        "', event_date='" + edate.getText().toString() +
                        "', event_place='" + eplace.getText().toString() +
                        "' where event_name ='" + ename.getText().toString()+"'");
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
