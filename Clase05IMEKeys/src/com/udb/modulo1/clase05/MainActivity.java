package com.udb.modulo1.clase05;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnKeyListener,OnEditorActionListener {
	
	Window window;
	LocalActivityManager manager;
	Intent intent;
	int d = 0;
	TextView txtView;
	LinearLayout mainLayout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mainLayout = (LinearLayout)findViewById(R.id.lyoMainLayout);
		txtView = (TextView)findViewById(R.id.textPush);
		
		EditText edtTxt =  (EditText)findViewById(R.id.edtSend);
		edtTxt.setOnEditorActionListener(this);
		edtTxt.setOnKeyListener(this);
		edtTxt.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.d("searchScreen","afterTextChanged "+s.toString());
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				Log.d("searchScreen","beforeTextChanged "+s);
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				Log.d("searchScreen","onTextChanged "+s);
				
			}
		
		});
		edtTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View view, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				}
				
			}
		});
		manager = getLocalActivityManager();
		
	}
	
	
	public boolean callActivity(){
		d++;
		String idString = "Codigo: "+((EditText) findViewById(R.id.edtSend)).getText().toString()+" id: "+d;
		txtView.setText("Actividad Iniciada"+d);
		intent = new Intent(MainActivity.this,SecondActivity.class);
		intent.putExtra("idString",idString);
		window = manager.startActivity(idString, intent);
		View view = window.getDecorView();
		mainLayout.addView(view);
		
		return true;
	}
	
	public void finishFromChild(Activity child){
		String idString = child.getIntent().getStringExtra("idString");
		txtView.setText("Actividad eliminada: "+idString);
		Window window2 = child.getWindow();
		View childView = window2.getDecorView();
		mainLayout.removeView(childView);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		boolean handle = false;
		if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER){
			handle = callActivity();
		}
		return handle;
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
		
		boolean handle = false;
		switch(actionId){
			case EditorInfo.IME_ACTION_SEND:
				handle = callActivity();
				break;
		}
		
		return handle;
	}

}
