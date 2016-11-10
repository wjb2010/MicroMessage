package com.example.dllo.micromessage.Main.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.micromessage.Main.Bean.MessageBean;
import com.example.dllo.micromessage.Main.Interface.MyClick;
import com.example.dllo.micromessage.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dllo on 16/11/8.
 */

public class RecyclerViewAdapterOut extends RecyclerView.Adapter<RecyclerViewAdapterOut.OutViewHolder> {


    private ArrayList<MessageBean> data;
    private ArrayList<MessageBean> dataBigBig;
    private ArrayList<MessageBean> return_data;

    private ArrayList<Integer> thread_ID_data;
    private Context context;
    private MyClick myClick;





    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public RecyclerViewAdapterOut(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MessageBean> data,ArrayList<MessageBean> dataBigBig,ArrayList<Integer> thread_ID_data) {
        this.data = data;
        this.dataBigBig=dataBigBig;
        this.thread_ID_data=thread_ID_data;
        notifyDataSetChanged();
    }

    @Override
    public OutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_out_show,parent,false);
        OutViewHolder viewHolder=new OutViewHolder(view);


        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    @Override
    public void onBindViewHolder(OutViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return_data=new ArrayList<>();
                int ID=thread_ID_data.get(position);

                /**
                 *准备取出dataBigBig中的所有thread_ID为ID的数据
                 */
                Uri uri = Uri.parse("content://sms/");
                String[] projection = new String[]{"_id", "address", "person", "body", "date", "type","thread_id"};
                Cursor cursor = context.getContentResolver().query(uri, projection, "thread_id=?", new String[]{ID+""}, "date desc");
                if (cursor != null) {
                    cursor.moveToFirst();
                    do {

                        String strAddress = cursor.getString(cursor.getColumnIndex("address"));
                        String intPerson = cursor.getString(cursor.getColumnIndex("person"));
                        String strbody = cursor.getString(cursor.getColumnIndex("body"));
                        long longDate = cursor.getLong(cursor.getColumnIndex("date"));
                        int intType = cursor.getInt(cursor.getColumnIndex("type"));
                        int threadId=cursor.getInt(cursor.getColumnIndex("thread_id"));

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


                        MessageBean m=new MessageBean(intType,strbody);
                        return_data.add(m);



                    } while (cursor.moveToNext());
                }
                cursor.close();


                myClick.MyClick(return_data);
            }
        });

        holder.number.setText(data.get(position).getNumber());

    }


    class OutViewHolder extends RecyclerView.ViewHolder{

    private TextView content;
    private TextView data;
    private TextView number;




    public OutViewHolder(View itemView) {
        super(itemView);
       // content = (TextView) itemView.findViewById(R.id.rec_content);
       // data = (TextView) itemView.findViewById(R.id.rec_data);
        number = (TextView) itemView.findViewById(R.id.tv_out_show);
    }
}


}
