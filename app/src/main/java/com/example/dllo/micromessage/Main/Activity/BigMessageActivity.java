package com.example.dllo.micromessage.Main.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.micromessage.Main.Adapter.RecyclerViewAdapter;
import com.example.dllo.micromessage.Main.Bean.MessageBean;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;

public class BigMessageActivity extends AppCompatActivity {


    private ArrayList<MessageBean> data;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_message);
        rv = (RecyclerView) findViewById(R.id.rlv_big_message);

        data=new ArrayList<>();
        Intent intent=getIntent();
        data = (ArrayList<MessageBean>) intent.getSerializableExtra("returnData");


        RecyclerViewAdapter r=new RecyclerViewAdapter(this);
        r.setData(data);
        rv.setAdapter(r);

        rv.setLayoutManager(new LinearLayoutManager(this));



    }
}
