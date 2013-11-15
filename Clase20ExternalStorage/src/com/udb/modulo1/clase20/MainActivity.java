package com.udb.modulo1.clase20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText edtText;
	TextView txtRead;
	String state;
	boolean mediaStorageAvailable = false;
	boolean mediaStorageWritable = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtText = (EditText) findViewById(R.id.saveInfo);
		txtRead = (TextView) findViewById(R.id.fileinfo);
		
		String state = Environment.getExternalStorageState();
		if(state.equalsIgnoreCase(Environment.MEDIA_MOUNTED)){
			mediaStorageAvailable = mediaStorageWritable = true;
		}else if(state.equalsIgnoreCase(Environment.MEDIA_MOUNTED_READ_ONLY)){
			mediaStorageAvailable = true;
			mediaStorageWritable = false;
		}else{
			mediaStorageAvailable = mediaStorageWritable = false;
		}
		
		txtRead.setText("Estado de Media: "+mediaStorageAvailable);
		txtRead.append("/Escribible: "+mediaStorageWritable+"\n");
		
		if(mediaStorageAvailable&&mediaStorageWritable){
			File root = Environment.getExternalStorageDirectory();
			File dir = new File(root.getAbsolutePath()+"/datos");
			if(dir.exists()){
				readFile();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void saveInfo(View view) {
		if(mediaStorageAvailable&&mediaStorageWritable){
			try {
				File root = Environment.getExternalStorageDirectory();
				File dir = new File(root.getAbsolutePath()+"/datos");
				if(!dir.exists()){
					dir.mkdir();
				}
				
				File file = new File(dir,"datos1.txt");
				FileOutputStream fos = new FileOutputStream(file);
				PrintWriter pw = new PrintWriter(fos);
				pw.println(txtRead.getText().toString());
				pw.print(edtText.getText().toString());
				pw.flush();
				pw.close();
				fos.close();	
			} catch (Exception e) {
				Log.d("ERROR",e.getMessage());
				Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
			}
			edtText.setText("");
			Toast.makeText(this, "Informacion Guardada", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void readInfo(View view){
		readFile();
	}
	
	public void cleanFile(View view){
		if(mediaStorageAvailable&&mediaStorageWritable){
			try{
				File root = Environment.getExternalStorageDirectory();
				File dir = new File(root.getAbsolutePath()+"/datos/datos1.txt");
				if(dir.exists()){
					dir.delete();
				}
			} catch (Exception e) {
				Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
			}
			edtText.setText("");
			txtRead.setText("");
			Toast.makeText(this, "Archivo Eliminado.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void readFile(){
		if(mediaStorageAvailable&&mediaStorageWritable){
			try {
				File root = Environment.getExternalStorageDirectory();
				File dir = new File(root.getAbsolutePath()+"/datos/datos1.txt");
				BufferedReader reader = null;
				if(dir.exists()){
					reader = new BufferedReader(new FileReader(dir));
				    StringBuilder builder = new StringBuilder();
				    String line = txtRead.getText().toString()+"\n";
				    builder.append(root.getAbsolutePath()+"/datos/datos1.txt \n"+line);
				    while ((line = reader.readLine()) != null) {
				      builder.append(line);
				    }
				    txtRead.setText(builder);
				}
			} catch (Exception e) {
				Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
			}
		}
	}

}
