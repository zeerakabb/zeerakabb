package com.accentype.android.softkeyboard;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class SplashActivity extends AppCompatActivity {
    ProgressDialog progressDialgue;
   // InterstitialAd ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

   //         ad = new InterstitialAd(this);
     //       ad.setAdUnitId(getString(R.string.ad_interstitial_splash));

       //     ad.loadAd(new AdRequest.Builder().build());
//            ad.setAdListener(new AdListener() {
//                @Override
//                public void onAdClosed() {
//                    super.onAdClosed();
//                    startActivity(new Intent(getApplicationContext(), DashBoardActivity.class));
//                    finish();
//                }
//
//            });
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialgue = new ProgressDialog(SplashActivity.this);
                        progressDialgue.show();
                        progressDialgue.setContentView(R.layout.progress_dialgoue);
                        progressDialgue.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    }
                }, 2000);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            startActivity(new Intent(getApplicationContext(), DashBoardActivity.class));
                            finish();

                    }
                }, 6000);

        }
        catch (Exception ex) {
            Log.d("Execption", ex.getMessage());
        }
    }
}