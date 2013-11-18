package com.udb.modulo1.clase22;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	SharedPreferences data;
	EditText edtUser, edtAge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtUser = (EditText) findViewById(R.id.edtUser);
		edtAge = (EditText) findViewById(R.id.edtAgeUser);
		
		data = getSharedPreferences("preferencias", MODE_PRIVATE);
		edtUser.setText(data.getString("username", "default"));
		edtAge.setText(""+data.getInt("age", 0));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void savePreference(View view){
		SharedPreferences.Editor preferences = data.edit();
		preferences.putString("username", edtUser.getText().toString());
		preferences.putInt("age", Integer.valueOf(edtAge.getText().toString()));
		preferences.commit();
		Toast.makeText(this, "Informacion Guardada", Toast.LENGTH_SHORT).show();
	}

}
