package sg.edu.rp.c346.id21021749.nationaldaythemesong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource; //layout file for the ro
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // create object layout

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);


        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        TextView tvYear = rowView.findViewById(R.id.tvStar);
        TextView tvStar = rowView.findViewById(R.id.tvSinger);

        // Obtain the Android Version information based on the position
        song currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvSinger.setText(currentVersion.getSingers());
        tvYear.setText(currentVersion.getYear());

        String star = "";
        if (currentVersion.getRating() == 1) { star = "*"; }
        else if (currentVersion.getRating() == 2) { star = "**"; }
        else if (currentVersion.getRating() == 3) { star = "***"; }
        else if (currentVersion.getRating() == 4) { star = "****"; }
        else if (currentVersion.getRating() == 5) { star = "*****"; }
        tvStar.setText(star);

        return rowView;
    }

}

