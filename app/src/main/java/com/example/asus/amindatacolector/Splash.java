package com.example.asus.amindatacolector;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.example.asus.amindatacolector.Fragments.OneFragment;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Splash extends AppCompatActivity {
    String check;

    private void KeyHash() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        //String   token = FirebaseInstanceId.getInstance().getToken();
        // Log.i("FCM Registration Token:", token);

       KeyHash();

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    int logoTimer = 0;
                    while (logoTimer < 5000) {
                        sleep(500);
                        logoTimer = logoTimer + 100;
                    }
                    check = getSharedPreferences("logincheck", MODE_PRIVATE).getString("login", "");
                    Log.d("checklogin", check);
                    if (check != null) {
                        if (check.equalsIgnoreCase("true")) {
                            Intent i = new Intent(Splash.this, OneFragment.class);
                            startActivity(i);
                            finish();
                        }
                        }

                    // startActivity(new Intent(Splash.this, MainActivity.class));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        logoTimer.start();

    }


}
