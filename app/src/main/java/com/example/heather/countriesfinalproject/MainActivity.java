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
import android.widget.Toast;

/**
 * MainActivity class sets up the widgets from the activity_main.xml to the variables created in this class in the onCreate() method.
 * Also in the onCreate() method there is a listener for the radio button group that will change the search field to the name of the
 * country that is selected. In the btnClick() method the information that the user wants to know is recorded and sent to the second
 * activity in the intent call. onActivityResult() method goal is to only reset the search parameters.
 *
 * @author Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */
public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;

    EditText etCountrySearch;
    RadioButton rbCanada, rbMexico, rbChristmas;
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

    /**
     * onCreate() method links the variables created in this class to the widget ID
     * in the activity_main.xml file. This also houses a listener for the radio group that
     * when a radio button is selected the name in the search edit text will be changed accordingly.
     *
     * @param savedInstanceState - standard onCreate() parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCountrySearch = (EditText) findViewById(R.id.editTextCountrySearch);
        rbCanada = (RadioButton) findViewById(R.id.radioButtonCanada);
        rbMexico = (RadioButton) findViewById(R.id.radioButtonMexico);
        rbChristmas = (RadioButton) findViewById(R.id.radioButtonChristmas);
        cbCapital = (CheckBox) findViewById(R.id.checkBoxCCapital);
        cbAltSpelling = (CheckBox) findViewById(R.id.checkBoxCAltSpelling);
        cbRegion = (CheckBox) findViewById(R.id.checkBoxCRegion);
        cbPopulation = (CheckBox) findViewById(R.id.checkBoxCPopulation);
        cbTimeZone = (CheckBox) findViewById(R.id.checkBoxCTimeZone);
        cbFlag = (CheckBox) findViewById(R.id.checkBoxCFlag);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_top);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if (rbCanada.isChecked()) { countryToGet = "Canada"; etCountrySearch.setText("Canada");}
                else if (rbMexico.isChecked()) { countryToGet = "Mexico"; etCountrySearch.setText("Mexico");}
                else if (rbChristmas.isChecked()) { countryToGet = "Christmas Island";etCountrySearch.setText("Christmas Island");}
            }
        });

    }

    /**
     * btnClick() method listens for the button buttonSearch to be clicked. It sets the boolean
     * variables to let the next activity know what info to display to the user. These are sent
     * via bundle in the intent to go to the ResultActivity.
     *
     * @param v - standard buttonClick() parameter
     */
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

        startActivityForResult(resultIntent, REQUEST_CODE);


    }

    /**
     * onActivityResult() method is called after the intent in ResultActivity is called to start
     * this activity again. It requires the requestCode, resultCode, and the intent. The requestCode is already set in this class
     * so the resultCode and the intent is really the only params being passed. This methods goal is to make a toast message
     * letting the user know that the previous search has been cleared and then it does clear all of the previous search criteria.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

            Toast toast=Toast.makeText(getApplicationContext(), "Cleared Previous Search",Toast.LENGTH_LONG );
            toast.show();

            etCountrySearch.setText("");
            radioGroup.clearCheck();

            if(cbCapital.isChecked()){
                cbCapital.toggle();
                capital = false;
            }

            if(cbAltSpelling.isChecked()){
                cbAltSpelling.toggle();
                altSpelling = false;
            }
            if(cbRegion.isChecked()){
                cbRegion.toggle();
                region = false;
            }

            if(cbPopulation.isChecked()){
                cbPopulation.toggle();
                population = false;
            }
            if(cbTimeZone.isChecked()){
                cbTimeZone.toggle();
                timeZone = false;
            }

            if(cbFlag.isChecked()){
                cbFlag.toggle();
                flag = false;
            }

            }
        }
    }





