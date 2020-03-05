package com.example.fragcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Childrentwofrag extends Fragment {
    private FragmentListerner listerner;
    private EditText text;
    private Button btn;
    public interface FragmentListerner{
        void inputtextsent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_childrentwofrag, container, false);
        text= v.findViewById(R.id.secondtext);
        btn= v.findViewById(R.id.btntwo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = text.getText();
                listerner.inputtextsent(input);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListerner){
            listerner=(FragmentListerner) context;
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

