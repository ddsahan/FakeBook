package lk.ruh.facebookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    MyFragmentAdapter adapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.fragment_pager);
        tabLayout=findViewById(R.id.tab);

        tabLayout.setupWithViewPager(viewPager);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        DatabaseHandler db = new DatabaseHandler(this);
// Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Student("Ravi",29,89));
        db.addContact(new Student("Srinivas", 25,78));
        db.addContact(new Student("Tommy", 19,58));
        db.addContact(new Student("Karthik", 26,89));


    }
}
