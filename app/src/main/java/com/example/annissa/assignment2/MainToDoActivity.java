package com.example.annissa.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.util.*;
import java.util.ArrayList;


public class MainToDoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private String newaddition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_to_do);

        // this is where we reference 'displaylist' from the xml
        ListView finalList = (ListView) findViewById(R.id.displaylist);
        finalList.setOnItemClickListener(this);

        // connect the ListView to an ArrayList of to-do items
        list = new ArrayList<>();

        // create adapter to make it display right on screen
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );
        finalList.setAdapter(adapter);


    }

    // set the listview to store the new to-do items
    public void add(View view) {
        EditText newitemtext = (EditText) findViewById(R.id.newitemtext);
        newaddition = newitemtext.getText().toString();
        list.add(newaddition);
        adapter.notifyDataSetChanged();
        newitemtext.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView finalList = (ListView) findViewById(R.id.displaylist);
        String text = finalList.getItemAtPosition(position).toString();
        Toast.makeText(this, "Good job completing '" + text + "' !", Toast.LENGTH_SHORT).show();
        list.remove(position);
        adapter.notifyDataSetChanged();

    }
}
// for part about deleting, see video 4 minute 36