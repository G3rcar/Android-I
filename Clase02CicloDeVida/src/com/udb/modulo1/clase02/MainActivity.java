package com.udb.modulo1.clase02;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	int state = 0;
	TextView tv;
	String texto = "Secuencia de vida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView)findViewById(R.id.txvCiclo);
        tv.setText(getResources().getString(R.string.mensaje1));
        
        try{
        	state = savedInstanceState.getInt("estado");
        	texto = savedInstanceState.getString("texto");
        	texto = texto + "\nEstado restablecido";
        }catch(Exception e){
        	
        }
        state++;
        texto = texto + "\n"+state+" onCreate";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
        state++;
        texto = texto + "\n"+state+" onDestroy";
        Toast.makeText(this, "Destruyendo", Toast.LENGTH_SHORT).show();
	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
        state++;
        texto = texto + "\n"+state+" onRestart";
	}


	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
        state++;
        texto = texto + "\n"+state+" onRestore";
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
        state++;
        texto = texto + "\n"+state+" onResume";
        tv.setText(texto);
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
        state++;
        texto = texto + "\n"+state+" onSaveInstance";
        outState.putInt("state", state);
        outState.putString("texto", texto);
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
        state++;
        texto = texto + "\n"+state+" onPause";
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        state++;
        texto = texto + "\n"+state+" onStart";
        Toast.makeText(this, "Iniciando", Toast.LENGTH_SHORT).show();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
        state++;
        texto = texto + "\n"+state+" onStop";
        Toast.makeText(this, "Finalizando", Toast.LENGTH_SHORT).show();
	}
    
}
