package com.example.mcl.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcl.R;
import com.example.mcl.databinding.ApplicentResidencePersonalActivityBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class ApplicentResidencePersonalActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private ApplicentResidencePersonalActivityBinding binding;
    private Context context;
    private String metParson;
    private String owenrShip;
    private String dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.applicent_residence_personal_activity);
        context = this;
        clickMethod();
    }

    private void clickMethod() {
        binding.iEtTodaydate.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
        binding.ivBack.setOnClickListener(m -> {
            onBackPressed();
        });
        /*binding.tiLayoutAplicantDob.setOnClickListener(m->{
          ageSet();
        });*/
        binding.iEtApplicantDob.setOnClickListener(m->{
            showDatePicker();
           // ageSet();
        });
        binding.iEtNamePersonVerivication.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.met_verivication_persion, null);
            builder.setView(vi);
            TextView applicant = vi.findViewById(R.id.tvApplicant);
            TextView otherThenApplicant = vi.findViewById(R.id.tvOtherThenApplicant);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            applicant.setOnClickListener(view -> {
                metParson = "APPLICANT";
                binding.iEtNamePersonVerivication.setText(applicant.getText().toString());
                binding.llrelation.setVisibility(View.GONE);
                binding.Til.setVisibility(View.VISIBLE);
                dialog.dismiss();
            });

            otherThenApplicant.setOnClickListener(v1 -> {
                metParson = "OTHERAPPLICANT";
                binding.iEtNamePersonVerivication.setText(otherThenApplicant.getText().toString());
                binding.Til.setVisibility(View.GONE);
                binding.llrelation.setVisibility(View.VISIBLE);
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtOwenrShipHouse.setOnClickListener(v2 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.ownership_of_house, null);
            builder.setView(vi);
            TextView own = vi.findViewById(R.id.tvOwn);
            TextView rented = vi.findViewById(R.id.tvRented);
            TextView alloted = vi.findViewById(R.id.tvAlloted);
            TextView other = vi.findViewById(R.id.tvOther);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            own.setOnClickListener(view -> {
                //binding.llRentedProof.setVisibility(View.GONE);
                //binding.llRented.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOtherDocumentary.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.GONE);
                binding.iEtOwenrShipHouse.setText(own.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();
            });

            rented.setOnClickListener(v1 -> {
               // binding.llRentedProof.setVisibility(View.VISIBLE);
                //binding.llRented.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOtherDocumentary.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.GONE);
                binding.iEtOwenrShipHouse.setText(rented.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();
            });
            alloted.setOnClickListener(v1 -> {
                //binding.llRented.setVisibility(View.GONE);
                //binding.llRentedProof.setVisibility(View.GONE);
                binding.llAllotementLatter.setVisibility(View.VISIBLE);
                binding.llOtherDocumentary.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.GONE);
                binding.iEtOwenrShipHouse.setText(alloted.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
                dialog.dismiss();
            });
            other.setOnClickListener(v1 -> {
                //binding.llRented.setVisibility(View.VISIBLE);
                //binding.llRentedProof.setVisibility(View.GONE);
                binding.llOtherDocumentary.setVisibility(View.VISIBLE);
                binding.llAllotementLatter.setVisibility(View.GONE);
                binding.llOwnrShipProof.setVisibility(View.GONE);
                binding.tilYesNo.setVisibility(View.GONE);
                binding.iEtOwenrShipHouse.setText(other.getText().toString());
                binding.llRented.setVisibility(View.GONE);
                binding.llRentedAggrement.setVisibility(View.GONE);
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

        binding.iEtGender.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.gender_design, null);
            builder.setView(vi);
            TextView male = vi.findViewById(R.id.tvMale);
            TextView female = vi.findViewById(R.id.tvFemale);
            TextView other = vi.findViewById(R.id.tvOther);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            male.setOnClickListener(view -> {
                binding.iEtGender.setText(male.getText().toString());
                dialog.dismiss();
            });

            female.setOnClickListener(v1 -> {
                binding.iEtGender.setText(female.getText().toString());
                dialog.dismiss();
            });
            other.setOnClickListener(view -> {

                binding.iEtGender.setText(other.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtAadharCard.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.applicant_coapplicant_design, null);
            builder.setView(vi);
            TextView applicant = vi.findViewById(R.id.tvApplicant);
            TextView coApplicant = vi.findViewById(R.id.tvCoApplicant);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            applicant.setOnClickListener(view -> {
                binding.iEtAadharCard.setText(applicant.getText().toString());
                dialog.dismiss();
            });

            coApplicant.setOnClickListener(v1 -> {
                binding.iEtAadharCard.setText(coApplicant.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtPanCard.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.applicant_coapplicant_design, null);
            builder.setView(vi);
            TextView applicant = vi.findViewById(R.id.tvApplicant);
            TextView coApplicant = vi.findViewById(R.id.tvCoApplicant);

            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            applicant.setOnClickListener(view -> {
                binding.iEtPanCard.setText(applicant.getText().toString());
                dialog.dismiss();
            });

            coApplicant.setOnClickListener(v1 -> {
                binding.iEtPanCard.setText(coApplicant.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtCoAplOccupation.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.occupation_design, null);
            builder.setView(vi);
            TextView govSal = vi.findViewById(R.id.tvGovSalry);
            TextView mncsal = vi.findViewById(R.id.tvMncSalary);
            TextView pvtSal = vi.findViewById(R.id.tvPvtSalary);
            TextView selfEmpl = vi.findViewById(R.id.tvSelfEmploy);
            TextView other = vi.findViewById(R.id.tvOther);


            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            govSal.setOnClickListener(view -> {
                binding.tilOtherIncome.setVisibility(View.INVISIBLE);
                binding.iEtCoAplOccupation.setText(govSal.getText().toString());
                dialog.dismiss();
            });

            mncsal.setOnClickListener(v1 -> {
                binding.tilOtherIncome.setVisibility(View.INVISIBLE);
                binding.iEtCoAplOccupation.setText(mncsal.getText().toString());
                dialog.dismiss();
            });
            pvtSal.setOnClickListener(view -> {
                binding.tilOtherIncome.setVisibility(View.INVISIBLE);
                binding.iEtCoAplOccupation.setText(pvtSal.getText().toString());
                dialog.dismiss();
            });

            selfEmpl.setOnClickListener(v1 -> {
                binding.tilOtherIncome.setVisibility(View.INVISIBLE);
                binding.iEtCoAplOccupation.setText(selfEmpl.getText().toString());
                dialog.dismiss();
            });
            other.setOnClickListener(v1 -> {
                binding.tilOtherIncome.setVisibility(View.VISIBLE);
                binding.iEtCoAplOccupation.setText(other.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtCoRelation.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.relation_design, null);
            builder.setView(vi);
            TextView sonof = vi.findViewById(R.id.tvSo);
            TextView wo = vi.findViewById(R.id.tvWo);
            TextView co = vi.findViewById(R.id.tvCo);
            TextView bo = vi.findViewById(R.id.tvBo);
            TextView dtrOf = vi.findViewById(R.id.tvDo);


            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            sonof.setOnClickListener(view -> {
                binding.iEtCoRelation.setText(sonof.getText().toString());
                dialog.dismiss();
            });

            wo.setOnClickListener(v1 -> {
                binding.iEtCoRelation.setText(wo.getText().toString());
                dialog.dismiss();
            });
            co.setOnClickListener(view -> {

                binding.iEtCoRelation.setText(co.getText().toString());
                dialog.dismiss();
            });

            bo.setOnClickListener(v1 -> {
                binding.iEtCoRelation.setText(bo.getText().toString());
                dialog.dismiss();
            });
            dtrOf.setOnClickListener(v1 -> {
                binding.iEtCoRelation.setText(dtrOf.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.iEtOccupation.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.occupation_design, null);
            builder.setView(vi);
            TextView govSal = vi.findViewById(R.id.tvGovSalry);
            TextView mncsal = vi.findViewById(R.id.tvMncSalary);
            TextView pvtSal = vi.findViewById(R.id.tvPvtSalary);
            TextView selfEmpl = vi.findViewById(R.id.tvSelfEmploy);
            TextView other = vi.findViewById(R.id.tvOther);


            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            govSal.setOnClickListener(view -> {

                binding.iEtOccupation.setText(govSal.getText().toString());
                dialog.dismiss();
            });

            mncsal.setOnClickListener(v1 -> {

                binding.iEtOccupation.setText(mncsal.getText().toString());
                dialog.dismiss();
            });
            pvtSal.setOnClickListener(view -> {

                binding.iEtOccupation.setText(pvtSal.getText().toString());
                dialog.dismiss();
            });

            selfEmpl.setOnClickListener(v1 -> {

                binding.iEtOccupation.setText(selfEmpl.getText().toString());
                dialog.dismiss();
            });
            other.setOnClickListener(v1 -> {

                binding.iEtOccupation.setText(other.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        binding.iEtRelationship.setOnClickListener(m->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View vi = LayoutInflater.from(this).inflate(R.layout.relation_design, null);
            builder.setView(vi);
            TextView sonof = vi.findViewById(R.id.tvSo);
            TextView wo = vi.findViewById(R.id.tvWo);
            TextView co = vi.findViewById(R.id.tvCo);
            TextView bo = vi.findViewById(R.id.tvBo);
            TextView dtrOf = vi.findViewById(R.id.tvDo);


            builder.setCancelable(false);
            final AlertDialog dialog = builder.create();
            sonof.setOnClickListener(view -> {
                binding.iEtRelationship.setText(sonof.getText().toString());
                dialog.dismiss();
            });

            wo.setOnClickListener(v1 -> {
                binding.iEtRelationship.setText(wo.getText().toString());
                dialog.dismiss();
            });
            co.setOnClickListener(view -> {

                binding.iEtRelationship.setText(co.getText().toString());
                dialog.dismiss();
            });

            bo.setOnClickListener(v1 -> {
                binding.iEtRelationship.setText(bo.getText().toString());
                dialog.dismiss();
            });
            dtrOf.setOnClickListener(v1 -> {
                binding.iEtRelationship.setText(dtrOf.getText().toString());
                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

    }

    public void showDatePicker() {
        Calendar c = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(context, this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        //dialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
        dialog.show();
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String mmYYYY = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
        binding.iEtApplicantDob.setText(mmYYYY);

       SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
       String datNow = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        try {
            Date date1 = simpleDateFormat1.parse(mmYYYY);
            Date date2 = simpleDateFormat1.parse(datNow);

            long startdate = date1.getTime();
            long endDate =  date2.getTime();
            // condition
            if (startdate <= endDate) {
                org.joda.time.Period period = new Period(startdate, endDate, PeriodType.yearMonthDay());
                int years = period.getYears();
                int months = period.getMonths();
                int days = period.getDays();

                binding.iEtApplicantAge.setText(years+"");
                Log.e("MSG",years+"");
            } else {
                // show message
                Toast.makeText(this, "DOB should not be larger then today's date!", Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}