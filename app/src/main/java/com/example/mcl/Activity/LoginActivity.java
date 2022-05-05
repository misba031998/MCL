package com.example.mcl.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.mcl.R;
import com.example.mcl.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        context=this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        clickMethod();
    }

    private void clickMethod() {
        binding.adTvLogin.setOnClickListener(v -> {
         startActivity(new Intent(this,MainActivity.class));
        });
    }
}