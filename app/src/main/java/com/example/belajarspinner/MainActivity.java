package com.example.belajarspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ImageView imageView;
    TextView textView;

    String[] namahewan = {"Cat", "Chicken", "Cow", "Horse", "Sheep"};
    int[] gambarhewan = {R.drawable.cat, R.drawable.chicken, R.drawable.cow, R.drawable.horse, R.drawable.sheep};
    int[] suarahewan = {R.raw.cat, R.raw.chicken, R.raw.cow, R.raw.horse, R.raw.sheep};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinn);
        imageView = (ImageView) findViewById(R.id.img);
        textView = (TextView) findViewById(R.id.txt);

        ArrayAdapter adapterhewan = new ArrayAdapter(this, android.R.layout.simple_spinner_item, namahewan);
        spinner.setAdapter(adapterhewan);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(gambarhewan[position]);
                textView.setText(namahewan[position]);
                MediaPlayer suara = MediaPlayer.create(MainActivity.this, suarahewan[position]);
                suara.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}