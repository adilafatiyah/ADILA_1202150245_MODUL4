package com.example.adilapc.adilachusnul_1202150245_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {// kelas Main2Activity
    EditText editText; //EditText ->editText
    Button button;//Button -> button
    WebView webView; // WebView -> webView
    ProgressDialog progressDialog; //ProgressDialog ->progressDialog

    @Override
    protected void onCreate(Bundle savedInstanceState) { // digunakan untuk membuat protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk membuat super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);// digunakan untuk membuat setContentView(R.layout.activity_main2);


        webView = (WebView) findViewById(R.id.web_view); //digunakan untuk webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new MyBrowser()); //digunakan untuk membuat webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true); //digunakan untuk membuat webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); // digunakan untuk membuat webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY); //digunakan untuk membuat webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        editText = (EditText)findViewById(R.id.edit_url);//digunakan untuk editText = (EditText)findViewById(R.id.edit_url);
        button = (Button)findViewById(R.id.button_cari); //digunakan untuk button = (Button)findViewById(R.id.button_cari);
        progressDialog = new ProgressDialog(this); //digunakan untuk progressDialog = new ProgressDialog(this);


        button.setOnClickListener(new View.OnClickListener() { //digunakan untuk membuat  button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // digunakan untuk public void onClick(View view) {

                webView.loadUrl(editText.getText().toString()); //digunakan untuk membuat webView.loadUrl(editText.getText().toString());


            } //}
        }); //});


    } //}
    private class MyBrowser extends WebViewClient { //digunakan untuk membuat private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { //digunakan untuk membuat public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); //view.loadUrl(url);
            return true; //return true;
        }//}

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) { //digunakan untuk membuat public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon); // digunakan untuk membuat super.onPageStarted(view, url, favicon);
            progressDialog.show(); //digunakan untuk membuat progressDialog.show();
        } // }

        @Override
        public void onPageFinished(WebView view, String url) { //digunakan untuk membuat public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss(); // digunakan untuk membuat progressDialog.dismiss();
            super.onPageFinished(view, url); //digunakan untuk membuat super.onPageFinished(view, url);
        } //}
    } //}
}
