package com.example.dllo.micromessage.Main.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.micromessage.Main.Bean.TalkRecordBean;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/26.
 */

public class TalkRecordAdapter extends BaseAdapter{
    private ArrayList<TalkRecordBean> data;
    private Context context;

    public TalkRecordAdapter(Context context) {
        this.context = context;
    }


    public void setData(ArrayList<TalkRecordBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return data!=null&&data.size()!=0?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data!=null?data.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.fragment_talk_record,null);
            viewHolder=new ViewHolder(convertView);
             convertView.setTag(viewHolder);




        }else {

            viewHolder= (ViewHolder) convertView.getTag();

        }
        viewHolder.tvName.setText(data.get(position).getTvName());
        viewHolder.tvNum.setText(data.get(position).getTvNum());
        viewHolder.tvYear.setText(data.get(position).getTvYear());



        return convertView;
    }

    class ViewHolder {
        private TextView tvName,tvNum,tvYear;

        public ViewHolder(View view) {
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvNum = (TextView) view.findViewById(R.id.tvNum);
            tvYear = (TextView) view.findViewById(R.id.tvYear);


        }
    }


}
