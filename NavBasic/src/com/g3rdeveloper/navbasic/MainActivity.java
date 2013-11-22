package com.g3rdeveloper.navbasic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends ActionBarActivity implements OnKeyListener,OnEditorActionListener  {
	
	final ActionBarActivity activity = this;
	WebView webView;
	EditText editText;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
	    getWindow().setFeatureInt(Window.FEATURE_PROGRESS,Window.PROGRESS_VISIBILITY_ON);
		setContentView(R.layout.activity_main);
		
		editText = (EditText) findViewById(R.id.edtUrl);
		webView = (WebView) findViewById(R.id.webView1);
		webView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress){
				activity.setTitle("Cargando...");
				activity.setProgress(progress * 100);
				if(progress == 100){
					activity.setTitle(R.string.app_name);
				}
		    }
		});
		
		
		webView.setWebViewClient(new ClienteWeb(editText,this));
		WebSettings webSettings = webView.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setJavaScriptEnabled(true);	
		webView.loadUrl("file:///android_asset/index.html");
		
		editText.setOnEditorActionListener(this);
		editText.setOnKeyListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_home:
			//1
			return true;
		case R.id.action_back:
			//2
			return true;
		default:
			return true;
		}
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		boolean handle = false;
		switch(actionId){
			case EditorInfo.IME_ACTION_SEND:
				handle = entrarUrl();
				break;
		}
		
		return handle;
	}

	@Override
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		boolean handle = false;
		if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER){
			handle = entrarUrl();
		}
		return handle;
	}
	
	private boolean entrarUrl(){
		String url = editText.getText().toString();
		webView.loadUrl(url);
		
		return true;
	}
	
	

}
