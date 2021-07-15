package com.example.scientificcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBtnPush(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBtnPush(View view) {
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBtnPush(View view) {
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBtnPush(View view) {
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBtnPush(View view) {
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBtnPush(View view) {
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBtnPush(View view) {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBtnPush(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBtnPush(View view) {
        updateText(getResources().getString(R.string.nineText));
    }

    public void nineBtnPush(View view) {
        updateText(getResources().getString(R.string.nineText));
    }

    public void divideBtnPush(View view) {
        updateText(getResources().getString(R.string.divideText));
    }

    public void multiplyBtnPush(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void addBtnPush(View view) {
        updateText(getResources().getString(R.string.addText));
    }

    public void subtractBtnPush(View view) {
        updateText(getResources().getString(R.string.subtractText));
    }

    public void decimalBtnPush(View view) {
        updateText(getResources().getString(R.string.decimalText));
    }

    public void parenthesesOpenBtnPush(View view) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parenthesesCloseBtnPush(View view) {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void clearBtnPush(View view) {
        display.setText("");
        previousCalculation.setText("");
    }

    public void equalBtnPush(View view) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBtnPush(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void trigSinBtnPush(View view) {
        updateText("sin(");
    }

    public void trigCosBtnPush(View view) {
        updateText("cos(");
    }

    public void trigTanBtnPush(View view) {
        updateText("tan(");
    }

    public void trigArcSinBtnPush(View view) {
        updateText("arcsin(");
    }

    public void trigArcCosBtnPush(View view) {
        updateText("arccos(");
    }

    public void trigArcTanBtnPush(View view) {
        updateText("arctan(");
    }

    public void logBtnPush(View view) {
        updateText("log(");
    }

    public void naturalLogBtnPush(View view) {
        updateText("ln(");
    }

    public void squareRootBtnPush(View view) {
        updateText("sqrt(");
    }

    public void eBtnPush(View view) {
        updateText("e");
    }

    public void piBtnPush(View view) {
        updateText("pi");
    }

    public void absoluteValueBtnPush(View view) {
        updateText("abs(");
    }

    public void sPrimeFunctionBtnPush(View view) {
        updateText("ispr(");
    }

    public void xSquaredBtnPush(View view) {
        updateText("^ (2)");
    }

    public void xPowerYBtnPush(View view) {
        updateText("^(");
    }

}