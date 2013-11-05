package com.g3rcar.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	Double resultados = 0d;
	String tmpEscrito = "";
	String tmpChain = "";
	final int SUMA = 1;
	final int RESTA = 2;
	final int IGUAL = 0;
	
	int operacion = SUMA;
	
	TextView txvOperaciones;
	TextView txvResultado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		txvOperaciones = (TextView)findViewById(R.id.txvOperaciones);
		txvResultado = (TextView)findViewById(R.id.txvResultado);
		
		txvOperaciones.setText("");
		txvResultado.setText("");
		
		/*
		Button btnUno = (Button)findViewById(R.id.btnUno);
		btnUno.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"1");
				tmpEscrito += "1";
			}
			
		});
		
		Button btnDos = (Button)findViewById(R.id.btnDos);
		btnDos.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"2");
				tmpEscrito += "2";
			}
			
		});
		
		Button btnTres = (Button)findViewById(R.id.btnTres);
		btnTres.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"3");
				tmpEscrito += "3";
			}
			
		});
		
		Button btnCuatro = (Button)findViewById(R.id.btnCuatro);
		btnCuatro.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"4");
				tmpEscrito += "4";
			}
			
		});
		
		Button btnCinco = (Button)findViewById(R.id.btnCinco);
		btnCinco.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"5");
				tmpEscrito += "5";
			}
			
		});
		
		Button btnSeis = (Button)findViewById(R.id.btnSeis);
		btnSeis.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"6");
				tmpEscrito += "6";
			}
			
		});
		
		Button btnSiete = (Button)findViewById(R.id.btnSiete);
		btnSiete.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"7");
				tmpEscrito += "7";
			}
			
		});
		
		Button btnOcho = (Button)findViewById(R.id.btnOcho);
		btnOcho.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"8");
				tmpEscrito += "8";
			}
			
		});
		
		Button btnNueve = (Button)findViewById(R.id.btnNueve);
		btnNueve.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"9");
				tmpEscrito += "9";
			}
			
		});
		
		Button btnCero = (Button)findViewById(R.id.btnCero);
		btnCero.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"0");
				tmpEscrito += "0";
			}
			
		});
		
		Button btnMas = (Button)findViewById(R.id.btnMas);
		btnMas.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"+");
				calcular(SUMA);
				tmpEscrito = "";
				txvResultado.setText(String.valueOf(resultados));
				
			}
			
		});
		
		Button btnMenos = (Button)findViewById(R.id.btnMenos);
		btnMenos.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"-");
				calcular(RESTA);
				tmpEscrito = "";
				txvResultado.setText(String.valueOf(resultados));
				
			}
			
		});
		
		Button btnIgual = (Button)findViewById(R.id.btnIgual);
		btnIgual.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText("");
				calcular(SUMA);
				txvResultado.setText(String.valueOf(resultados));

				resultados = 0d;
				tmpEscrito = "";
			}
			
		});
		*/
		
	}
	
	public void calcular(int op){
		switch(operacion){
			case SUMA:
				resultados = resultados + Double.parseDouble(tmpEscrito);
				break;
			case RESTA:
				resultados = resultados - Double.parseDouble(tmpEscrito);
				break;
		}
		
		operacion = op;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		tmpChain = txvOperaciones.getText().toString();
		String tmpNum = "";
		switch(view.getId()){
			case R.id.btnCero: tmpNum="0"; break;
			case R.id.btnUno: tmpNum="1"; break;
			case R.id.btnDos: tmpNum="2"; break;
			case R.id.btnTres: tmpNum="3"; break;
			case R.id.btnCuatro: tmpNum="4"; break;
			case R.id.btnCinco: tmpNum="5"; break;
			case R.id.btnSeis: tmpNum="6"; break;
			case R.id.btnSiete: tmpNum="7"; break;
			case R.id.btnOcho: tmpNum="8"; break;
			case R.id.btnNueve: tmpNum="9"; break;
			//case R.id.btnPunto: tmpNum="."; break;
			case R.id.btnMas:
				tmpChain = txvOperaciones.getText().toString();
				txvOperaciones.setText(tmpChain+"+");
				calcular(SUMA);
				tmpEscrito = "";
				txvResultado.setText(String.valueOf(resultados));
			break;
		}
		if(!tmpNum.equals("")){
			txvOperaciones.setText(tmpChain+tmpNum);
			tmpEscrito += tmpNum;
		}
		
	}
	
	

}