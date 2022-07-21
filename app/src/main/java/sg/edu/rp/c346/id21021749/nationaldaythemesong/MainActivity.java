package sg.edu.rp.c346.id21021749.nationaldaythemesong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnList;
    RadioGroup rgRatings;
    ArrayList<song> alSong;
    ArrayAdapter<song> aaSong;
    RadioButton rb1, rb2, rb3, rb4, rb5,rb;
    song data;
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent y = getIntent();
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rgRatings = findViewById(R.id.rGButton);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        lv = findViewById(R.id.lvSongs);
        data = (song) y.getSerializableExtra("data");


        aaSong = new ArrayAdapter<song>(this,
                android.R.layout.simple_list_item_1, alSong);
        alSong = new ArrayList<song>();
        lv.setAdapter(aaSong);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                String title = etTitle.getText().toString();
                String singers = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int ratings = rgRatings.getCheckedRadioButtonId();
                rb = findViewById(ratings);
                int rating = Integer.parseInt(rb.getText().toString());
                Log.d("result",rating+"");
                Log.d("result",ratings+"");



                long inserted_id = dbh.insertSong(title,singers,year,ratings);
                if (inserted_id != -1){
                    alSong.clear();
                    alSong.addAll(dbh.getAllSongs());
                    aaSong.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Song added is successful",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Song is unable to be added",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListView.class);
                startActivity(i);

            }
        });
    }
}