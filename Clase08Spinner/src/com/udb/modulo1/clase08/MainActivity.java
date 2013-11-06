package com.udb.modulo1.clase08;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spnMarcas = (Spinner) findViewById(R.id.spnMarcas);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.marcas, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnMarcas.setAdapter(adapter);
		spnMarcas.setOnItemSelectedListener(this);
		
		Spinner spnCountries = (Spinner) findViewById(R.id.spnPaises);
		spnCountries.setOnItemSelectedListener(this);
		
	}
	
	public void onClickOk(View view){
		
		Spinner spnMarcas = (Spinner) findViewById(R.id.spnMarcas);
		String item = (String) spnMarcas.getSelectedItem();
		Toast.makeText(this, "Marca seleccionada es: "+item, Toast.LENGTH_SHORT).show();
	
	
		Spinner spnCountries = (Spinner) findViewById(R.id.spnPaises);
		item = (String) spnCountries.getSelectedItem();
		Toast.makeText(this, "Pais seleccionado es: "+item, Toast.LENGTH_SHORT).show();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub

		String item = (String) parent.getItemAtPosition(pos).toString();
		Toast.makeText(this, "seleccionado es: "+item, Toast.LENGTH_SHORT).show();		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
