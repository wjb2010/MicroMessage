package com.example.dllo.micromessage.Main.Fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dllo.micromessage.Main.Adapter.ContactAdapter;
import com.example.dllo.micromessage.Main.Bean.ContactBean;
import com.example.dllo.micromessage.Main.Database.JDBC;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;


/**
 * Created by dllo on 16/11/1.
 */

public class FragmentThird extends Fragment {

    private ListView lv;
    private JDBC jdbc;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        jdbc = new JDBC(getContext());


        //ArrayList<ContactBean> data=new ArrayList<>();
        //ArrayList<String> data;
        //query方法中的五个参数
        //第一个参数URI,相当于路径
        //第二个参数,我们返回的结果,赋值为null代表把所有结果都取出来,
        //第三个参数和第四个参数是判断条件
        //我们可以根据判断的条件取出我们想要的一些信息
        //同样,赋值为null代表不做条件判断
        //第五个参数排序方式 升序或降序
        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursor != null) {

            cursor.moveToFirst();
            do {
                //获取联系人
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (number==null){

                    number="null";
                }
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                Log.d("FragmentThird", id);
                // Log.i("MainActivity", name+number);
                ContactBean contactBean = new ContactBean();
                contactBean.setTvName(name);
                contactBean.setTvNumber(number);
                // data.add(contactBean);
                jdbc.Insert(contactBean);

            } while (cursor.moveToNext());
            cursor.close();


        }



        ContactAdapter contactAdapter=new ContactAdapter(getContext());
        contactAdapter.setData(jdbc.Query());
        lv.setAdapter(contactAdapter);


    }
}
