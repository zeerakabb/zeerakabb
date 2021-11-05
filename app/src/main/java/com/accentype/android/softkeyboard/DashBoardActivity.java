package com.accentype.android.softkeyboard;

import android.content.Intent;
import android.content.res.Resources;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;

public class DashBoardActivity extends AppCompatActivity implements  MaxAdViewAdListener {

    Button btn_enable , btn_select, btn_themes, btn_settings;
    private boolean mNeedsToAdjustStepNumberToSystemState;
    private MaxAdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dash_board);

            adView=findViewById(R.id.bannerDashBoard);
            adView.setListener(this);
            adView.loadAd();
            btn_enable = (Button) findViewById(R.id.btnEnable);
            btn_select = (Button) findViewById(R.id.btnSelect);
            btn_themes = (Button) findViewById(R.id.btnThemes);
            btn_settings = (Button) findViewById(R.id.btnSettings);
            btn_enable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //btn enabled
                    btn_select.setEnabled(true);
                    invokeLanguageAndInputSettings();
                }
            });
            btn_select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        invokeInputMethodPicker();
                    } catch (Exception ex) {
                        Toast.makeText(DashBoardActivity.this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btn_themes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(DashBoardActivity.this, Themes.class);
                    startActivity(in);
                }
            });
            btn_settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //btn settings
                    Intent in = new Intent(DashBoardActivity.this, SettingsActivity.class);
                    startActivity(in);
                }
            });
        }


    void invokeInputMethodPicker()
    {
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        imeManager.showInputMethodPicker();
    }

    void invokeLanguageAndInputSettings()
    {
        final Intent intent = new Intent();
        intent.setAction(Settings.ACTION_INPUT_METHOD_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
        mNeedsToAdjustStepNumberToSystemState = true;
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
}