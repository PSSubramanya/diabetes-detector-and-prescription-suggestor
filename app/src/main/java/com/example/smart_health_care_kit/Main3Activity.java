package com.example.smart_health_care_kit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    int preDiabeticFlag = 0;
    int diabeticType2Flag = 0;

    final String preDiabeticMedicines = "Metaglip\n" +
            "Glucovsnce\n"+
            "Actoplus Met\n"+
            "Prandimet\n"+
            "Kombiglyze\n"+
            "Janumet\n";

    final String diabeticType2Medicines = "Bydureon (exenatide)\n"+
            "Humalog\n" +
            "Jardiance\n" +
            "Lantus\n" +
            "Soliqua 100/33\n" +
            "Toujeo\n" +
            "Trulicity\n";




    TextView dispview,prescp,cktxt1,cktxt2,diab;
//    cktxt3,cktxt4,cktxt5,;
    CheckBox ck1,ck2;
//    ck3,ck4,ck5;
    EditText sug;
    Button checking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dispview = (TextView)findViewById(R.id.dispview);
//        text2 = (TextView)findViewById(R.id.text2);
        prescp = (TextView)findViewById(R.id.prescp);
        ck1 = (CheckBox)findViewById(R.id.ck1);
        ck2 = (CheckBox)findViewById(R.id.ck2);
//        ck3 = (CheckBox)findViewById(R.id.ck3);
//        ck4 = (CheckBox)findViewById(R.id.ck4);
//        ck5 = (CheckBox)findViewById(R.id.ck5);
        cktxt1 = (TextView)findViewById(R.id.cktxt1);
        cktxt2 = (TextView)findViewById(R.id.cktxt2);
//        cktxt3 = (TextView)findViewById(R.id.cktxt3);
//        cktxt4 = (TextView)findViewById(R.id.cktxt4);
//        cktxt5 = (TextView)findViewById(R.id.cktxt5);
        sug = (EditText)findViewById(R.id.sug);
        checking = (Button)findViewById(R.id.checking);
        diab = (TextView) findViewById(R.id.diab);

//        String name = getIntent().getStringExtra("result");
        dispview.setText("Enter the readings");


            checking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean check1 = ck1.isChecked();
                    boolean check2 = ck2.isChecked();
                    if (check1)
                    {
                        ck2.setVisibility(View.INVISIBLE);
                        cktxt2.setVisibility(View.INVISIBLE);

                        String sug1 = sug.getText().toString();
                        int valc = Integer.parseInt(sug1);

                        if (valc >=100 && valc<=125)
                        {
//                            prescp.setText("You are affected by Diabetes\n" +
//                                    "Kazano\nOseni\nMetaglip\nGlucovance\nJentadueto\nDuetact\nActoplus\n");

//                            prescp.setText("You are affected by Prediabetes\n\nMedicines prescribed: \n"+preDiabeticMedicines);
                            if (valc>=100 && valc<=120)
                            {
                                prescp.setText("You are affected by Prediabetes\nInsulin dose intake: 2 (IU/d)\nMedicines prescribed:\n"+preDiabeticMedicines);
                            }
                            else if (valc>120 && valc<140)
                            {
                                prescp.setText("You are affected by Prediabetes\nInsulin dose intake: 4 (IU/d)\nMedicines prescribed:\n"+preDiabeticMedicines);
                            }
                            preDiabeticFlag++;
                        }
                        else if (valc<100)
                        {
                            prescp.setText("Normal\n You are healthy");
                        }
                        else
                        {
//                            prescp.setText("Affected by Diabetes type2\n\nMedicines prescribed: \n" + diabeticType2Medicines);
                            if (valc>125 && valc<140)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 4 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            else if (valc>=140 && valc<180)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 6 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            else if (valc>=180)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 8 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            diabeticType2Flag++;

                        }


                    }
                    else if (check2)
                    {
                        ck1.setVisibility(View.INVISIBLE);
                        cktxt1.setVisibility(View.INVISIBLE);
                        String sug1 = sug.getText().toString();
                        int valc = Integer.parseInt(sug1);
                        if (valc<140)
                        {
                            prescp.setText(" Normal\n You are healthy");
                        }
                        else if(valc>=140 && valc<=199)
                        {
//                            prescp.setText("Diabetic\n" +
//                                    "Kazano\nOseni\nMetaglip\nGlucovance\nJentadueto\nDuetact\nActoplus\n");

//                            prescp.setText("You are affected by Prediabetes\n\nMedicines prescribed: \n"+preDiabeticMedicines);

                            //insulin in take value code
                            if (valc<=150)
                            {
                                prescp.setText("You are affected by Prediabetes\nInsulin dose intake: 0 (IU/d)\nMedicines prescribed: \n"+preDiabeticMedicines);
                            }
                            else if (valc>150 && valc<=200)
                            {
                                prescp.setText("You are affected by Prediabetes\nInsulin dose intake: 3 (IU/d)\nMedicines prescribed: \n"+preDiabeticMedicines);
                            }
                            preDiabeticFlag++;
                        }
                        else
                        {
//                            prescp.setText("Affected by Diabetes type2\n\nMedicines prescribed: \n" + diabeticType2Medicines);
                            if (valc>=200 && valc<=250)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 5 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            else if (valc>250 && valc<=300)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 8 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            else if (valc>300 && valc<=350)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 10 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            else if (valc>350 && valc<=400)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 12 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            if (valc>400)
                            {
                                prescp.setText("Affected by Diabetes type2\nInsulin dose intake: 15 (IU/d)\nMedicines prescribed: \n" + diabeticType2Medicines);
                            }
                            diabeticType2Flag++;
                        }
                    }
                    //prescp.setText("Hi");

                }
            });
//        }









    }
    public void order(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:8891792177"));

        if (preDiabeticFlag>0)
        {
            intent.putExtra("sms_body","We are having shortage of the prescribed medical drug\n" +
                    "So we kindly request you to deliver the medicines to our address as soon as possible.\n"+
                    "The prescribed medicines:\n"+
                    preDiabeticMedicines);
        }
        if (diabeticType2Flag>0)
        {
            intent.putExtra("sms_body","We are having shortage of the prescribed medical drug\n" +
                    "So we kindly request you to deliver the medicines to our address as soon as possible.\n"+
                    "The prescribed medicines:\n"+
                    diabeticType2Medicines);
        }
//        intent.putExtra("sms_body","We are having shortage of the prescribed medical drug\n" +
//                "So we kindly request you to deliver the medicines to our address as soon as possible.\n"+
//                "The prescribed medicines:\n");
        preDiabeticFlag = 0;
        diabeticType2Flag = 0;
        startActivity(intent);
    }
}
