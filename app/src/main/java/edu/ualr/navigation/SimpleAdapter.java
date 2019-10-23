package edu.ualr.navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by irconde on 2019-10-22.
 */
public class SimpleAdapter extends RecyclerView.Adapter {

    List<Contact> mContacts;

    public SimpleAdapter(List<Contact> contacts) {
        this.mContacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        return new ContactViewHolder(inflater.inflate(R.layout.contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContactViewHolder vh = (ContactViewHolder) holder;
        Contact contact = this.mContacts.get(position);
        vh.name.setText(contact.getFullName());
        vh.website.setText(contact.getWebsite());
        vh.phoneNumber.setText(contact.getPhoneNumber());
        vh.address.setText(contact.getAddress());
        vh.email.setText(contact.getEmailAddress());
    }

    @Override
    public int getItemCount() {
        return this.mContacts.size();
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {

        public TextView name, phoneNumber, email, address, website;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fullNameTV);
            phoneNumber = itemView.findViewById(R.id.phoneNumberTV);
            email = itemView.findViewById(R.id.emailTV);
            address = itemView.findViewById(R.id.addressTV);
            website = itemView.findViewById(R.id.webTV);
        }
    }
}
