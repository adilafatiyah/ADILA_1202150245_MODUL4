package com.example.adilapc.adilachusnul_1202150245_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity { //kelas public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //digunakan untuk membuat protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //digunakan untuk membuat super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void data(View view) { //digunakan untuk membuat public void data(View view) {
        Intent i = new Intent(this, MainActivity.class); // digunakan untuk membuat Intent i = new Intent(this, MainActivity.class);
        Toast.makeText(Main3Activity.this, "Lihat Data", Toast.LENGTH_LONG).show(); //digunakan untuk membuat Toast.makeText(Main3Activity.this, "Lihat Data", Toast.LENGTH_LONG).show();
        startActivity(i); //digunakan untuk membuat startActivity(i);
    } //}

    public void cari(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        Toast.makeText(Main3Activity.this, "Cari Data", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
}
