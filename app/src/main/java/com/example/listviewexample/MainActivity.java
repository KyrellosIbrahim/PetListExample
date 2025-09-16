package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import model.Pet;

public class MainActivity extends AppCompatActivity {
    ListView petListWidget;
    ArrayList<Pet> pets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pets = new ArrayList<>();
        pets.add(new Pet("German Shepherd", "Rex", 5));
        pets.add(new Pet("Bulldog", "Bruno", 3));
        pets.add(new Pet("Beagle", "Bella", 4));
        pets.add(new Pet("Poodle", "Luna", 2));
        pets.add(new Pet("Golden Retriever", "Max", 6));
        pets.add(new Pet("Dachshund", "Charlie", 1));
        pets.add(new Pet("Boxer", "Rocky", 4));
        pets.add(new Pet("Rottweiler", "Duke", 5));
        pets.add(new Pet("Siberian Husky", "Molly", 3));
        pets.add(new Pet("Doberman", "Zoe", 2));

        petListWidget = findViewById(R.id.listViewWidg);
        Random rand = new Random();
        int selection = 2;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contents);
        petListWidget.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter<Pet> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);
        petListWidget.setAdapter(adapter);
    }
}