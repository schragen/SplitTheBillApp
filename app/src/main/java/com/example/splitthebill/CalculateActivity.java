package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CalculateActivity extends AppCompatActivity {

    final double tip = .18;
    int numPersons;
    double totalBill;
    double tipTotal;
    double shareTotal;
    String groupChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        final EditText bill = (EditText)findViewById(R.id.billInput);
        final EditText persons = (EditText)findViewById(R.id.personInput);
        final Spinner group = (Spinner)findViewById(R.id.qualitySpinner);
        Button calculateButton = (Button)findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            final TextView resultTip = ((TextView)findViewById(R.id.tipResult));
            final TextView resultShare = ((TextView)findViewById(R.id.shareResult));
            @Override
            public void onClick(View v) {
                totalBill = Double.parseDouble(bill.getText().toString());
                numPersons = Integer.parseInt((persons.getText().toString()));
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                tipTotal = totalBill * tip;
                shareTotal = (totalBill + tipTotal) / numPersons;
                groupChoice = group.getSelectedItem().toString();
                resultTip.setText(currency.format(tipTotal));
                resultShare.setText(currency.format(shareTotal));
            }
        });

    }
}

