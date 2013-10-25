package com.udb.modulo1.clase04;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AutoCompleteTextView aedtDepartamentos = (AutoCompleteTextView)findViewById(R.id.aedtDeptos);
		String[] states = getResources().getStringArray(R.array.arrDepartamentos);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,states);
		aedtDepartamentos.setAdapter(adapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		sendMessageV();
		return super.onMenuItemSelected(featureId, item);
	}

	public boolean emailValidator(String email){
		if(Build.VERSION.SDK_INT < 8) return true;
		if(email==null) return false;
		
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}
	
	public void sendMessage(View view){
		sendMessageV();
	}
	
	public void sendMessageV(){
		EditText edtEmail = (EditText)findViewById(R.id.edtEmail);
		if(emailValidator(edtEmail.getText().toString())){
			Toast.makeText(this, "Es un email", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Error! no es un email", Toast.LENGTH_SHORT).show();
		}
	}

}
