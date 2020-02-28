package lk.ruh.facebookapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import lk.ruh.facebookapp.database.Mydatabase;
import static lk.ruh.facebookapp.database.Mydatabase.DB_NAME;
import static lk.ruh.facebookapp.database.Mydatabase.DB_VERSION;


public class FragmentOne extends Fragment {

    Mydatabase dataBaseManager;
    TextView name,age,mark;
    String name_string,age_string,mark_string;

    public static FragmentOne newInstace(){
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBaseManager = new Mydatabase(getContext(),DB_NAME,null,DB_VERSION);

        Button submitBtn;
        submitBtn=view.findViewById(R.id.AddBtn);

        name=view.findViewById(R.id.edtName);
        age = view.findViewById(R.id.edtAge);
        mark = view.findViewById(R.id.edtMark);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_string=name.getText().toString();
                age_string=age.getText().toString();
                mark_string=mark.getText().toString();
                boolean inserted = dataBaseManager.insertData(""+name_string,""+age_string,""+mark_string);

                if (inserted==true){
                    //Clear editTexts Fields
                    name.setText("");
                    age.setText("");
                    mark.setText("");
                    //

                    Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
