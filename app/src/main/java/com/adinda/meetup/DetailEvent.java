package com.adinda.meetup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailEvent extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    TextView ename, edesc, edate, eplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        dbHelper = new DataHelper(this);
        ename = (TextView) findViewById(R.id.textView1);
        edesc = (TextView) findViewById(R.id.textView2);
        edate = (TextView) findViewById(R.id.textView3);
        eplace = (TextView) findViewById(R.id.textView4);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT event_name,event_description, event_date, event_place FROM event WHERE event_name = '" +
                getIntent().getStringExtra("event_name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            ename.setText(cursor.getString(0).toString());
            edesc.setText(cursor.getString(1).toString());
            edate.setText(cursor.getString(1).toString());
            eplace.setText(cursor.getString(1).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
