package com.example.heather.countriesfinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText etCountrySearch;
    RadioButton rbCanada, rbMexico, rbUS;
    CheckBox cbCapital, cbAltSpelling, cbRegion, cbPopulation, cbTimeZone, cbFlag;
    Button buttonSearch;

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
    }
}
