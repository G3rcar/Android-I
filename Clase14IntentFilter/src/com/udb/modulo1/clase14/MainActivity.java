package com.udb.modulo1.clase14;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.editText1);
	}
	
	public void onCallPage(View view){
		String uriString = editText.getText().toString();
		Uri uri = Uri.parse(uriString);
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);	
		intent.putExtra("com.udb.modulo1.clase1401.USER",((EditText) findViewById(R.id.edtUser)).getText().toString());
		startActivity(intent);
	}
	public void onClear(View view){
		editText.setText("http://");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
