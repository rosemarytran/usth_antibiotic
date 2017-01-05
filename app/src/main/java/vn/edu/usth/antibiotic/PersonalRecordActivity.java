package vn.edu.usth.antibiotic;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import vn.edu.usth.antibiotic.Fragment.AdvancedRecordFragment;
import vn.edu.usth.antibiotic.Fragment.BasicRecordFragment;
import vn.edu.usth.antibiotic.Fragment.BlankFragment;

public class PersonalRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_record);
        setTitle(getString(R.string.record));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_record);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        PagerAdapter adapter = new PersonalRecordActivityFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
    }

    public class PersonalRecordActivityFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 2;
        private String titles[] = new String[]{getString(R.string.basic), getString(R.string.advanced)};

        public PersonalRecordActivityFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;// number of pages for a ViewPager
        }

        @Override
        public Fragment getItem(int page) {
            // returns an instance of Fragment corresponding to the specified page
            switch(page) {
                case 0:
                    return new BasicRecordFragment();
                case 1:
                    return new AdvancedRecordFragment();
                //            case  2:
                //                return WeatherAndForecastFragment.newInstance();
            }
            return new BlankFragment();// failsafe
        }

        @Override
        public CharSequence getPageTitle(int page) {
            // returns a tab title corresponding to the specified page
            return titles[page];
        }
    }
}
