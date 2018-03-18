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
    EditText editText_sycn; //EditText - > EditText editText_sycn;
    Button button_async; // Button -> Button button_async;
    TextView textView; //TextView ->textView;
    ProgressDialog prpgresbar; //ProgressDialog -> prpgresbar;

    ListView listView; // ListView -> listView;
    ArrayAdapter adapter;// ArrayAdapter ->adapter


    String[]  data_mahasisswa={"Dian","Rina","Ginan","Osas", "Reno", "Lina"}; //digunakan untuk membuat String[]  data_mahasisswa={"Dian","Rina","Ginan","Osas", "Reno", "Lina"};
    @Override
    protected void onCreate(Bundle savedInstanceState) { //digunakan untuk protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //digunakan untuk membuat super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //digunakan untuk membuat setContentView(R.layout.activity_main);
        button_async = (Button) findViewById(R.id.btn_async); //digunakan untuk membuat
        listView =(ListView)findViewById(R.id.list_item); //digunakan untuk membuat listView =(ListView)findViewById(R.id.list_item);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<String>()); //digunakan untuk membuat  adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<String>());



        button_async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //digunakan untuk membuat button_async.setOnClickListener
                listView.setAdapter(adapter); //digunakan untuk membuat listView.setAdapter(adapter);
                new back().execute();//digunakan untuk membuat  new back().execute();


            }
        });
    }
    public void alert(){ // digunakan untuk membuat alert public void alert(){

    }

    public void Next(View view) { //digunakan untuk membuat public void Next(View view) {


    }

    class back extends AsyncTask<Void, String, String> { //digunakan untuk membuat class back extends AsyncTask<Void, String, String> {
        int count=0; //digunakan untuk membuat int count=0;
        ArrayAdapter<String> adapter; //digunakan untuk membuat ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() { //digunakan untuk membuat protected void onPreExecute() {
            adapter = (ArrayAdapter<String>)listView.getAdapter(); //digunakan untuk membuat adapter = (ArrayAdapter<String>)listView.getAdapter();
            prpgresbar = new ProgressDialog(MainActivity.this);//digunakan untuk membuat prpgresbar = new ProgressDialog(MainActivity.this);
            prpgresbar.setMessage("LOading"); //digunakn untuk membuat  prpgresbar.setMessage("LOading");
            prpgresbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //digunakn untuk membuat  prpgresbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            prpgresbar.setIndeterminate(true); //digunakan untuk membuat prpgresbar.setIndeterminate(true);
            prpgresbar.setProgress(0);//digunakan untuk membuat prpgresbar.setProgress(0);
            prpgresbar.setMax(4); //digunakan untuk membuat  prpgresbar.setMax(4);
            prpgresbar.show(); //digunakn untun membuat prpgresbar.show();
        }

        @Override
        protected String doInBackground(Void... voids) { //digunakn untuk membuat  protected String doInBackground(Void... voids) {
            for(String nama:data_mahasisswa){ //digunakn untuk membuat  for(String nama:data_mahasisswa){
                publishProgress(nama); //digunakn untuk membuat  publishProgress(nama);

                try { //digunakan untuk membuat try {
                    Thread.sleep(1000); //digunankn untuk membuat Thread.sleep(1000);
                } catch (InterruptedException e) { //digunakn untuk membuat  } catch (InterruptedException e) {
                    e.printStackTrace(); //digunakn untuk membuat e.printStackTrace();
                }
            }
            return "data sudah ditambahakan"; //digunakn untuk membuat return "data sudah ditambahakan";
        }

        @Override
        protected void onProgressUpdate(String... values) { //digunakan untuk membuat protected void onProgressUpdate(String... values) {
            adapter.add(values[0]); //digunakan untuk membuat adapter.add(values[0]);
            count++; //digunakan untuk membuat count++;
            Log.d("count ini ","dawed "+ count); //digunakn untuk membuat Log.d("count ini ","dawed "+ count);
            prpgresbar.setProgress(count); //digunakn untuk membuat prpgresbar.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) { //digunakn untuk membuat protected void onPostExecute(String result) {
            prpgresbar.dismiss(); //digunakn untuk membuat prpgresbar.dismiss();
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show(); //digunakan untuk membuat Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

        }
    }
}
