package com.example.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radiobtn1;
    RadioButton radiobtn2;
    CheckBox chkbtn1;
    CheckBox chkbtn2;
    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //check button
        chkbtn1 = findViewById(R.id.sms);
        chkbtn2 = findViewById(R.id.email);
        //radio button
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radiobtn1 = (RadioButton) findViewById(R.id.man);
        radiobtn2 = (RadioButton) findViewById(R.id.woman);

        text = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg1 = "";
                String msg2 = "";
                String msg3 = "";
                msg1 += text.getText();
                //check radio button
                int radioid = radioGroup.getCheckedRadioButtonId();
                if (radiobtn1.getId() == radioid)
                    msg2 += "남";
                if (radiobtn2.getId() == radioid)
                    msg2 += "여";

                //check button
                if (chkbtn1.isChecked()) {
                    msg3 += "SMS";
                }
                if (chkbtn2.isChecked()) {
                    msg3 += "E-MAIL";
                }

                Intent intent =new Intent(getApplicationContext(),SubActivity.class);
                Bundle mybundle = new Bundle();
                mybundle.putString("msg1", msg1);
                mybundle.putString("msg2", msg2);
                mybundle.putString("msg3", msg3);
                intent.putExtras(mybundle);
                startActivity(intent);
                finish();
            }
        });
    }
}
