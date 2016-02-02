package com.sourceit.task1.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;
import com.sourceit.task1.utils.Toasts;

public class MainActivity extends AppCompatActivity {

    private final int N = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("create Activity...");

        new MyAsyncTask().execute(N);
    }

    class MyAsyncTask extends AsyncTask<Integer, Void, Void> {

        @Override
        protected void onPreExecute() {
            Toasts.show("starting...");
        }

        @Override
        protected Void doInBackground(Integer... params) {

            try {
                Thread.sleep(N);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toasts.show("finish");
        }
    }
}
