package com.example.dllo.micromessage.Main.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.micromessage.Main.Bean.MessageBean;
import com.example.dllo.micromessage.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/8.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter{


    private ArrayList<MessageBean> data;
    private Context context;
    public static final int SEND=1;
    public static final int REC=2;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MessageBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder=null;
        switch (viewType){
            case SEND:
                View viewSend= LayoutInflater.from(context).inflate(R.layout.item_send_message,parent,false);
                viewHolder=new SendViewHolder(viewSend);
                break;
            case REC:
                View viewRec= LayoutInflater.from(context).inflate(R.layout.item_receive_message,parent,false);
                viewHolder=new RecViewHolder(viewRec);
                break;


        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       int flag= getItemViewType(position);
        switch (flag){
            case SEND:
                SendViewHolder sendViewHolder= (SendViewHolder) holder;
                sendViewHolder.content.setText(data.get(position).getName());
                break;
            case REC:
                RecViewHolder recViewHolder= (RecViewHolder) holder;
                recViewHolder.content.setText(data.get(position).getName());
                break;


        }


    }

    @Override
    public int getItemCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    class RecViewHolder extends RecyclerView.ViewHolder{

        private TextView content;
        private TextView data;



        public RecViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.rec_content);
            data = (TextView) itemView.findViewById(R.id.rec_data);
        }
    }

    class SendViewHolder extends RecyclerView.ViewHolder{

        private TextView content;
        private TextView data;



        public SendViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.send_content);
            data = (TextView) itemView.findViewById(R.id.send_data);
        }
    }



}
