package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText etCountrySearch;
    RadioButton rbCanada, rbMexico, rbUS;
    CheckBox cbCapital, cbAltSpelling, cbRegion, cbPopulation, cbTimeZone, cbFlag;
    Button buttonSearch;
    String countryToGet;
    RadioGroup radioGroup;
    boolean capital = false;
    boolean altSpelling = false;
    boolean region = false;
    boolean population = false;
    boolean timeZone = false;
    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCountrySearch = (EditText) findViewById(R.id.editTextCountrySearch);

        rbCanada = (RadioButton) findViewById(R.id.radioButtonCanada);
        rbMexico = (RadioButton) findViewById(R.id.radioButtonMexico);
        rbUS = (RadioButton) findViewById(R.id.radioButtonUS);
        cbCapital = (CheckBox) findViewById(R.id.checkBoxCCapital);
        cbAltSpelling = (CheckBox) findViewById(R.id.checkBoxCAltSpelling);
        cbRegion = (CheckBox) findViewById(R.id.checkBoxCRegion);
        cbPopulation = (CheckBox) findViewById(R.id.checkBoxCPopulation);
        cbTimeZone = (CheckBox) findViewById(R.id.checkBoxCTimeZone);
        cbFlag = (CheckBox) findViewById(R.id.checkBoxCFlag);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        etCountrySearch.setText("");


        radioGroup = (RadioGroup) findViewById(R.id.radio_group_top);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if (rbCanada.isChecked()) { countryToGet = "Canada"; etCountrySearch.setText("Canada");}
                else if (rbMexico.isChecked()) { countryToGet = "Mexico"; etCountrySearch.setText("Mexico");}
                else if (rbUS.isChecked()) { countryToGet = "United States";etCountrySearch.setText("United States");}
        }
    });

    }

    public void btnClick (View v) {
        if (radioGroup.isActivated() == false) {
            countryToGet = etCountrySearch.getText().toString(); }

        if (cbCapital.isChecked()) {
            capital = true;
        }
        if (cbAltSpelling.isChecked()) {
            altSpelling = true;
        }
        if (cbRegion.isChecked()) {
            region = true;
        }
        if (cbPopulation.isChecked()) {
            population = true;
        }
        if (cbTimeZone.isChecked()) {
            timeZone = true;
        }
        if (cbFlag.isChecked()) {
            flag = true;
        }


        Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
        resultIntent.putExtra("Country", countryToGet);
        resultIntent.putExtra("Capital", capital);
        resultIntent.putExtra("Alt Spelling", altSpelling);
        resultIntent.putExtra("Region", region);
        resultIntent.putExtra("Population", population);
        resultIntent.putExtra("Time Zone", timeZone);
        resultIntent.putExtra("Flag", flag);

        startActivity(resultIntent);


    }
}




