package com.virja.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNote extends AppCompatActivity {
    EditText etAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etAdd=findViewById(R.id.etAddnote);
    }
    public void ADD(View v){
        String inputenote="";
        try{
            inputenote=etAdd.getText().toString();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Please Try Again",Toast.LENGTH_SHORT).show();
        }
        MainActivity.notes.add(inputenote);
        MainActivity.adapter.notifyItemInserted(MainActivity.notes.size());
        finish();
    }
}