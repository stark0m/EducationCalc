package com.example.educationcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult ;
    private CalcActionAndResult calcActionAndResult = new CalcActionAndResult();
    private void updateInfo(){


        Log.d("Result",calcActionAndResult.toString());
        textViewResult.setText( calcActionAndResult.currentStringValue.toString());


    }
    private void setCurrentStringAction(Button button, CalcActionAndResult car){
        car.currentStringValue.append( button.getText());
        updateInfo();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.calc_result);
        updateInfo();

        View.OnClickListener onClickButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) findViewById(v.getId());
                calcActionAndResult.currentStringValue.append(button.getText());
                updateInfo();

            }
        };
        View.OnClickListener onClickActionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) findViewById(v.getId());
                calcActionAndResult.currentValue = Float.valueOf(calcActionAndResult.currentStringValue.toString());
                calcActionAndResult.currentStringValue.append(button.getText());


                CharSequence action = button.getText();
                switch (action.toString()){
                    case "+": calcActionAndResult.setAction(ActionEnum.PLUS);
                    case "-": calcActionAndResult.setAction(ActionEnum.MINUS);

                    case "*": calcActionAndResult.setAction(ActionEnum.MULTIPLY);
                    case "/": calcActionAndResult.setAction(ActionEnum.DIVIDE);
                }
                updateInfo();
                calcActionAndResult.currentStringValue = new StringBuilder();

            }
        };


        findViewById(R.id.key_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setText(String.valueOf(calcActionAndResult.action(5.0f)));
                calcActionAndResult.currentStringValue = new StringBuilder();
            }
        });

        Button btnOne = findViewById(R.id.key_one);
        Button btnTwo = findViewById(R.id.key_two);
        Button btnThree = findViewById(R.id.key_three);
        Button btnFour = findViewById(R.id.key_four);
        Button btnFive = findViewById(R.id.key_five);
        Button btnSix = findViewById(R.id.key_six);
        Button btnSeven = findViewById(R.id.key_seven);
        Button btnEight = findViewById(R.id.key_eight);
        Button btnNine = findViewById(R.id.key_nine);
        Button btnZero = findViewById(R.id.key_zero);
        Button btnDot = findViewById(R.id.key_dot);

        Button btnPlus = findViewById(R.id.key_plus);
        Button btnMinus = findViewById(R.id.key_minus);
        Button btnMultiply = findViewById(R.id.key_multiply);
        Button btnDivide = findViewById(R.id.key_divide);



        btnOne.setOnClickListener(onClickButtonListener);
        btnTwo.setOnClickListener(onClickButtonListener);
        btnThree.setOnClickListener(onClickButtonListener);
        btnFour.setOnClickListener(onClickButtonListener);
        btnFive.setOnClickListener(onClickButtonListener);
        btnSix.setOnClickListener(onClickButtonListener);
        btnSeven.setOnClickListener(onClickButtonListener);
        btnEight.setOnClickListener(onClickButtonListener);
        btnNine.setOnClickListener(onClickButtonListener);
        btnZero.setOnClickListener(onClickButtonListener);
        btnDot.setOnClickListener(onClickButtonListener);

        btnPlus.setOnClickListener(onClickActionButtonListener);
        btnMinus.setOnClickListener(onClickActionButtonListener);
        btnMultiply.setOnClickListener(onClickActionButtonListener);
        btnDivide.setOnClickListener(onClickActionButtonListener);

    }

}