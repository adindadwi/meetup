package com.adinda.meetup.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adinda.meetup.DetailGroup;
import com.adinda.meetup.model.Event;
import com.adinda.meetup.R;
import com.adinda.meetup.model.Group;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;



public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private Context context;
    private List<Group> groupList;

    public GroupAdapter(Context context,List<Group> listGroup){
        this.context = context;
        this.groupList = listGroup;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_card,parent,false);

        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        final Group group = groupList.get(position);
        holder.namaGrup.setText(group.getName());
        holder.namaGrup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),group.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(),DetailGroup.class);
                i.putExtra("groupId",group.getId());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{
        public TextView namaGrup;

        public GroupViewHolder(View itemView) {
            super(itemView);
            namaGrup= (TextView) itemView.findViewById(R.id.nama_grup);
        }

    }
}
