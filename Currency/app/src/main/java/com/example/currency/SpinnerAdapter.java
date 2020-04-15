package com.example.currency;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    List<ContactModel> contacts;

    public SpinnerAdapter(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_layout, viewGroup, false);
        }

        TextView textView = view.findViewById(R.id.text_spinner);
        textView.setText(contacts.get(i).getName() + " - " + contacts.get(i).getCurrencyName());
        return view;
    }
}
