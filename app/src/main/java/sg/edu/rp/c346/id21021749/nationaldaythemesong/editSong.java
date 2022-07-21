package sg.edu.rp.c346.id21021749.nationaldaythemesong;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.appcompat.app.AppCompatActivity;

public class editSong extends AppCompatActivity {


    EditText etId, etSong, etSinger, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgNewRadio;
    RadioButton rEdit1,rEdit2,rEdit3,rEdit4,rEdit5, rEdit;
    song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_song);

        //initialize the variables with UI here

        etId = findViewById(R.id.etID);
        etSinger = findViewById(R.id.etSinger);
        etSong = findViewById(R.id.etTitle);
        etYear = findViewById(R.id.etYear);

        rEdit1 = findViewById(R.id.star1);
        rEdit2 = findViewById(R.id.star2);
        rEdit3 = findViewById(R.id.star3);
        rEdit4 = findViewById(R.id.star4);
        rEdit5 = findViewById(R.id.star5);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        rgNewRadio = findViewById(R.id.rgNewButton);


        Intent i = getIntent();
        data = (song) i.getSerializableExtra("data");

        etSong.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editSong.this);
                data.setTitle(etSong.getText().toString());
                data.setSinger(etSinger.getText().toString());
                data.setYear(etYear.getText().toString());
                int rgRadio = rgNewRadio.getCheckedRadioButtonId();
                rEdit = findViewById(rgRadio);
                int rating = Integer.parseInt(rEdit.getText().toString());
                Log.d("result",rating+"");
                Log.d("result",rgRadio+"");


                data.setRating(rating);

                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editSong.this);
                dbh.deleteSong(data.get_id());
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
