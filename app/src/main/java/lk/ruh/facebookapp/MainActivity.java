package lk.ruh.facebookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import lk.ruh.facebookapp.database.Mydatabase;

import static lk.ruh.facebookapp.data.MyDataBase.DB_NAME;
import static lk.ruh.facebookapp.data.MyDataBase.DB_VERSION;

public class MainActivity extends AppCompatActivity {

    Mydatabase myDatabase;
    ViewPager viewPager;
    MyFragmentAdapter myFragmentAdapter;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        myDatabase = new Mydatabase(this, DB_NAME, null, DB_VERSION);;
        viewPager = findViewById(R.id.hhh);
        tabLayout=findViewById(R.id.tab);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}

