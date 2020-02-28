package lk.ruh.facebookapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import lk.ruh.facebookapp.database.Mydatabase;

import static lk.ruh.facebookapp.database.Mydatabase.DB_NAME;
import static lk.ruh.facebookapp.database.Mydatabase.DB_VERSION;


public class FragmentTwo extends Fragment{

    Mydatabase mydatabase;
    View view;
    String search_name ;
    ListView v1;
    EditText searchString;
    TextView display_age,display_marks;
    SQLiteDatabase sqLiteDatabase;
    Button search_Btn;


    public static FragmentTwo newInstace(){
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mydatabase = new Mydatabase(getContext(),DB_NAME,null,DB_VERSION);
        super.onViewCreated(view, savedInstanceState);

        search_Btn=view.findViewById(R.id.searchBtn);
        searchString=view.findViewById(R.id.edtsearch);
        display_age = view.findViewById(R.id.edtAge);
        display_marks= view.findViewById(R.id.edtMark);

        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchItem = searchString.getText().toString();
                sqLiteDatabase = mydatabase.getReadableDatabase();
                Cursor cursor =mydatabase.getStudentName(searchItem,sqLiteDatabase);

                if (cursor.moveToFirst()){
                    String age = cursor.getString(0);
                    String marks = cursor.getString(1);
//
                    display_age.setText(age);
                    display_marks.setText(marks);
                }
            }
        });


    }



}
