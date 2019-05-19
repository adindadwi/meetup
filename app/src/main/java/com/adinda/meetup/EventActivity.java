package com.adinda.meetup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EventActivity extends AppCompatActivity {
    String[] add;
    ListView GroupView;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static EventActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Button btn=(Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(EventActivity.this, BuatEvent.class);
                startActivity(inte);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM event",null);
        add = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            add[cc] = cursor.getString(1).toString();
        }
        GroupView = (ListView)findViewById(R.id.listView1);
        GroupView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, add));
        GroupView.setSelected(true);
        GroupView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = add[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Detail Event", "Update Event", "Hapus Event"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EventActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), DetailEvent.class);
                                i.putExtra("event_name", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateEvent.class);
                                in.putExtra("event_name", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from event where event_name = "+selection);
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)GroupView.getAdapter()).notifyDataSetInvalidated();
    }
}
