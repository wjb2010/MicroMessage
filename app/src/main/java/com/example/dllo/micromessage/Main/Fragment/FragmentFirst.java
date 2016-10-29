package com.example.dllo.micromessage.Main.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dllo.micromessage.R;

/**
 * Created by dllo on 16/10/25.
 */

public class FragmentFirst extends Fragment implements View.OnClickListener {
    private Button btn;
    private EditText et;
    private ImageButton ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13;
    private static String number = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        btn = (Button) view.findViewById(R.id.call);
        et = (EditText) view.findViewById(R.id.et1);

        ibtn1 = (ImageButton) view.findViewById(R.id.btn1);
        ibtn2 = (ImageButton) view.findViewById(R.id.btn2);
        ibtn3 = (ImageButton) view.findViewById(R.id.btn3);
        ibtn4 = (ImageButton) view.findViewById(R.id.btn4);
        ibtn5 = (ImageButton) view.findViewById(R.id.btn5);
        ibtn6 = (ImageButton) view.findViewById(R.id.btn6);
        ibtn7 = (ImageButton) view.findViewById(R.id.btn7);
        ibtn8 = (ImageButton) view.findViewById(R.id.btn8);
        ibtn9 = (ImageButton) view.findViewById(R.id.btn9);
        ibtn10 = (ImageButton) view.findViewById(R.id.btn10);
        ibtn11 = (ImageButton) view.findViewById(R.id.btn11);
        ibtn12 = (ImageButton) view.findViewById(R.id.btn12);
        ibtn13 = (ImageButton) view.findViewById(R.id.back);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn.setOnClickListener(this);
        ibtn1.setOnClickListener(this);
        ibtn2.setOnClickListener(this);
        ibtn3.setOnClickListener(this);
        ibtn4.setOnClickListener(this);
        ibtn5.setOnClickListener(this);
        ibtn6.setOnClickListener(this);
        ibtn7.setOnClickListener(this);
        ibtn8.setOnClickListener(this);
        ibtn9.setOnClickListener(this);
        ibtn10.setOnClickListener(this);
        ibtn11.setOnClickListener(this);
        ibtn12.setOnClickListener(this);
        ibtn13.setOnClickListener(this);
        ibtn13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number = et.getText().toString();
                if (number.length()!=0) {

                    number ="";
                    et.setText(number);



                }else{

                   // Toast.makeText(getActivity(), "没有东西删除了", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call:
                String callNumber = et.getText().toString();
                if ((callNumber.trim().length()) != 0) {


                    startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + callNumber)));

                } else {

                    Toast.makeText(getActivity(), "不能输入空值", Toast.LENGTH_SHORT).show();


                }

                break;

            case R.id.btn1:
                number = et.getText().toString();
                number = number + "1";
                Log.i("FragmentFirst", number);
                et.setText(number);

                break;
            case R.id.btn2:
                number = et.getText().toString();
                number = number + "2";
                et.setText(number);

                break;
            case R.id.btn3:
                number = et.getText().toString();
                number = number + "3";
                et.setText(number);

                break;
            case R.id.btn4:
                number = et.getText().toString();
                number = number + "4";
                et.setText(number);

                break;
            case R.id.btn5:
                number = et.getText().toString();
                number = number + "5";
                et.setText(number);

                break;
            case R.id.btn6:
                number = et.getText().toString();
                number = number + "6";
                et.setText(number);

                break;
            case R.id.btn7:
                number = et.getText().toString();
                number = number + "7";
                et.setText(number);

                break;
            case R.id.btn8:
                number = et.getText().toString();
                number = number + "8";
                et.setText(number);

                break;
            case R.id.btn9:
                number = et.getText().toString();
                number = number + "9";
                et.setText(number);

                break;
            case R.id.btn10:
                number = et.getText().toString();
                number = number + "*";
                et.setText(number);

                break;
            case R.id.btn11:

                number = et.getText().toString();
                number = number + "0";
                et.setText(number);
                break;
            case R.id.btn12:

                number = et.getText().toString();
                number = number + "#";
                et.setText(number);
                break;

            case R.id.back:

                number = et.getText().toString();
                if (number.length()!=0) {

                    number = number.substring(0, number.length() - 1);
                    et.setText(number);
                    break;


                }else{

                  //  Toast.makeText(getActivity(), "没有东西删除了", Toast.LENGTH_SHORT).show();
                }


        }
    }
}
