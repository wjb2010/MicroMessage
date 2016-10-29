package com.example.dllo.micromessage.Main.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.micromessage.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private Bitmap bitmap;
    private TextView tv, count;
    private CountTime countTime;
    public int a = 6;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countTime.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        new BitMaPASync().execute("http://h.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=b8dc0d32231f95caa6a09ab2fc275308/b3b7d0a20cf431ade4394b754d36acaf2fdd9896.jpg");
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.begin);
        count = (TextView) findViewById(R.id.count);
        tv.setOnClickListener(this);

        countTime = new CountTime(6833, 1000);
        countTime.start();



    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();

    }


    class BitMaPASync extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();

                bitmap = BitmapFactory.decodeStream(is);


                is.close();
                connection.disconnect();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return bitmap;


        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            iv.setImageBitmap(bitmap);
        }
    }

    class CountTime extends CountDownTimer {


        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CountTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {


            --a;
            count.setText((a) + "");
            if (a==0){
                count.setText(1+ "");
                onFinish();

            }


            Log.i("CountTime", millisUntilFinished + "");

        }

        @Override
        public void onFinish() {

            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
