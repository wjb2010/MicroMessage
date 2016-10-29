package com.example.dllo.micromessage.Main.Fragment;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dllo.micromessage.Main.Adapter.TalkRecordAdapter;
import com.example.dllo.micromessage.Main.Bean.TalkRecordBean;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private ArrayList<TalkRecordBean> data;
    private ListView lv;



    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.second_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data=new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            TalkRecordBean bean=new TalkRecordBean("123","456","2046");
            data.add(bean);
        }

        TalkRecordAdapter ada=new TalkRecordAdapter(getContext());
        ada.setData(data);
        lv.setAdapter(ada);



    }
}
