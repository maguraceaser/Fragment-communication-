package com.example.fragmentcommunication;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragcommunication.R;


public class Childrenfrag extends Fragment {
    private     FragmentBListerner listerner;
    private    EditText text;
    private    Button btn;
    public interface FragmentBListerner{
        void inputtextsentB(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_childrenfrag, container, false);
        text= v.findViewById(R.id.firsttext);
        btn= v.findViewById(R.id.btnone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = text.getText();
                listerner.inputtextsentB(input);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListerner){
            listerner=(FragmentBListerner) context;
        }
        else {
            throw new RuntimeException(context.toString()+"must implement the interface");
        }

    }
    public void updatedittext(CharSequence update){
        text.setText(update);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listerner=null;
    }
}
