package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    Button btnCalculate, btnClear;
    EditText edt_input;
    RadioButton rdUSDtoBDT, rdBDTtoUSD, rdINRtoUSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        edt_input= findViewById(R.id.edt_input);
        rdBDTtoUSD = findViewById(R.id.rdBDTtoUSD);
        rdUSDtoBDT = findViewById(R.id.rdUSDtoBDT);
        rdINRtoUSD = findViewById(R.id.rdINRtoUSD);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double input = new Double(edt_input.getText().toString());
                if(rdBDTtoUSD.isChecked()){
                    double result = ConvertCurrency.bdtUSD(input);

                    edt_input.setText(new Double(result).toString());
                }
                else if(rdUSDtoBDT.isChecked()){
                    double result = ConvertCurrency.usdBDT(input);
                    edt_input.setText(new Double(result).toString());
                }
                else if(rdINRtoUSD.isChecked()){
                    double result = ConvertCurrency.inrUSD(input);
                    edt_input.setText(new Double(result).toString());
                }
            }
        });
    }
}