package com.example.smart_health_care_kit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    TextView marq1;
    Button mediinfo, calldoc;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marq1 = (TextView)findViewById(R.id.marq1);
        marq1.setSelected(true);
        mediinfo=(Button)findViewById(R.id.mediinfo);
        calldoc=(Button)findViewById(R.id.calldoc);


        calldoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialToDoc();
            }
        });



        mediinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void DialToDoc() {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse("tel:8891792177"));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
//            return;
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
//                String dial = "tel:"+number;
            String dial = "tel:8891792177";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
//        startActivity(intent);
    }
}
