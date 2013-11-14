package com.udb.modulo1.clase17;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	WebView webView;
	String home="http://www.google.com";
	

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnback = (Button) findViewById(R.id.btnback);
		btnback.setOnClickListener(this);
		Button btnhome = (Button) findViewById(R.id.btnhome);
		btnhome.setOnClickListener(this);
		Button btnforware = (Button) findViewById(R.id.btnforware);
		btnforware.setOnClickListener(this);
		
		TextView textView = (TextView) findViewById(R.id.txtUrl);
		webView = (WebView) findViewById(R.id.webView1);
		webView.setWebViewClient(new ClientWeb(textView));
		WebSettings webSettings = webView.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setJavaScriptEnabled(true);
		webView.loadUrl(home);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.btnback:
			webView.goBack();
			break;
		case R.id.btnforware:
			webView.goForward();
			break;
		case R.id.btnhome:
			webView.loadUrl(home);
			break;
		};
	}

}
