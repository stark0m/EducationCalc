package com.example.educationcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private TextView intermediateValue;
    private TextView intermediateAction;
    private final String CALC_CLEAR_VALUE = "C";
    private final String CALC_RETURN_VALUE = "=";
    private CalcActionAndResult calcActionAndResult = new CalcActionAndResult();

    private void updateInfo() {


        Log.d("Result", calcActionAndResult.toString());
        TextView intermediateAction = findViewById(R.id.intermediate_action_value);

        if (calcActionAndResult.getIntermediateAction()==""){
            intermediateValue.setText("");
            intermediateAction.setText("");

        }else {
            intermediateValue.setText(String.valueOf(calcActionAndResult.getIntermediateValue()));
            intermediateAction.setText(calcActionAndResult.getIntermediateAction());
        }
        textViewResult.setText(calcActionAndResult.currentStringValue.toString());


    }

    private void setCurrentStringAction(Button button, CalcActionAndResult car) {

        car.currentStringValue.append(button.getText());
        updateInfo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.calc_result);
        intermediateValue = findViewById(R.id.intermediate_value_number);
        intermediateAction = findViewById(R.id.intermediate_action_value);
        updateInfo();

        View.OnClickListener onClickButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) findViewById(v.getId());
                if (calcActionAndResult.currentStringValue.toString().equals("0") || calcActionAndResult.isLastActionCalculation()) {
                    calcActionAndResult.currentStringValue = new StringBuilder(button.getText());
                } else {


                    calcActionAndResult.currentStringValue.append(button.getText());
                }
                calcActionAndResult.setLastActionCalculation(false);
                updateInfo();

            }
        };
        View.OnClickListener onClickActionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button currentClickedButton = (Button) findViewById(v.getId());
                String currentButtonAction = currentClickedButton.getText().toString();
                //  float currentCalcFloatValue = Float.valueOf(intermediateValue.getText().toString());
                Float currentCalcFloatValue = Float.valueOf(textViewResult.getText().toString());
                Float intermediateFloatValue = calcActionAndResult.getIntermediateValue();
                String intermediateStringAction = calcActionAndResult.getIntermediateAction();

                if (currentButtonAction.equals(CALC_CLEAR_VALUE)) {  // pressed Clear button
                    calcActionAndResult = new CalcActionAndResult();
                    updateInfo();
                    return;
                }

                if (intermediateFloatValue == null) { // number entered first time
                    if (currentClickedButton.getText().equals(CALC_RETURN_VALUE)) { //pressed = button
                        return;
                    }
                    calcActionAndResult.setIntermediateValue(currentCalcFloatValue);
                    calcActionAndResult.setAction(currentButtonAction);
                    calcActionAndResult.currentStringValue = new StringBuilder("0");
                } else {
//                   currentCalcFloatValue = calcActionAndResult.action(currentCalcFloatValue);
                    float calcResult = calcActionAndResult.action(currentCalcFloatValue);
                    calcActionAndResult.currentStringValue = new StringBuilder(String.valueOf(calcResult));
                    calcActionAndResult.setLastActionCalculation(true);

                    if (currentClickedButton.getText().equals(CALC_RETURN_VALUE)) {  // pressed Return button


//                        calcActionAndResult = new CalcActionAndResult();
//                        calcActionAndResult.currentStringValue = new StringBuilder(String.valueOf(currentCalcFloatValue));
                        calcActionAndResult.setAction("");
                        calcActionAndResult.setIntermediateValue(null);
                        updateInfo();
                        return;
                    }
                    calcActionAndResult.setAction(currentButtonAction.toString());
                    calcActionAndResult.setIntermediateValue(currentCalcFloatValue);

//                }


                }
                updateInfo();
            }

        };
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
        Button btnClear = findViewById(R.id.key_clear);

        Button btnPlus = findViewById(R.id.key_plus);
        Button btnMinus = findViewById(R.id.key_minus);
        Button btnMultiply = findViewById(R.id.key_multiply);
        Button btnDivide = findViewById(R.id.key_divide);
        Button btnReturn = findViewById(R.id.key_return);


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
        btnClear.setOnClickListener(onClickActionButtonListener);
        btnReturn.setOnClickListener(onClickActionButtonListener);

    }

}