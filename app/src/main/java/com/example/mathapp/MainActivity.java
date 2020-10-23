package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etInputOne, etInputTwo;
    private TextView tvOutput, tvInputOne, tvInputTwo, tvAction;
    private double num1, num2, sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInputOne = findViewById(R.id.et_add);
        etInputTwo = findViewById(R.id.et_subs);
        tvInputOne = findViewById(R.id.tv_input_one);
        tvInputTwo = findViewById(R.id.tv_input_two);
        tvAction = findViewById(R.id.tv_action);
        tvOutput = findViewById(R.id.tv_output);
    }

    public void onAdd(View view) {
        num1 = Double.parseDouble(etInputOne.getText().toString());
        num2 = Double.parseDouble(etInputTwo.getText().toString());
        sum = num1 + num2;

        ContentValues values = new ContentValues();
        values.put(ApplicationConstant.COLUMN_EMAIL, sum);
        Uri uri = getContentResolver().insert(CustomContentProvider.CONTENT_URI, values);
        tvOutput.setText("");
        Toast.makeText(getBaseContext(), " Added Successfully!", Toast.LENGTH_LONG).show();


    }

    public void onSubs(View view) {
        num1 = Double.parseDouble(etInputOne.getText().toString());
        num2 = Double.parseDouble(etInputTwo.getText().toString());
        sum = num1 - num2;
        tvOutput.setText("Output: -" + Double.toString(sum));
        tvInputOne.setText("Input one:-" + String.valueOf(num1));
        tvInputTwo.setText("Input two:-" + String.valueOf(num2));
        tvAction.setText("Action :- Substraction");
    }
}