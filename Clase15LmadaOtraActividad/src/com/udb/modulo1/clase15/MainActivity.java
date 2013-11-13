package com.udb.modulo1.clase15;

import org.apache.http.protocol.HTTP;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void makeCall(View view){
		Uri number = Uri.parse("tel:"+((EditText) findViewById(R.id.edtPhone)).getText().toString());
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		startActivity(callIntent);
	}
	
	public void makeLocate(View view){
		Uri location = Uri.parse("geo:"+
					((EditText) findViewById(R.id.edtGeo1)).getText().toString()
					+","+
					((EditText) findViewById(R.id.edtGeo2)).getText().toString());
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
		startActivity(mapIntent);
	}
	
	public void sendEmail(View view){
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		// The intent does not have a URI, so declare the "text/plain" MIME type
		emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {((EditText) findViewById(R.id.edtEmail)).getText().toString()}); // recipients
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, ((EditText) findViewById(R.id.edtSubject)).getText().toString());
		emailIntent.putExtra(Intent.EXTRA_TEXT,((EditText) findViewById(R.id.edtContent)).getText().toString());
		startActivity(emailIntent);
	}

}
