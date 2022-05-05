package com.example.mcl.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mcl.R;
import com.example.mcl.databinding.CompanyLoanActivityBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CompanyLoanActivity extends AppCompatActivity {
    private CompanyLoanActivityBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.company_loan_activity);
        context = this;
        clickMethod();
    }

    private void clickMethod() {
        binding.iEtTodayDate.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
        binding.ivBack.setOnClickListener(m->{
            onBackPressed();
        });

        binding.iEtOwenrShipOffice.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.ownership_office, null);
            builder.setView(vi);
            TextView own = vi.findViewById(R.id.tvOwn);
            TextView rented = vi.findViewById(R.id.tvRented);
            TextView other = vi.findViewById(R.id.tvOther);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            own.setOnClickListener(view -> {
                binding.llOwnrShipProof.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOtherDocumentary.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.GONE);
                binding.iEtOwenrShipOffice.setText(own.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();
            });

            rented.setOnClickListener(v1 -> {
                binding.tilYesNo.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOtherDocumentary.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.GONE);
                binding.iEtOwenrShipOffice.setText(rented.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();
            });

            other.setOnClickListener(v1 -> {
                binding.llOtherDocumentary.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.GONE);
                binding.iEtOwenrShipOffice.setText(other.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();

                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtYesNo.setOnClickListener(m->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.yes_no_selected_design, null);
            builder.setView(vi);
            TextView yes = vi.findViewById(R.id.tvYes);
            TextView no = vi.findViewById(R.id.tvNo);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            yes.setOnClickListener(view -> {
                binding.llRentedAggrement.setVisibility(View.VISIBLE);
                binding.llRented.setVisibility(View.GONE);
                binding.iEtYesNo.setText(yes.getText().toString());
                dialog.dismiss();
            });

            no.setOnClickListener(v1 -> {
                binding.llRentedAggrement.setVisibility(View.GONE);
                binding.llRented.setVisibility(View.VISIBLE);
                binding.iEtYesNo.setText(no.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
    }
}