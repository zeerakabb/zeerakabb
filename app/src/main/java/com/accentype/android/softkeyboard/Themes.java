package com.accentype.android.softkeyboard;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.google.android.gms.ads.mediation.Adapter;

import java.util.ArrayList;

public class Themes extends AppCompatActivity  implements MaxAdViewAdListener {
//    ListView lv_themes;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
//
//    String mtitle[] = {"Red", "Blue", "Green", "Indigo", "Violet", };
//    String subtitle[] = {"Red Color", "Blue Color", "Green Rainbow" , "Indigo Rainbow Color", "Violet Raibow Color"};
//    int Images[] = {R.color.red, R.color.blue, R.color.green, R.color.indigo, R.color.violet};
//
//    @Override
//        protected void onCreate (Bundle savedInstanceState)
//    {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.themes);
//                lv_themes = findViewById(R.id.listThemes1);
//
//                myadapter adapter = new myadapter(this, mtitle, subtitle, Images);
//                      lv_themes.setAdapter(adapter);
////                      lv_themes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////         @Override
////         public void onItemClick(AdapterView<?> parent, View view, int position, long id)
////         {
////             if (position == 0)
////                        {
////                           SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
////                            editor.putInt("idName", 0);
////                            editor.commit();
////                            Toast.makeText(Themes.this, "Theme Applied", Toast.LENGTH_SHORT).show();
////                        }
////         }
//
//     //});
//        lv_themes.setOnItemClickListener(this);
//
////                        lv_themes.setOnItemClickListener(new AdapterView.OnItemClickListener()
////                        {
////                    @Override
////                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
////                    {
////                        if (position == 0)
////                        {
////                           SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
////                            editor.putInt("idName", 0);
////                            editor.commit();
////                            Toast.makeText(Themes.this, "Theme Applied", Toast.LENGTH_SHORT).show();
////                        }
////                        if (position == 1)
////                        {
////                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
////                            editor.putInt("idName", 1);
////                            editor.commit();
////                            Toast.makeText(Themes.this, "Theme Applied", Toast.LENGTH_SHORT).show();
////                        }
////                    }
////                });
////    }
//
//
//
//        }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
////                           SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
////                            editor.putInt("idName", 0);
////                            editor.commit();
////                            Toast.makeText(Themes.this, "Theme Applied", Toast.LENGTH_SHORT).show();
//                            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
//
//    }
//
//    class myadapter extends ArrayAdapter
//    {
//        Context context;
//        String rtitle[];
//        String Stitle[];
//        int rimages[];
//
//
//        myadapter(Context c, String title[], String subtitle[], int images[])
//        {
//            super(c, R.layout.row1, R.id.textview1, title);
//            this.context = c;
//            this.rtitle = title;
//            this.Stitle = subtitle;
//            this.rimages = images;
//        }
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
//        {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.row1, parent, false);
//            ImageView img = row.findViewById(R.id.Image_colors_images1);
//            TextView myTitle = row.findViewById(R.id.textview1);
//            TextView subTitle = row.findViewById(R.id.textview2);
//            img.setImageResource(rimages[position]);
//            myTitle.setText(rtitle[position]);
//            subTitle.setText(Stitle[position]);
//            return row;
//        }
//    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent in =new Intent(getApplicationContext(),DashBoardActivity.class);
//        startActivity(in);
//    }


    ListView listview;
    MaxAdView adView;

    String mtitle[] = {"Red Color", "blue", "indigo", "violet",  "green"};
    String subtitle[] = {"Change Themes Red", "Change Themes blue", "Change Themes indigo ", "Change Themes violet", "Change Themes green"};
    int Images[] = {R.color.red, R.color.blue, R.color.indigo, R.color.violet, R.color.green};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themes);
        listview = findViewById(R.id.listThemes1);
        adView=findViewById(R.id.bannerThemeID);
        adView.setListener(this);
        adView.loadAd();
        myadapter adapter = new myadapter(this, mtitle, subtitle, Images);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position==0)
                {
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("idName", 0);
                            editor.commit();
                    Toast.makeText(Themes.this, "Theme Applied Successfully", Toast.LENGTH_SHORT).show();
                }
                if(position==1)
                {

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName", 1);
                    editor.commit();
                    Toast.makeText(Themes.this, "Theme Applied Successfully", Toast.LENGTH_SHORT).show();
                }
                if(position==2)
                {
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName", 2);
                    editor.commit();
                    Toast.makeText(Themes.this, "Theme Applied Successfully", Toast.LENGTH_SHORT).show();
                }
                if(position==3)
                {
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName", 3);
                    editor.commit();
                    Toast.makeText(Themes.this, "Theme Applied Successfully", Toast.LENGTH_SHORT).show();
                }
                if(position==4)
                {
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName", 4);
                    editor.commit();
                    Toast.makeText(Themes.this, "Theme Applied Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onAdExpanded(MaxAd ad) {

    }

    @Override
    public void onAdCollapsed(MaxAd ad) {

    }

    @Override
    public void onAdLoaded(MaxAd ad) {
        adView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

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



