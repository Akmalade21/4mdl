package com.example.a4mdl;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText tanggal, waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanggal = findViewById(R.id.tanggal);
        waktu = findViewById(R.id.waktu);
    }

    public void setTanggal(View v) {
        final Calendar c = Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, thn1, bln1, tgl1) -> {
            // Mengatur format tanggal
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
            c.set(thn1, bln1, tgl1);
            String formattedDate = sdf.format(c.getTime());
            tanggal.setText(formattedDate);
        }, thn, bln, tgl);
        datePickerDialog.show();
    }

    public void setWaktu(View v) {
        final Calendar c = Calendar.getInstance();
        int jam = c.get(Calendar.HOUR_OF_DAY);
        int menit = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, (view, jam1, menit1) -> {
            waktu.setText(jam1 + ":" + menit1);
        }, jam, menit, false);
        timePickerDialog.show();
    }

    public void showFragment(View v) {
        Fragment fragment = new Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}