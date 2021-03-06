package com.udb.modulo1.clase21;

import com.udb.modulo1.clase21.breans.StudentBean;
import com.udb.modulo1.clase21.sqlite.SQLiteHelper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public class MtoStudentActivity extends ActionBarActivity {
	
	SQLiteDatabase db =null;
	String type = "NVO";
	TextView txtCodigo;
	EditText edtName, edtAge;
	StudentBean bean;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mto_student);
		// Show the Up button in the action bar.
		setupActionBar();
		
		txtCodigo = (TextView) findViewById(R.id.textCod);
		edtName = (EditText) findViewById(R.id.editName);
		edtAge = (EditText) findViewById(R.id.editAge);
		try{
			Intent intent = getIntent();
			type = intent.getStringExtra(MainActivity.STUDENT_MTO);
			if(type==null){
				type = "NVO";
			}
			if(type.equalsIgnoreCase("MTO")){
				Bundle b = (Bundle) intent.getExtras();
				bean = (StudentBean) b.get(MainActivity.STUDENT_KEY);
				txtCodigo.setText("Codigo: "+bean.getId());
				edtName.setText(bean.getName());
				edtAge.setText(bean.getAge()+"");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
		}

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mto_student, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void saveStudent(View view){
		try{
			SQLiteHelper sqliteHelper = new SQLiteHelper(this, "university.db", null, 1);
			db = sqliteHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", edtName.getText().toString());
			values.put("age", Integer.valueOf(edtAge.getText().toString()));
			if(type.equals("NVO")){
				
				db.insert("students", null, values);
			}else{
				db.update("students", values, "code="+bean.getId(), null);
			}
			db.close();
			Intent intent2 = new Intent();
			setResult(RESULT_OK, intent2);
			finish();
		}catch(Exception e){
			Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

}
