package com.example.calculater;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS,MINUS,MULTIPLY,DIVIDE,EQUAL
    }

     ImageButton imgOne,imgTwo,imgThree,imgFour,imgFive,imgSix,imgSeven,imgEight,
            imgNine,imgZero,imgDivide,imgMultiple,imgMinus,imgPlus,btnEquel;
     Button btnC;

    TextView txtCalculation,txtResults;

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculatiosResult;

    private String calucationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculatiosResult = 0;
        calucationsString = "";


        imgOne = findViewById(R.id.imgOne);
        imgTwo = findViewById(R.id.imgTwo);
        imgThree = findViewById(R.id.imgThree);
        imgFour = findViewById(R.id.imgFour);
        imgFive = findViewById(R.id.imgFive);
        imgSix = findViewById(R.id.imgSix);
        imgSeven= findViewById(R.id.imgSeven);
        imgEight = findViewById(R.id.imgEight);
        imgNine = findViewById(R.id.imgNine);
        imgZero = findViewById(R.id.imgZero);
        imgDivide = findViewById(R.id.imgDivide);
        imgMultiple = findViewById(R.id.imgMultiple);
        imgPlus = findViewById(R.id.imgPlus);
        imgMinus = findViewById(R.id.imgMinus);
        btnEquel = findViewById(R.id.btnEqual);

        btnC = findViewById(R.id.btnC);

        txtCalculation = findViewById(R.id.txtCalculation);
        txtResults = findViewById(R.id.txtResults);

        imgOne.setOnClickListener(this);
        imgTwo.setOnClickListener(this);
        imgThree.setOnClickListener(this);
        imgFour.setOnClickListener(this);
        imgFive.setOnClickListener(this);
        imgSix.setOnClickListener(this);
        imgSeven.setOnClickListener(this);
        imgEight.setOnClickListener(this);
        imgNine.setOnClickListener(this);
        imgZero.setOnClickListener(this);
        imgPlus.setOnClickListener(this);
        imgMinus.setOnClickListener(this);
        btnC.setOnClickListener(this);
        imgDivide.setOnClickListener(this);
        imgMultiple.setOnClickListener(this);
        btnEquel.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEqual:
                operatiorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btnC:
                clearTapped();

                break;
            case R.id.imgPlus:
                operatiorIsTapped(OPERATOR.PLUS);
                calucationsString += " + ";
                break;
            case R.id.imgMinus:
                operatiorIsTapped(OPERATOR.MINUS);
                calucationsString += " - ";
                break;
            case R.id.imgMultiple:
                operatiorIsTapped(OPERATOR.MULTIPLY);
                calucationsString += " * ";
                break;
            case R.id.imgDivide:
                operatiorIsTapped(OPERATOR.DIVIDE);
                calucationsString += " / ";
                break;
            case R.id.imgOne:
                numberIsTapped(1);
                break;
            case R.id.imgTwo:
                numberIsTapped(2);
                break;
            case R.id.imgThree:
                numberIsTapped(3);
                break;
            case R.id.imgFour:
                numberIsTapped(4);
                break;
            case R.id.imgFive:
                numberIsTapped(5);
                break;
            case R.id.imgSix:
                numberIsTapped(6);
                break;
            case R.id.imgSeven:
                numberIsTapped(7);
                break;
            case R.id.imgEight:
                numberIsTapped(8);
                break;
            case R.id.imgNine:
                numberIsTapped(9);
                break;
            case R.id.imgZero:
                numberIsTapped(0);
                break;

        }
        txtCalculation.setText(calucationsString);



    }
    private void numberIsTapped (int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calucationsString = currentNumber;
        txtCalculation.setText(calucationsString);
    }

    private void operatiorIsTapped (OPERATOR tappedOperator) {
        if (currentOperator != null) {

          if(currentNumber != "") {

              stringNumberAtRight = currentNumber;
              currentNumber = "";

              switch (currentOperator) {
                  case PLUS:
                      calculatiosResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                      break;
                  case MINUS:
                      calculatiosResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                      break;
                  case DIVIDE:
                      calculatiosResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                      break;
                  case MULTIPLY:
                      calculatiosResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                      break;
                  case EQUAL:
                      break;
              }
              stringNumberAtLeft = String.valueOf(calculatiosResult);
              txtResults.setText(stringNumberAtLeft);
              calucationsString = stringNumberAtLeft;
          }

        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;

    }

    private void clearTapped(){

        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculatiosResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResults.setText("0");
        calucationsString = "0";
        txtCalculation.setText("");
    }

}
