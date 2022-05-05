package com.example.mcl.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcl.Adapter.SliderPagerAdapter;
import com.example.mcl.R;
import com.example.mcl.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Context context;
    private Runnable runnable;
    private Handler handler;
    private SliderPagerAdapter sliderAdapter;
    private String loneType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this;
        clickMethod();
        adapterDataSet();
    }

    private void adapterDataSet() {
        sliderAdapter = new SliderPagerAdapter(context);
        binding.imagePager.setAdapter(sliderAdapter);
        startAutoSlider(sliderAdapter.getCount());
    }

    private void startAutoSlider(final int count) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = binding.imagePager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                binding.imagePager.setCurrentItem(pos, true);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void clickMethod() {
        binding.iEtLoanSelect.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.select_lone_type_design, null);
            builder.setView(vi);
            TextView appliResiPer = vi.findViewById(R.id.tvapliResidentPersonal);
            TextView coAppliResi = vi.findViewById(R.id.tvcoAppliResidence);
            TextView appliOffice = vi.findViewById(R.id.tvAppliOfficePersonal);
            TextView coAppliOffice = vi.findViewById(R.id.tvCoApliOffice);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            appliResiPer.setOnClickListener(view -> {
                loneType = "APPLICANTRESIDENCE";
                binding.iEtLoanSelect.setText(appliResiPer.getText().toString());

                dialog.dismiss();
            });
            coAppliResi.setOnClickListener(view -> {
                loneType = "COAPPLICANTRESI";
                binding.iEtLoanSelect.setText(coAppliResi.getText().toString());

                dialog.dismiss();
            });
            appliOffice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loneType = "APPLICANTOFFICE";
                    binding.iEtLoanSelect.setText(appliOffice.getText().toString());

                    dialog.dismiss();
                }
            });
            coAppliOffice.setOnClickListener(view -> {
                loneType = "COAPPLICANTOFFICE";
                binding.iEtLoanSelect.setText(coAppliOffice.getText().toString());

                dialog.dismiss();
            });
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });


        binding.adTvNext.setOnClickListener(v -> {
            try {
                switch (loneType) {
                    case "APPLICANTRESIDENCE":
                        startActivity(new Intent(this, ApplicentResidencePersonalActivity.class));
                        break;
                    case "COAPPLICANTRESI":
                        startActivity(new Intent(this, GroupLoanActivity.class));
                        break;
                    case "APPLICANTOFFICE":
                        startActivity(new Intent(this, CompanyLoanActivity.class));
                        break;
                    case "COAPPLICANTOFFICE":
                        startActivity(new Intent(this, VehicleLoanActivity.class));
                        break;
                }
            } catch (Exception mk) {
            }

        });

        binding.navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.notification) {
                    Toast.makeText(getApplication(), "Notifications", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.account) {
                    Toast.makeText(getApplication(), "Account", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        binding.tvTitle.setOnClickListener(m -> {
            binding.drLayout.openDrawer(GravityCompat.START);
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.tvTitle) {
            // binding.drLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}