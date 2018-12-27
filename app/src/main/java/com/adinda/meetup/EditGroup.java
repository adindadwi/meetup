package com.adinda.meetup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adinda.meetup.model.Group;

public class EditGroup extends AppCompatActivity {
    EditText txtgNamaUpd,txtgDeskripsiUpd,txtgKategoriUpd,txtgEventUpd;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);

        Intent i = getIntent();
        final Long idGroup = i.getLongExtra("idGroup",0L);
        Group detailGrup = Group.findById(Group.class,idGroup);

        btnUpdate      = (Button)findViewById(R.id.btnUpdate);
        txtgNamaUpd    = (EditText)findViewById(R.id.edtgNama);
        txtgDeskripsiUpd = (EditText)findViewById(R.id.edtgDeskripsi);
        txtgKategoriUpd = (EditText)findViewById(R.id.edtgKategori);
        txtgEventUpd = (EditText) findViewById(R.id.edtgEvent);

        txtgNamaUpd.setText(detailGrup.getName());
        txtgDeskripsiUpd.setText(detailGrup.getDescription());
        txtgKategoriUpd.setText(detailGrup.getCategories());
        txtgEventUpd.setText(detailGrup.getEvents());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = Group.findById(Group.class,idGroup);
                group.setName(txtgNamaUpd.getText().toString());
                group.setDescription(txtgDeskripsiUpd.getText().toString());
                group.setCategories(txtgKategoriUpd.getText().toString());
                group.setEvents(txtgEventUpd.getText().toString());
                group.save();
                Snackbar uhuy = Snackbar.make(findViewById(R.id.edit_layout),"Data Berhasil Di Update",Snackbar.LENGTH_SHORT);
                uhuy.show();
            }
        });

    }
}
