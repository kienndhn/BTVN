package com.example.gmail_layout;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    List<ContactModel> contacts;

    public ContactAdapter(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textName = view.findViewById(R.id.text_name);
            viewHolder.textSubtitle = view.findViewById(R.id.text_subtitle);
            viewHolder.textContent = view.findViewById(R.id.text_content);
            viewHolder.textRound = view.findViewById(R.id.text_round);
            viewHolder.imageFavorite = view.findViewById(R.id.image_favorite);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final ContactModel contact = contacts.get(i);
        viewHolder.textRound.setText(contact.getName().substring(0, 1));
        viewHolder.textName.setText(contact.getName());
        viewHolder.textSubtitle.setText(contact.getSubtitle());
        viewHolder.textContent.setText(contact.getContent());

        if(contact.isSelected()){
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_favorite);
        }
        else
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_normal);

        viewHolder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = contacts.get(i).isSelected;
                contacts.get(i).setSelected(!isSelected);
                notifyDataSetChanged();
            }
        });

        return view;
    }

}
class ViewHolder {
    TextView textName;
    TextView textRound;
    TextView textContent;
    TextView textSubtitle;
    ImageView imageFavorite;
}

