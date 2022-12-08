package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button search;
    EditText surat;
    EditText ayat;
    TextView disp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        search = findViewById(R.id.btnSearch);
        surat = findViewById(R.id.suratTxt);
        ayat = findViewById(R.id.ayatTxt);
        disp = findViewById(R.id.displayView);
        quranHelper qh = new quranHelper();
        quranTxt qt = new quranTxt();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int suratInt = Integer.parseInt(surat.getText().toString());
                int ayatInt = Integer.parseInt((ayat.getText().toString()));
                int temp1 = qh.SSP[suratInt-1];
                int temp2 = temp1 + ayatInt;
                disp.setText(qt.QuranArabicText[temp2-1]);

            }
        });

    }
}