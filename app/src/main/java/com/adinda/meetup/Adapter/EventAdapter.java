package com.adinda.meetup.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.adinda.meetup.Event;
import com.adinda.meetup.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context mContext;
    private List<Event> eventList;

    EventAdapter(ArrayList namaList,ArrayList dateList,ArrayList placeList,ArrayList photoList,Context mContext){
        this.mContext=mContext;
        this.eventList
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama, date,place;
        public ImageView photo, overflow;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.count);
            photo = (ImageView) view.findViewById(R.id.photo);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,@SuppressLint("RecyclerView") final int position) {
        Event event = eventList.get(position)
        holder.event.setText(event.getNumOfEvent() + " event");

        // loading event cover using Glide library
        Glide.with(mContext).load(event.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_event, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
{

}
