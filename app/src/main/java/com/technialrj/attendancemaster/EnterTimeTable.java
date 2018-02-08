package com.technialrj.attendancemaster;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class EnterTimeTable extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_enter_time_table);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                setTitle("Timetable");

                ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
                setupViewPager(viewPager);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);





        }


        private void setupViewPager(ViewPager viewPager) {
                ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
                adapter.addFragment(new TTMondayFragment(), "Monday");
                adapter.addFragment(new TTMondayFragment(), "Tuesday");
                adapter.addFragment(new TTMondayFragment(), "Wednesday");
                adapter.addFragment(new TTMondayFragment(), "Thursday");
                adapter.addFragment(new TTMondayFragment(), "Friday");
                adapter.addFragment(new TTMondayFragment(), "Saturday");
                adapter.addFragment(new TTMondayFragment(), "Sunday");

                viewPager.setAdapter(adapter);
        }

        class ViewPagerAdapter extends FragmentPagerAdapter {
                private final List<Fragment> mFragmentList = new ArrayList<>();
                private final List<String> mFragmentTitleList = new ArrayList<>();

                public ViewPagerAdapter(FragmentManager manager) {
                        super(manager);
                }

                @Override
                public Fragment getItem(int position) {
                        return mFragmentList.get(position);
                }

                @Override
                public int getCount() {
                        return mFragmentList.size();
                }

                public void addFragment(Fragment fragment, String title) {
                        mFragmentList.add(fragment);
                        mFragmentTitleList.add(title);
                }

                @Override
                public CharSequence getPageTitle(int position) {
                        return mFragmentTitleList.get(position);
                }
        }

        @Override
        public void onBackPressed() {
                super.onBackPressed();

                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();

        }
}
