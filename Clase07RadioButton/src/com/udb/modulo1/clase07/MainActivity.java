package com.udb.modulo1.clase07;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//((RadioGroup)findViewById(R.id.rdgOpciones)).clearCheck();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClickOk(View view){
		RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rdgOpciones);
		int selectedItem = radioGroup.getCheckedRadioButtonId();
		if(selectedItem == -1){
			Toast.makeText(this, "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
		}else{
			RadioButton selected = (RadioButton)findViewById(selectedItem);
			Toast.makeText(this, selected.getText().toString(), Toast.LENGTH_LONG).show();
		}
		
	}
	
	public void onRadioButtonClicked(View view){
		boolean checked = ((RadioButton)view).isChecked();
		
		Toast.makeText(this, "La opcion "+((RadioButton)view).getText().toString()+" esta "+checked, Toast.LENGTH_LONG).show();
	}
}
