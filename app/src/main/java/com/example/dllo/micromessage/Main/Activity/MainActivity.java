package com.example.dllo.micromessage.Main.Activity;


import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dllo.micromessage.Main.Adapter.MyAdapter;
import com.example.dllo.micromessage.Main.Fragment.FragmentFirst;
import com.example.dllo.micromessage.Main.Fragment.FragmentThird;
import com.example.dllo.micromessage.Main.Fragment.SecondFragment;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
private ArrayList<Fragment> data;
private ViewPager vp;
    private TabLayout tab;
    private TabLayout.Tab tab_one;
    private TabLayout.Tab tab_two;
    private TabLayout.Tab tab_three;
    private TabLayout.Tab tab_four;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);


        data=new ArrayList<>();
        data.add(new FragmentFirst());
        data.add(new SecondFragment());
        data.add(new FragmentThird());
        data.add(new FragmentFirst());

        MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(myAdapter);


        //tab.setTabTextColors(Color.YELLOW, Color.GREEN);


        //选中的光标颜色
       // tab.setSelectedTabIndicatorColor(Color.YELLOW);

        tab.setupWithViewPager(vp);






        tab_one=tab.getTabAt(0);
        tab_two=tab.getTabAt(1);
        tab_three=tab.getTabAt(2);
        tab_four=tab.getTabAt(3);
        tab_one.setIcon(R.drawable.selector_first);
       tab_two.setIcon(R.drawable.selector_second);
       tab_three.setIcon(R.drawable.selector_third);
       tab_four.setIcon(R.drawable.selector_fourth);




        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

}}
