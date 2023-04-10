package com.example.mediaplayer.ui.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaplayer.R;
import com.example.mediaplayer.model.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> lstContact;
    Context context;
    ContactCallback contactCallback;
    public ContactAdapter(ArrayList<Contact> lstContact) {this.lstContact = lstContact;}

    public void setContactCallback(ContactCallback contactCallback) {
        this.contactCallback = contactCallback;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.item_contact, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = lstContact.get(position);

        holder.tvContactName.setText(contact.getName() + " - " + contact.getPhoneNumber());
        holder.ivCall.setOnClickListener(v -> contactCallback.onItemClickedCall(contact.getPhoneNumber()));
    }

    @Override
    public int getItemCount() {return lstContact.size();}

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvContactName;
        public final ImageView ivPhoto;
        public final ImageView ivCall;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContactName = itemView.findViewById(R.id.tv_contact_name);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            ivCall = itemView.findViewById(R.id.iv_call);
        }
    }
    public interface ContactCallback {
        void onItemClickedCall(String Phonenumber);
    }
}
