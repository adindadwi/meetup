package com.adinda.meetup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adinda.meetup.fragment.GroupFragment;

public class  UpdateGroup extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText gname, gdesc,gid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_group);

        dbHelper = new DataHelper(this);
        gname = (EditText) findViewById(R.id.editText1);
        gdesc = (EditText) findViewById(R.id.editText2);
        gid = (EditText) findViewById(R.id.editText3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT group_name,group_description,id FROM grupmeetup WHERE group_name = '" +
                getIntent().getStringExtra( "group_name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            gname.setText(cursor.getString(0).toString());
            gdesc.setText(cursor.getString(1).toString());
            gid.setText(cursor.getString(2).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update grupmeetup set " +
                        "group_name='"+ gname.getText().toString() +
                        "', group_description='" + gdesc.getText().toString()
                        + "' where id ='" + gid.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                GroupActivity.ma.RefreshList();
                GroupFragment.gf.RefreshList();
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