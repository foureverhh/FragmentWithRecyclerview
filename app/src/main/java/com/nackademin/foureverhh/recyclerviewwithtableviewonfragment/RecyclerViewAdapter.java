package com.nackademin.foureverhh.recyclerviewwithtableviewonfragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Contact> contactList;
    private Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Contact> contactList) {
        this.mContext = mContext;
        this.contactList = contactList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameText;
        private TextView numberText;
        private ImageView imageView;
        private LinearLayout item_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_contact);
            numberText = itemView.findViewById(R.id.phone_contact);
            imageView = itemView.findViewById(R.id.img_contact);
            item_contact = itemView.findViewById(R.id.contact_item_id);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_contact,viewGroup,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        //Dialog initialize
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Test Click"+myViewHolder.getAdapterPosition(),
                        Toast.LENGTH_SHORT).show();

                TextView dialog_name_textView_id = myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_phone_textView_id = myDialog.findViewById(R.id.dialog_phone_id);
                ImageView dialog_image_id = myDialog.findViewById(R.id.dialog_image_id);

                dialog_name_textView_id.setText(contactList.get(myViewHolder.getAdapterPosition()).getName());
                dialog_phone_textView_id.setText(contactList.get(myViewHolder.getAdapterPosition()).getPhoneNumber());
                dialog_image_id.setImageResource(contactList.get(myViewHolder.getAdapterPosition()).getPhoto());
                myDialog.show();
            }
        });

        return myViewHolder;
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
