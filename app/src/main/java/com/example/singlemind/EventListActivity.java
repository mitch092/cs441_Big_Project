package com.example.singlemind;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);



        //test objects
        events.add(new Event(2, "Birthday", "Billy's Birthday", "1987-12-31 12:00:00:000"));
        events.add(new Event());

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, events);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void refreshEvents () {

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Event selected = new Event();
        selected = events.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event Options");
        builder.setMessage("Modify, Delete, or Cancel");

        builder.setPositiveButton("Modify",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //modify or update event OR delete current event and call add event

                        dialog.cancel();
                    }
                }
        );

        builder.setNeutralButton("Delete",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //delete event

                        dialog.cancel();
                    }
                }
        );

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
                );
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onAcct(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
    public void onAdd(View view){
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }
    public void onSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
