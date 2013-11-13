package com.udb.modulo1.clase16;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = getIntent();
		String message = intent.getStringExtra("com.udb.modulo1.clase16.MESSAGE");
		String nota = intent.getStringExtra("com.udb.modulo1.clase16.NOTIFICATION");
		
		TextView textview = (TextView) findViewById(R.id.textView1);
		textview.setText(nota);
		
		textview = (TextView) findViewById(R.id.textView2);
		textview.setText(message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
