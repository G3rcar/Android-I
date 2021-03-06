package com.udb.modulo1.clase10;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	String[] foods;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		ListView listFoods = (ListView) findViewById(R.id.lstFood);
		foods = getResources().getStringArray(R.array.food);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fooditem, foods);
		listFoods.setAdapter(adapter);
		listFoods.setOnCreateContextMenuListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_new:
			Toast.makeText(this, "Selecciono Nuevo", Toast.LENGTH_LONG).show();
			return true;
		case R.id.action_settings:
			Toast.makeText(this, "Selecciono Configuracion", Toast.LENGTH_LONG).show();
			return true;
		case R.id.menuCut:
			Toast.makeText(this, "Selecciono Cortar", Toast.LENGTH_LONG).show();
			return true;
		case R.id.menuCopy:
			Toast.makeText(this, "Selecciono Copiar", Toast.LENGTH_LONG).show();
			return true;
		default:
			return true;
		}
	}
	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    switch (item.getItemId()) {
	        case R.id.iteminfo:
	            Toast.makeText(this, "Informacion: "+foods[(int) info.id], Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.itemselecc:
	        	Toast.makeText(this, "Selecciono: "+foods[(int) info.id], Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	            return super.onContextItemSelected(item);
	    }
	}	
	
	

}
