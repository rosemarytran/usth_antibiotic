package vn.edu.usth.antibiotic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by duy on 1/2/17.
 */

public class FunctionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.activity_functions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_functions);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
    
    public void parametricTest(View v){
        Intent myIntent = new Intent(getApplicationContext(), ParametricTest.class);
        startActivity(myIntent);
    }
    
    public void antibioticCheck(View v){
        Intent myIntent = new Intent(getApplicationContext(), PrescriptionActivity.class);
        startActivity(myIntent);
    }

    public void diagnostic(View v){
        Intent myIntent = new Intent(getApplicationContext(), DiagnosticActivity.class);
        startActivity(myIntent);
    }
}
