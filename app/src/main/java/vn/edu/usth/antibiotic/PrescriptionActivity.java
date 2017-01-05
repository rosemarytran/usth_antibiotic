package vn.edu.usth.antibiotic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrescriptionActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        setTitle(getString(R.string.antibiotic_check));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_prescription);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    
        final ArrayList<String> medicineNames = new ArrayList<>();
        final MedicineAdapter medicineListAdapter = new MedicineAdapter(medicineNames);
        
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                
        RecyclerView medicineList = (RecyclerView) findViewById(R.id.medicine_list);
        medicineList.setLayoutManager(layoutManager);
        medicineList.setAdapter(medicineListAdapter);
    
        final EditText newMedicineTextbox = (EditText) findViewById(R.id.new_medicine_textbox);
        
        Button addMedicineButton = (Button) findViewById(R.id.add_medicine_button);
        addMedicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("prescription", "New medicine: " + newMedicineTextbox.getText());
                String newMedicine = newMedicineTextbox.getText().toString();
                medicineNames.add(newMedicine);
                newMedicineTextbox.setText("");
                medicineListAdapter.notifyDataSetChanged();
            }
        });
    
        Button checkAntibioticButton = (Button) findViewById(R.id.checkAntibioticButton);
        checkAntibioticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class cl = CheckAntibioticActivity.class;
                Intent myIntent = new Intent(getApplicationContext(), cl);
                startActivity(myIntent);
                Toast toast = Toast.makeText(getApplicationContext(), R.string.alert_antibiotic, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    
    class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
        private ArrayList<String> data;
    
        class ViewHolder extends RecyclerView.ViewHolder {
            RelativeLayout medicineView;
    
            ViewHolder(RelativeLayout v) {
                super(v);
                medicineView = v;
            }
        }
    
        MedicineAdapter(ArrayList<String> data) {
            this.data = data;
        }
    
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_item, parent, false);
            return new ViewHolder(v);
        }
    
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            TextView medicineName = (TextView) holder.medicineView.findViewById(R.id.medicine_name);
            medicineName.setText(data.get(position));
            Log.i("prescription", "Medicine #" + position + ": " + data.get(position));
        }
    
        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
