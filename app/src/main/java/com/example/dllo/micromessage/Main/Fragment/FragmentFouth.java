package com.example.dllo.micromessage.Main.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.dllo.micromessage.Main.Activity.BigMessageActivity;
import com.example.dllo.micromessage.Main.Adapter.RecyclerViewAdapterOut;
import com.example.dllo.micromessage.Main.Bean.MessageBean;
import com.example.dllo.micromessage.Main.Interface.MyClick;
import com.example.dllo.micromessage.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dllo on 16/11/8.
 */

public class FragmentFouth extends Fragment {

    private Toolbar tb;
    private ArrayList<MessageBean> dataOut;
    private ArrayList<MessageBean> dataBigBig;
    private RecyclerView rv;
    private EditText dialog_number, dialog_content;
    private static ArrayList<Integer> thread_ID_data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fouth, container, false);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tb = (Toolbar) view.findViewById(R.id.tb);
        rv = (RecyclerView) view.findViewById(R.id.rlv);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tb.setTitle("短信界面");
        tb.setLogo(R.mipmap.ic_launcher);
        tb.setBackgroundColor(Color.BLUE);

        setHasOptionsMenu(true);

        dataOut = new ArrayList<>();
        thread_ID_data = new ArrayList<>();


        ((AppCompatActivity) getActivity()).setSupportActionBar(tb);


//        for (int i = 0; i < 20; i++) {
//            data.add(new MessageBean(1,"测试"+i));
//        }


        /**
         * 获取短信
         */
        Uri uri = Uri.parse("content://sms/");
        String[] projection = new String[]{"_id", "address", "person", "body", "date", "type", "thread_id"};
        Cursor cursor = getContext().getContentResolver().query(uri, projection, null, null, "date desc");

        if (cursor != null) {
            cursor.moveToFirst();
            do {


                String strAddress = cursor.getString(cursor.getColumnIndex("address"));
                String intPerson = cursor.getString(cursor.getColumnIndex("person"));
                String strbody = cursor.getString(cursor.getColumnIndex("body"));
                long longDate = cursor.getLong(cursor.getColumnIndex("date"));
                int intType = cursor.getInt(cursor.getColumnIndex("type"));
                int threadId = cursor.getInt(cursor.getColumnIndex("thread_id"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date d = new Date(longDate);
                String strDate = dateFormat.format(d);


                String strType = "";
                if (intType == 1) {
                    strType = "接收";
                } else if (intType == 2) {
                    strType = "发送";
                } else {
                    strType = "null";
                }


                //查重集合


                MessageBean m = new MessageBean();
                if ((m = check(threadId, strAddress)) != null) {

                    dataOut.add(m);
                    Log.d("FragmentFouthaaa", m.getNumber());

                }
                if (checkByID(threadId)) {

                } else {

                    thread_ID_data.add(threadId);

                }


                //dataBigBig.add(new MessageBean(strAddress, strbody, strDate, intType, threadId));
                Log.d("FragmentFouth", strAddress + "  " + intPerson + "  " + strbody + "  " + strDate + "  " + strType + "  " + threadId);


            } while (cursor.moveToNext());

            //输出查重后的ID
            for (int i = 0; i < thread_ID_data.size(); i++) {
                Log.d("FragmentFouth", "查重后的ID集合:" + thread_ID_data.get(i));
            }

            cursor.close();

        }


        RecyclerViewAdapterOut r = new RecyclerViewAdapterOut(getContext());
        r.setMyClick(new MyClick() {
            @Override
            public void MyClick(ArrayList<MessageBean> data) {

      /**
       * 获取到根据ID查询的短信包
      */

                Intent intent=new Intent(getContext(), BigMessageActivity.class);
                intent.putExtra("returnData",data);
                startActivity(intent);



            }
        });
        r.setData(dataOut, dataBigBig, thread_ID_data);

        rv.setAdapter(r);


        rv.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    private MessageBean check(int threadId, String strAddress) {
        if (!checkByID(threadId)) {
            MessageBean m = new MessageBean(strAddress);

            return m;
        } else {


            return null;
        }


    }

    private boolean checkByID(int threadId) {
        for (int i = 0; i < thread_ID_data.size(); i++) {

            if (thread_ID_data.get(i) == threadId) {


                return true;


            }

        }
        return false;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getContext(), "选择了第一项", Toast.LENGTH_SHORT).show();
                showMyDialog();
                break;
            case R.id.item2:
                Toast.makeText(getContext(), "选择了第二项", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showMyDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog, null);
        builder.setView(view);
        dialog_number = (EditText) view.findViewById(R.id.dialog_telnumber);
        dialog_content = (EditText) view.findViewById(R.id.dialog_message_content);

        builder.setPositiveButton("发送短信", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //获取短信内容和号码,向指定号码发送短信
                String num = dialog_number.getText().toString();
                String content = dialog_content.getText().toString();

                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null, content, null, null);
                Toast.makeText(getContext(), "发送成功", Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        builder.setCancelable(false);
        builder.show();

    }
}
