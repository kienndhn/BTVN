package com.example.gmail_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ContactModel> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();
        contacts.add(new ContactModel("name1", "sub1sub1sub1sub1sub1sub1sub1sub1sub1sub1", "content1sub1sub1sub1sub1sub1sub1sub1"));
        contacts.add(new ContactModel("name1", "sub1sub1sub1sub1sub1sub1sub1sub1sub1sub1sub", "content1sub1sub1sub1sub1sub1sub1sub1sub1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));
        contacts.add(new ContactModel("name1", "sub1", "content1"));

        ContactAdapter adapter = new ContactAdapter(contacts);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
