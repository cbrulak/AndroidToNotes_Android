package com.brulak.androidto.simplenotes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brulak on 15-12-01.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.event_name);
        }
    }

    private Context mContext;
    private RecyclerView mRecyclerView;
    private List<EventItem> eventItems = new ArrayList<EventItem>() {
        {
            add(new EventItem("What kind of topics would you like to see next year?"));
        }
    };

    public EventAdapter(Context context, RecyclerView recyclerView) {
        this.mContext = context;
        this.mRecyclerView = recyclerView;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.event, viewGroup, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(mRecyclerView.getChildPosition(v));
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder viewHolder, int i) {
        EventItem eventItem = eventItems.get(i);
        viewHolder.text.setText(eventItem.text);
    }

    @Override
    public int getItemCount() {
        return eventItems == null ? 0 : eventItems.size();
    }

    public void addItem(EventItem item) {
        eventItems.add(0, item);
        notifyItemInserted(0);
    }

    public void removeItem(int position) {
        eventItems.remove(position);
        notifyItemRemoved(position);
    }


}
