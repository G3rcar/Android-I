package com.udb.modulo1.clase04;

import com.udb.modulo1.clase04Bean.Data;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public final static String DATOS = "com.udb.modulo1.clase04.DATOS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AutoCompleteTextView aedtDepartamentos = (AutoCompleteTextView)findViewById(R.id.aedtDeptos);
		String[] states = getResources().getStringArray(R.array.arrDepartamentos);
		
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,states);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.autocomplete_item,states);
		aedtDepartamentos.setAdapter(adapter);
		
		
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode==RESULT_OK){
			try{
				Bundle b = getIntent().getExtras();
				String nota = b.getString("nota");
				Toast.makeText(this, "Bienvenido: "+nota, Toast.LENGTH_LONG).show();
				
			}catch(Exception e){
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}else{
			Toast.makeText(this, "L�stima", Toast.LENGTH_LONG).show();
		}
		
		
		
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
		try{
			EditText edtEmail = (EditText)findViewById(R.id.edtEmail);
			if(emailValidator(edtEmail.getText().toString())){
				Toast.makeText(this, "Es un email", Toast.LENGTH_SHORT).show();
			}else{
				//Toast.makeText(this, "Error! no es un email", Toast.LENGTH_SHORT).show();
				throw new Exception("Error! no es un email");
			}
			
			
			Data data = new Data();
			
			data.setFirstName(((EditText)findViewById(R.id.edtPrimerNombre)).getText().toString());
			data.setLastName(((EditText)findViewById(R.id.edtPrimerApellido)).getText().toString());
			data.setEmail(edtEmail.getText().toString());
			
			AutoCompleteTextView actState = (AutoCompleteTextView)findViewById(R.id.aedtDeptos);
			data.setDepartamento(actState.getText().toString());
			
			EditText edtEdad = (EditText)findViewById(R.id.edtEdad);
			int edad = Integer.parseInt(edtEdad.getText().toString());
			data.setEdad(edad);
			
			Bundle b = new Bundle();
			b.putSerializable(DATOS, data);
			
			Intent intent = new Intent(this,ResultActivity.class);
			intent.putExtras(b);
			int inputCode = 17;
			startActivityForResult(intent,inputCode);
		}catch(NumberFormatException e){
			Toast.makeText(this, "La edad no es un numero", Toast.LENGTH_LONG).show();
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

}
