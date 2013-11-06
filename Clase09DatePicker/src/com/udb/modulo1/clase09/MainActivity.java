package com.udb.modulo1.clase09;

import java.util.Calendar;

import com.udb.modulo1.clase09.fragments.DatePickerFragment;
import com.udb.modulo1.clase09.fragments.DatePickerFragment.DatePickedListener;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements DatePickedListener {
	TextView txtDate;
	TextView txtTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtDate = (TextView) findViewById(R.id.txtDate);
		txtTime = (TextView) findViewById(R.id.txtTime);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDatePicked(Calendar date) {
		// TODO Auto-generated method stub

		txtDate.setText(DateFormat.format("yyyy/MM/dd", date));
	}
	
	public void showDatepicker(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "Date Picker");
    }
	
}