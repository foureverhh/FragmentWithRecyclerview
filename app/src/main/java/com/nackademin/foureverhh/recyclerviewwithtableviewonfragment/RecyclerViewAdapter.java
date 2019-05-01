package com.nackademin.foureverhh.recyclerviewwithtableviewonfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Contact> contactList = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext, List<Contact> contactList) {
        this.mContext = mContext;
        this.contactList = contactList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameText;
        private TextView numberText;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_contact);
            numberText = itemView.findViewById(R.id.phone_contact);
            imageView = itemView.findViewById(R.id.img_contact);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_contact,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.numberText.setText(contactList.get(i).getPhoneNumber());
        myViewHolder.nameText.setText(contactList.get(i).getName());
        myViewHolder.imageView.setImageResource(contactList.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

}
