package com.accentype.android.softkeyboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.mediation.Adapter;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity
{
    ListView listview;

    String mtitle[] = {"Themes Options", "Preferences", "Share APP", "Rate APP",  "About US"};
    String subtitle[] = {"Change Themes accordingly", "Set Preferences for keyboards", "Share APK to friends ", "Gives US Ratings", "About the Keyboard"};
    int Images[] = {R.color.candidate_recommended, R.color.candidate_recommended, R.color.candidate_recommended, R.color.candidate_recommended, R.color.candidate_recommended, R.color.candidate_recommended};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        listview = findViewById(R.id.lv_Colors);
        myadapter adapter = new myadapter(this, mtitle, subtitle, Images);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position==0)
                {
                    Intent in =new Intent(SettingsActivity.this, Themes.class);
                    startActivity(in);
                }
                if(position==1)
                {
                    Intent in =new Intent(getApplicationContext(), ImePreferences.class);
                    startActivity(in);
                }
                if(position==2)
                {
                         Intent in = new Intent(Intent.ACTION_SEND);
                        in.setType("text/plain");
                        String shareBody = "Download this Application Now:-";
                        String shareSub = "keyBoard app";
                        in.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                        in.putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(in, "Share using"));
                }
                if(position==3)
                {
                    Toast.makeText(SettingsActivity.this, "Rate US", Toast.LENGTH_SHORT).show();
                }
                if(position==4)
                {
                    Toast.makeText(SettingsActivity.this, "About US", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class myadapter extends ArrayAdapter {
        Context context;
        String rtitle[];
        String Stitle[];
        int rimages[];

        myadapter(Context c, String title[], String subtitle[], int images[])
        {
            super(c, R.layout.row, R.id.textview1, title);
            this.context = c;
            this.rtitle = title;
            this.Stitle = subtitle;
            this.rimages = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView img = row.findViewById(R.id.Image_colors_images);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView subTitle = row.findViewById(R.id.textview2);
            img.setImageResource(rimages[position]);
            myTitle.setText(rtitle[position]);
            subTitle.setText(Stitle[position]);
            return row;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent in =new Intent(getApplicationContext(),DashBoardActivity.class);
        startActivity(in);
    }
}