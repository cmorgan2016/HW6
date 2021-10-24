package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText num1, num2;
    TextView result;
    Button submit;
    Double c;
    String[] op = {"Operator", "+", "-", "x", "/"};
    String oper;
    String prob = "Error";

    public OnClickListener MainLister = new OnClickListener() {
        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        public void onClick(View v) {
            if (oper == "+") {
                c = a + b;
                result.setText(Double.toString(c));
            }
            if (oper == "-") {
                c = a - b;
                result.setText(Double.toString(c));
            }
            if (oper.equals("x")) {
                c = a * b;
                result.setText(Double.toString(c));
            }
            if (oper == "/") {
                c = a / b;
                result.setText(Double.toString(c));
            }
            if (oper == "Operator") {
                c = a + b;
                result.setText("Pick Operator");
            }
        }


        void onCreate(Bundle savedInstanceState) {
            setContentView(R.layout.activity_main);

            result = (TextView) findViewById(R.id.textView2);

            submit = (Button) findViewById(R.id.button5);
            submit.setOnClickListener(MainLister);

            num1 = (EditText) findViewById(R.id.editTextNumber);
            num2 = (EditText) findViewById(R.id.editTextNumber2);

            spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.op, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(MainActivity.this);

        }

    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        oper = op[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        result.setText(prob);
    }
}