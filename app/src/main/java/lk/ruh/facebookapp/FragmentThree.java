package lk.ruh.facebookapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import lk.ruh.facebookapp.database.Mydatabase;

import static lk.ruh.facebookapp.database.Mydatabase.DB_NAME;
import static lk.ruh.facebookapp.database.Mydatabase.DB_VERSION;


public class FragmentThree extends Fragment {

    Mydatabase mydatabase;
    View view;
    String str[] ;
    ListView v1;
    int countStu=0;

    public static FragmentThree newInstace(){
        FragmentThree fragmentThree = new FragmentThree();
        return fragmentThree;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three,container,false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mydatabase = new Mydatabase(getContext(), DB_NAME, null, DB_VERSION);
        v1 = view.findViewById(R.id.viewList);
        viewAll();
    }
    public void viewAll(){

        Cursor rs = mydatabase.getAll();
        ArrayList<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);
        if((rs.getCount())==0){
            showMessage("ERROR!","No Datas available");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while (rs.moveToNext()){
            //Log.d(TAG, rs.getString(1));
            buffer.append("Student "+ ++countStu +" Info : \n ");
            buffer.append("\t \t \t Name: "+rs.getString(1)+" \n ");
            buffer.append("\t \t \t Age : "+rs.getString(2)+" \n ");
            buffer.append("\t \t \t Mark: "+rs.getString(3)+" \n\n ");

        }
        str = buffer.toString().split("\n\n");
        for(int i=0;i<(str.length);i++){
            data.add(str[i]);
        }
        v1.setAdapter(adapter);
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
