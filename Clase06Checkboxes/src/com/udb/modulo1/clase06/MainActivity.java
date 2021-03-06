package com.udb.modulo1.clase06;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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
	
	public void onCheckboxClicked(View view){
		boolean checked = ((CheckBox)view).isChecked();
		
		switch(view.getId()){
			case R.id.chbCarne:
				if(checked){
					Toast.makeText(this, "Carne seleccionada", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(this, "Carne deseleccionada", Toast.LENGTH_SHORT).show();
				}
			break;
			case R.id.chbChicken:
				if(checked){
					Toast.makeText(this, "Pollo seleccionada", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(this, "Pollo deseleccionada", Toast.LENGTH_SHORT).show();
				}
			break;
		}
	}
	
	
	public String evaluar(CheckBox chkValue){
		String like = "";
		if(chkValue.isChecked()){
			like = " "+chkValue.getText().toString();
		}
		return like;
	}
	
	public void onClickOk(View view){
		String likes = "";
		CheckBox chkValue = (CheckBox)findViewById(R.id.chbCarne);
		likes = likes + evaluar(chkValue);

		chkValue = (CheckBox)findViewById(R.id.chbChicken);
		likes = likes + evaluar(chkValue);
		
		Toast.makeText(this, "Seleccionaste "+likes, Toast.LENGTH_LONG).show();
	}

}
