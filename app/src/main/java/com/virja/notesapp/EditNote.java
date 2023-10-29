package com.virja.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditNote extends AppCompatActivity {
    EditText edit;
    String note=" ";
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        edit=findViewById(R.id.etEditNote);
         position=getIntent().getIntExtra("pos", -1);
        if(position!=-1)
            edit.setText(MainActivity.notes.get(position));
        else{
            edit.setText("NOTE");
        }
    }

    public void ADD(View v){
        if(position!=-1){
            MainActivity.notes.set(position,edit.getText().toString());
            MainActivity.adapter.notifyDataSetChanged();
        }
        finish();

    }
}