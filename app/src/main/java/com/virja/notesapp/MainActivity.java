package com.virja.notesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    static RvAdapter adapter;
    static ArrayList<String> notes;
    SharedPreferences sharedPreferences;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.addnote) {
            Intent intent = new Intent(MainActivity.this, AddNote.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    public void SaveData(){
        //sharedPreferences.edit().putString("array",)

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        sharedPreferences=this.getSharedPreferences(" com.virja.notesapp",MODE_PRIVATE);
        if (notes == null) {
            notes = new ArrayList<>();
        }
        notes.add("Note 1");
        notes.add("Note 2");
        notes.add("Note 3");
        notes.add("Note 4");

        adapter = new RvAdapter(notes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


        adapter.itemClicked(new RvAdapter.ItemClickedListener() {
            @Override
            public void itemClicked(int position) {
                Intent intent = new Intent(MainActivity.this, EditNote.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }

            @Override
            public void deleteClicked(int position) {
                if (position >= 0 && position < notes.size()) {
                    notes.remove(position);
                    adapter.notifyDataSetChanged();

                }
            }

        });
    }

}