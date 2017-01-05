package vn.edu.usth.antibiotic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by duy on 1/2/17.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set color
        int red = Color.parseColor("#FF0000");
        int white = Color.parseColor("#FFFFFF");
        ((ImageView) findViewById(R.id.cross_icon)).setColorFilter(red);
        ((ImageView) findViewById(R.id.alarm_icon)).setColorFilter(red);
        ((ImageView) findViewById(R.id.user_icon)).setColorFilter(white);
        ((ImageView) findViewById(R.id.search_icon)).setColorFilter(white);

        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu("search");
            }
        });

        findViewById(R.id.cross).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu("functions");
            }
        });
    
        findViewById(R.id.user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu("user");
            }
        });
        
        findViewById(R.id.alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu("alarm");
            }
        });
    }

    private void openMenu(String name){
        Class cl = null;
        switch (name) {
            case "search":
                cl = DrugSearchActivity.class;
                break;
            case "functions":
                cl = FunctionsActivity.class;
                break;
            case "user":
                cl = PersonalRecordActivity.class;
                break;
            case "alarm":
                cl = NotificationActivity.class;
                break;
        }
        Intent myIntent = new Intent(getApplicationContext(),cl);
        startActivity(myIntent);
    }
}
