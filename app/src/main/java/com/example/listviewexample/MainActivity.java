package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import model.Pet;

public class MainActivity extends AppCompatActivity {
    ListView petListWidget;
    ArrayList<Pet> pets = new ArrayList<>();
    AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Pet selected = (Pet) adapterView.getItemAtPosition(i);
            String message = "Hello " + selected.getName() + "!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

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

        petListWidget.setOnItemClickListener(clickListener);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                petListWidget.setOnItemClickListener(clickListener);
                break;
            case 3:
                usingTwoLines();
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
        ArrayAdapter<Pet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, pets);
        petListWidget.setAdapter(adapter);
    }

    private void usingTwoLines() {
        List<HashMap<String, String>> data = new ArrayList<>();
        for (Pet p : pets) {
            HashMap<String, String> current = new HashMap<>();
            current.put("name", p.getName());
            current.put("breed", p.getBreed());
            data.add(current);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2,
                new String[]{"name", "breed"},
                new int[]{android.R.id.text1, android.R.id.text2});
        petListWidget.setAdapter(adapter);
    }
}