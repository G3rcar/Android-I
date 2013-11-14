package com.udb.modulo1.clase17;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ClientWeb extends WebViewClient {
	
	TextView textView;
	
	public ClientWeb(TextView textView){
		this.textView = textView;
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		textView.setText(url);
		return super.shouldOverrideUrlLoading(view, url);
	}
	
}
