package com.example.dllo.micromessage.Main.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dllo.micromessage.Main.Bean.ContactBean;
import com.example.dllo.micromessage.Main.Bean.TalkRecordBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/31.
 */

public class JDBC {
    private SQLiteDatabase db;
    private DB_Helper db_helper;


    public JDBC(Context context) {
        db_helper=new DB_Helper(context,"Contact.db",null,1);
        db=db_helper.getWritableDatabase();
    }

    public void Insert(ContactBean contactBean) {


        ContentValues contentValues=new ContentValues();
        contentValues.put(DBValues.NAME,contactBean.getTvName());
        contentValues.put(DBValues.NUMBER,contactBean.getTvNumber());


        db.insert(DBValues.TABLE_NAME,null,contentValues);

    }

    public void Delete(ContactBean contactBean) {


        //db.delete(DBValues.TABLE_NAME,DBValues.TIME+"=?",new String[]{talkRecordBean.getTvYear()});


    }


    public ArrayList<ContactBean> Query() {

        Cursor cursor=db.query(DBValues.TABLE_NAME,null,null,null,null,null,null);
        ArrayList<ContactBean> contactBeen1=new ArrayList<>();


        if (cursor!=null){

            cursor.moveToFirst();

            do {
                String name=cursor.getString(cursor.getColumnIndex(DBValues.NAME));
                String number=cursor.getString(cursor.getColumnIndex(DBValues.NUMBER));

                ContactBean contactBean=new ContactBean();
                contactBean.setTvName(name);
                contactBean.setTvNumber(number);

                contactBeen1.add(contactBean);
            }while (cursor.moveToNext());
            //使用游标后需要关闭游标
            cursor.close();
        }



        return contactBeen1;


    }



}
