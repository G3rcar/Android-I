package com.udb.modulo1.clase05;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class SecondActivity extends Activity implements OnClickListener {
	
	TextView txtView;
	int n=0;
	String id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		// Show the Up button in the action bar.
		
		
		txtView = (TextView)findViewById(R.id.textPush);
		
		Button btnPush = (Button)findViewById(R.id.btnPush);
		btnPush.setOnClickListener(this);

		Button btnDelete = (Button)findViewById(R.id.btnDelete);
		btnDelete.setOnClickListener(this);
		
		
		Intent intent = getIntent();
		id = intent.getStringExtra("idString");
		txtView.setText(id);
		
		//setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
			case R.id.btnPush:
				n++;
				txtView.setText("pulsando "+n+" veces");
			break;
			
			case R.id.btnDelete:
				this.finish();
			break;
		}
	}

}
