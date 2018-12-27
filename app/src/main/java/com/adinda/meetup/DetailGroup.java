package com.adinda.meetup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adinda.meetup.model.Group;

public class DetailGroup extends AppCompatActivity {

    TextView namaGrup,deskripsiGrup,kategoriGrup, memberGrup, eventGrup;
    Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_group);

        Intent i = getIntent();
        final Long idGroup = i.getLongExtra("grupId",0L);

        Group detailGroup = Group.findById(Group.class,idGroup);
        namaGrup = (TextView)findViewById(R.id.namaGrup);
        namaGrup.setText(detailGroup.getName());

        deskripsiGrup = (TextView)findViewById(R.id.deskripsiGrup);
        deskripsiGrup.setText(detailGroup.getDescription());

        kategoriGrup = (TextView)findViewById(R.id.kategoriGrup);
        kategoriGrup.setText(detailGroup.getCategories());

        btnUpdate = (Button)findViewById(R.id.edit_grup);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = Group.findById(Group.class,idGroup);
                Intent intent = new Intent(v.getContext(),EditGroup.class);
                intent.putExtra("idGroup",group.getId());
                v.getContext().startActivity(intent);
            }
        });

        btnDelete = (Button)findViewById(R.id.delete_grup);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = Group.findById(Group.class,idGroup);
                group.delete();
                Intent i = new Intent(v.getContext(),MainActivity.class);
                v.getContext().startActivity(i);
            }
        });

    }
}
