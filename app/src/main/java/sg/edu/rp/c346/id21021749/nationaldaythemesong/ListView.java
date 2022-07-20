package sg.edu.rp.c346.id21021749.nationaldaythemesong;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ListView extends AppCompatActivity {

    Button show5;
    ArrayList<song> alSong;
    ArrayAdapter<song> aaSong;
    song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        show5 = findViewById(R.id.btnShow);
        Intent i = getIntent();
        data = (song) i.getSerializableExtra("data");



    }
}
