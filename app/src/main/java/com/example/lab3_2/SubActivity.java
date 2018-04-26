package com.example.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent passedintent = getIntent();

        Bundle mybundle=passedintent.getExtras();

        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        Button prevBtn = findViewById(R.id.btn2);

        String str1 = mybundle.getString("msg1");
        String str2 = mybundle.getString("msg2");
        String str3 = mybundle.getString("msg3");

        text1.setText(str1);
        text2.setText(str2);
        text3.setText(str3);

        prevBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
