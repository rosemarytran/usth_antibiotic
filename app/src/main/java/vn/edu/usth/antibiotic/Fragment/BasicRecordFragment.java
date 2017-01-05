package vn.edu.usth.antibiotic.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.antibiotic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicRecordFragment extends Fragment {


    public BasicRecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_record, container, false);
    }

}
