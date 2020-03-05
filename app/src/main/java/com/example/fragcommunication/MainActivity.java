package com.example.fragcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.fragmentcommunication.Childrenfrag;


public class MainActivity extends AppCompatActivity implements Childrenfrag.FragmentBListerner, Childrentwofrag.FragmentListerner {

    Childrenfrag x ;
    Childrentwofrag y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x =new Childrenfrag();
        y = new Childrentwofrag();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.myfragone,x)
                .replace(R.id.myfragtwo,y)
                .commit();


    }

    @Override
    public void inputtextsentB(CharSequence input) {
        y.updatedittext(input);
    }

    @Override
    public void inputtextsent(CharSequence input) {
        x.updatedittext(input);
    }
}
