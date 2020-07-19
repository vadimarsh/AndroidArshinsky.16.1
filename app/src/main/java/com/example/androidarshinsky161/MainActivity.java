package com.example.androidarshinsky161;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button searchBt;
    private EditText geoEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geoEt = findViewById(R.id.geoEt);
        findViewById(R.id.searchBut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String geos = geoEt.getText().toString();
                StringBuilder sb = new StringBuilder("geo:");
                if(parseGeoString(geos)){
                    sb.append("?q=");
                    sb.append(geos);
                }else{
                    sb.append(geos);
                }

                Uri uri = Uri.parse(sb.toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private boolean parseGeoString(String geos) {
        boolean result = true;

            for (int i = 0; i < geos.length(); i++) {
                if (!Character.isLetter(geos.charAt(i))) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
