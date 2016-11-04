package com.example.dllo.micromessage.Main.Fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.net.Uri;
import android.os.Bundle;

import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.dllo.micromessage.Main.Adapter.TalkRecordAdapter;
import com.example.dllo.micromessage.Main.Bean.TalkRecordBean;
import com.example.dllo.micromessage.Main.Database.DB_Helper;
import com.example.dllo.micromessage.Main.Database.JDBC;
import com.example.dllo.micromessage.R;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements AdapterView.OnItemClickListener {

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




        getTalkRecord();

        lv.setOnItemClickListener(this);

//        for (int i = 0; i < 50; i++) {
//            TalkRecordBean bean=new TalkRecordBean("123","456","2046");
//            data.add(bean);
//        }


        //暂时屏蔽
//        TalkRecordAdapter ada=new TalkRecordAdapter(getContext());
//        ada.setData(data);
//        lv.setAdapter(ada);


    }

    public void getTalkRecord() {
        data = new ArrayList<>();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Cursor cursor = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        if (cursor != null) {

            cursor.moveToFirst();
            do {

                String number =cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                String name =cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
                if (name==null){
                    name="未知";
                }
                String time=cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
               // SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");


                SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = new Date(Long.parseLong(time));
                String ctime = sfd.format(date);




                TalkRecordBean a=new TalkRecordBean(name,number,ctime);

                data.add(a);
            } while (cursor.moveToNext());


        }
        cursor.close();

        TalkRecordAdapter t=new TalkRecordAdapter(getContext());
        t.setData(data);
        lv.setAdapter(t);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       String a= data.get(position).getTvNum();
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + a)));

        //getTalkRecord();
    }


    //刷新数据
//    private void Refresh() {
//        data=jdbc.Query(db);
//        TalkRecordAdapter ada=new TalkRecordAdapter(getContext());
//        ada.setData(data);
//        lv.setAdapter(ada);
//    }


}
