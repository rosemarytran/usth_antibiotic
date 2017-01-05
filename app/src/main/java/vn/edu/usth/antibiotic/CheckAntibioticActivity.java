package vn.edu.usth.antibiotic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CheckAntibioticActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.antibiotic_check));
        setContentView(R.layout.activity_check_antibiotic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_check_antibiotic);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Button btn1 = (Button) findViewById(R.id.drug1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CheckAntibioticActivity.this, DrugInfomationActivity.class);
                intent.putExtra("drug","Penicillin");
                startActivity(intent);
            }
        });
        Button btn2 = (Button) findViewById(R.id.drug2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CheckAntibioticActivity.this, DrugInfomationActivity.class);
                intent.putExtra("drug","Tetracycline");
                startActivity(intent);
            }
        });
        Button btn3 = (Button) findViewById(R.id.drug3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CheckAntibioticActivity.this, DrugInfomationActivity.class);
                intent.putExtra("drug","Gentamicin");
                startActivity(intent);
            }
        });
        Button btn4 = (Button) findViewById(R.id.drug4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CheckAntibioticActivity.this, DrugInfomationActivity.class);
                intent.putExtra("drug","Ciprofloxacin");
                startActivity(intent);
            }
        });
    }


}
