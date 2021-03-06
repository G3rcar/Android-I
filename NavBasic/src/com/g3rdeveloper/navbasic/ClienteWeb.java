package com.g3rdeveloper.navbasic;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class ClienteWeb extends WebViewClient {
	EditText editText;
	Activity activity;
	
	public ClienteWeb(EditText editText, Activity activity){
		this.editText = editText;
		this.activity = activity;
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		editText.setText(url);
		return super.shouldOverrideUrlLoading(view, url);
	}
	
	public void onProgressChanged(WebView view, int progress) {
        // Make the bar disappear after URL is loaded, and changes
        // string to Loading...
        activity.setTitle("Loading...");
        activity.setProgress(progress * 1000); // tried with 100 also
    }
}
