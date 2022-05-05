package com.example.mcl.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import com.example.mcl.R;
import com.example.mcl.databinding.SplashActivityBinding;

public class SplashActivity extends AppCompatActivity {
private SplashActivityBinding binding;
private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        context= this;
       clickMethod();
    }
    private void clickMethod(){
        CountDownTimer cDt = new CountDownTimer(3000,100) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
             startActivity(new Intent(context,LoginActivity.class));
             finish();
            }
        };
        cDt.start();
    }
}