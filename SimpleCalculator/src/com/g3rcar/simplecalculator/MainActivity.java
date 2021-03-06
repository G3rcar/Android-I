package com.g3rcar.simplecalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Double resultados = 0d;
	String tmpEscrito = "0";
	String tmpChain = "";
	boolean operando = false;
	
	final int SUMA = 1;
	final int RESTA = 2;
	final int MULTIPLICACION = 3;
	final int DIVISION = 4;
	final int IGUAL = 0;
	
	int operacion = SUMA;
	
	TextView txvOperaciones;
	TextView txvResultado;
	
	NumberFormat formateador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);			
		
		((Button)findViewById(R.id.btnCero)).setOnClickListener(this);
		((Button)findViewById(R.id.btnUno)).setOnClickListener(this);
		((Button)findViewById(R.id.btnDos)).setOnClickListener(this);
		((Button)findViewById(R.id.btnTres)).setOnClickListener(this);
		((Button)findViewById(R.id.btnCuatro)).setOnClickListener(this);
		((Button)findViewById(R.id.btnCinco)).setOnClickListener(this);
		((Button)findViewById(R.id.btnSeis)).setOnClickListener(this);
		((Button)findViewById(R.id.btnSiete)).setOnClickListener(this);
		((Button)findViewById(R.id.btnOcho)).setOnClickListener(this);
		((Button)findViewById(R.id.btnNueve)).setOnClickListener(this);
		((Button)findViewById(R.id.btnPunto)).setOnClickListener(this);
		
		((Button)findViewById(R.id.btnMas)).setOnClickListener(this);
		((Button)findViewById(R.id.btnMenos)).setOnClickListener(this);
		((Button)findViewById(R.id.btnMultiplicacion)).setOnClickListener(this);
		((Button)findViewById(R.id.btnDivision)).setOnClickListener(this);
		((Button)findViewById(R.id.btnIgual)).setOnClickListener(this);
		((Button)findViewById(R.id.btnLimpiar)).setOnClickListener(this);
		
		txvOperaciones = (TextView)findViewById(R.id.txvOperaciones);
		txvResultado = (TextView)findViewById(R.id.txvResultado);
		txvResultado.setText("0.0");
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public void onClick(View view) {
		int id = view.getId();
		String tmpNum="";
		switch(id){
		case R.id.btnCero: tmpNum = "0"; break;
		case R.id.btnUno: tmpNum = "1"; break;
		case R.id.btnDos: tmpNum = "2"; break;
		case R.id.btnTres: tmpNum = "3"; break;
		case R.id.btnCuatro: tmpNum = "4"; break;
		case R.id.btnCinco: tmpNum = "5"; break;
		case R.id.btnSeis: tmpNum = "6"; break;
		case R.id.btnSiete: tmpNum = "7"; break;
		case R.id.btnOcho: tmpNum = "8"; break;
		case R.id.btnNueve: tmpNum = "9"; break;
		case R.id.btnPunto: tmpNum = "."; break;
		case R.id.btnMas: realizarOperacion(SUMA,"+"); break;
		case R.id.btnMenos: realizarOperacion(RESTA,"-"); break;
		case R.id.btnMultiplicacion: realizarOperacion(MULTIPLICACION,"x"); break;
		case R.id.btnDivision: realizarOperacion(DIVISION,"/"); break;
		case R.id.btnIgual: realizarOperacion(IGUAL,""); operando=false; break;
		case R.id.btnLimpiar: resetTodo(); break;
		}
		
		if(!tmpNum.equals("")){
			operando=false;
			if(tmpNum.equals(".")&&tmpEscrito.equals("")){
				tmpChain += "0";
				tmpEscrito = "0";
			}
			if(!(tmpNum.equals(".")&&tmpEscrito.contains(tmpNum))){
				tmpChain += tmpNum;
				tmpEscrito += tmpNum;
				
				txvOperaciones.setText(tmpChain);	
			}
		}
	}
	
	public void realizarOperacion(int op,String t){
		
		if(!tmpEscrito.equals("") && !operando){
			tmpChain+=t;
			txvOperaciones.setText(tmpChain);
			calcular(op);
			tmpEscrito = "0";

			formateador = new DecimalFormat("0.######E0");
			
			txvResultado.setText(String.valueOf(resultados));
			operando=true;
		}
	}
	
	private void calcular(int op){
		try{
			switch(operacion){
				case SUMA:
					resultados = resultados + Double.parseDouble(tmpEscrito);
					break;
				case RESTA:
					resultados = resultados - Double.parseDouble(tmpEscrito);
					break;
				case MULTIPLICACION:
					resultados = resultados * Double.parseDouble(tmpEscrito);
					break;
				case DIVISION:
					if(tmpEscrito.equals("00")||tmpEscrito.equals("")){
						throw new Exception("ERROR: Divisi�n por 0");
					}
					resultados = resultados / Double.parseDouble(tmpEscrito);
					break;
				case IGUAL:
					operando=false;
					break;
			}
			
			operacion = op;
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
			resetTodo();
		}
	}
	
	private void resetTodo(){
		resultados = 0d;
		operacion = SUMA;
		tmpEscrito = "";
		tmpChain = "";
		txvResultado.setText("0.0");
		txvOperaciones.setText(tmpChain);
		
	}

}
