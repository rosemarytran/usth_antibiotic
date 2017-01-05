package vn.edu.usth.antibiotic;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DrugInfomationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.drug_information));
        setContentView(R.layout.activity_drug_infomation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_drug_information);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        String data = getIntent().getExtras().getString("drug","defaultKey");
        Integer drug_info = get_drug_information(data);
        TextView title = (TextView)findViewById(R.id.drug_title);
        title.setText(data);
        TextView description = (TextView)findViewById(R.id.drug_description);
        description.setText(drug_info);
    }

    protected Integer get_drug_information(String drug_name){
        switch (drug_name){
            case "Penicillin":
                return R.string.penicillin;
            case "Tetracycline":
                return R.string.tetracycline;
            case "Gentamicin":
                return R.string.gentamicin;
            case "Ciprofloxacin":
                return R.string.ciprofloxacin;
        }
        return 0;
    }
}
