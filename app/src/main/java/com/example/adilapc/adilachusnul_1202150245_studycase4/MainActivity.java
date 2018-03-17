package com.example.adilapc.adilachusnul_1202150245_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText_sycn;
    Button button_async;
    TextView textView;
    ProgressDialog prpgresbar;

    ListView listView;
    ArrayAdapter adapter;


    String[]  data_mahasisswa={"Dian","Rina","Ginan","Osas", "Reno", "Lina"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_async = (Button) findViewById(R.id.btn_async);
        listView =(ListView)findViewById(R.id.list_item);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<String>());



        button_async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(adapter);
                new back().execute();


            }
        });
    }
    public void alert(){

    }

    public void Next(View view) {


    }

    class back extends AsyncTask<Void, String, String> {
        int count=0;
        ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>)listView.getAdapter();
            prpgresbar = new ProgressDialog(MainActivity.this);
            prpgresbar.setMessage("LOading");
            prpgresbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            prpgresbar.setIndeterminate(true);
            prpgresbar.setProgress(0);
            prpgresbar.setMax(4);
            prpgresbar.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(String nama:data_mahasisswa){
                publishProgress(nama);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "data sudah ditambahakan";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            Log.d("count ini ","dawed "+ count);
            prpgresbar.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
            prpgresbar.dismiss();
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

        }
    }
}
