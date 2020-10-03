package com.bayufajariyanto.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private List<Contact> listContact = new ArrayList<>();

    public ContactAdapter(List<Contact> listContact) {
        this.listContact = listContact;
    }

    private OnContactClickListener listener;

    public interface OnContactClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnContactClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View vh = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_contact,viewGroup,false);
        ContactViewHolder viewHolder = new ContactViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact item = listContact.get(position);
        holder.txtPhone.setText(item.getPhone());
        holder.txtName.setText(item.getName());
        Picasso.get().load(item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageContact);

    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageContact;
        public TextView txtName, txtPhone;

        public ContactViewHolder(@NonNull View itemView){
            super(itemView);
            imageContact = itemView.findViewById(R.id.imageContact);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
