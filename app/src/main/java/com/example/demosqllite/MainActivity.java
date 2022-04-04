package com.example.demosqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvStudent;
    StudentAdapter adt;
    List<Contact> contacttList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        lvStudent =findViewById(R.id.lvStudent);
        contacttList = db.getAllContacts();

        adt = new StudentAdapter(this,R.layout.list_item,contacttList);
        lvStudent.setAdapter(adt);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        Button btnCancel = findViewById(R.id.btnCancel);
        TextView txt = findViewById(R.id.txtfield);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setName(txt.getText().toString());
                db.addContact(contact);
                contacttList = db.getAllContacts();
                adt.notifyDataSetChanged();
            }
        });


    }
}