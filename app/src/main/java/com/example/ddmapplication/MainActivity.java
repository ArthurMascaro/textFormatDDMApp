package com.example.ddmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView label = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGravaTxt1 = findViewById(R.id.btnGravaTxt1);
        Button btnGravaTxt2 = findViewById(R.id.btnGravaTxt2);
        RecLabelButtonClick recLabelButtonClick = new RecLabelButtonClick();
        btnGravaTxt1.setOnClickListener(recLabelButtonClick);
        btnGravaTxt2.setOnClickListener(recLabelButtonClick);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioGroupListener radioGroupListener = new RadioGroupListener();
        radioGroup.setOnCheckedChangeListener(radioGroupListener);

        Button btnGravaTamanhoTexto = findViewById(R.id.btnGravaTam);
        btnGravaTamanhoTexto.setOnClickListener(new recButtonClick());

        Button btnRed = findViewById(R.id.btnRed);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnGreen = findViewById(R.id.btnGreen);
        ColorButtonClick colorButtonClick = new ColorButtonClick();
        btnRed.setOnClickListener(colorButtonClick);
        btnBlue.setOnClickListener(colorButtonClick);
        btnGreen.setOnClickListener(colorButtonClick);

        CheckBox chkBold = findViewById(R.id.chkBold);
        CheckBox chkItalic = findViewById(R.id.chkItalic);
        recCheckboxClick recCheckboxClick = new recCheckboxClick();
        chkBold.setOnClickListener(recCheckboxClick);
        chkItalic.setOnClickListener(recCheckboxClick);
    }

    private class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

            switch(i){
                case R.id.rad1:
                    label = R.id.lblTexto1;
                    break;
                case R.id.rad2
                    label = R.id.lblTexto2;
                    break;
                default:
                    label = null;
                    break;
            }
        }
    }

    private class recButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(label == null){
                Toast.makeText(getApplicationContext(), "Deve selecionar um label antes", Toast.LENGTH_LONG).show();
                return;
            }
            float labelLenght = Float.parseFloat(findViewById(R.id.txtTam).getText());
            label.setTextSize(labelLenght);
        }
    }

    private class ColorButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(label == null){
                Toast.makeText(getApplicationContext(), "Deve selecionar um label antes", Toast.LENGTH_LONG).show();
                return;
            }

            Button btn = (Button) view;

            switch (btn.getId()){

                case R.id.btnRed:
                    label.setTextColor(Color.RED);
                    break;
                case R.id.btnBlue:
                    label.setTextColor(Color.BLUE);
                    break;
                case R.id.btnGreen:
                    label.setTextColor(Color.GREEN);
                    break;
            }
        }
    }

    private class RecLabelButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            Button b = (Button) view;
            String labelText = "";

            switch (b.getId()){
                case R.id.btnGravaTxt1:
                    labelText = findViewById(R.id.txtTexto1).getText();
                    findViewById(R.id.lblTexto1).setText(labelText);
                    break;
                case R.id.btnGravaTxt2:
                    labelText = findViewById(R.id.txtTexto2).getText();
                    findViewById(R.id.lblTexto2).setText(labelText);
                    break;
            }
        }
    }

    private class recCheckboxClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(label == null){
                Toast.makeText(getApplicationContext(), "Deve selecionar um label antes", Toast.LENGTH_LONG).show();
                return;
            }

            CheckBox checkBox = (CheckBox) view;

            switch (checkBox.getId()){
                case R.id.chkBold:
                    if(checkBox.isChecked()){
                        label.setTypeface(null, Typeface.BOLD);
                    }else{
                        label.setTypeface(null, Typeface.NORMAL);
                    }
                    break;
                case R.id.chkItalic:
                    if(checkBox.isChecked()){
                        label.setTypeface(null, Typeface.ITALIC);
                    }else{
                        label.setTypeface(null, Typeface.NORMAL);
                    }
                    break;
            }
        }
    }
}