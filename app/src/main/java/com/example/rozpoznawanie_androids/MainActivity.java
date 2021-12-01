package com.example.rozpoznawanie_androids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textview);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        //start python

        Python py = Python.getInstance();


        PyObject pyobj = py.getModule("myscript");


        PyObject obj = pyobj.callAttr("main");

        textView.setText(obj.toString());
    }
}