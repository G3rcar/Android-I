package com.udb.modulo1.clase13;

import java.util.ArrayList;
import java.util.List;

import com.udb.modulo1.clase13.beans.ApplicationBean;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	
	TextView textview;
	ArrayList<ApplicationBean> applicationList = new ArrayList<ApplicationBean>();
	PackageManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview = (TextView) findViewById(R.id.textinfo);
		manager = getPackageManager();
		List<ApplicationInfo> lista = manager.getInstalledApplications(0);
		for(int i=0;i<lista.size();i++){
			ApplicationInfo info = lista.get(i);
			ApplicationBean aplicacion = new ApplicationBean();
			aplicacion.setPackageName(info.packageName);
			aplicacion.setSourceDir(info.sourceDir);
			aplicacion.setLabel((String) info.loadLabel(manager));
			aplicacion.setIcon(info.loadIcon(manager));
			applicationList.add(aplicacion);
		}
		
		textview.append(" Total: "+lista.size());
		ListView listview = (ListView) findViewById(R.id.listView1);
		ListApplicationAdapter adapter = new ListApplicationAdapter();
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
	}
	

	@Override
	public void onItemClick(AdapterView<?> av, View v, int position, long id) {
		// TODO Auto-generated method stub
		try{
			String paquete=applicationList.get(position).getPackageName();
			Intent intent = manager.getLaunchIntentForPackage(paquete);
			startActivity(intent);
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}

	public class ListApplicationAdapter extends BaseAdapter{

		LayoutInflater inflater;
		View view;
		TextView textv1,textv2,textv3;
		ImageView icon;
		
		public ListApplicationAdapter() {
			// TODO Auto-generated constructor stu
			inflater =getLayoutInflater();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return applicationList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return applicationList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int item, View oldView, ViewGroup parent) {
			// TODO Auto-generated method stub
			view = inflater.inflate(R.layout.fila, null);
			textv1 = (TextView) view.findViewById(R.id.textView1);
			textv2 = (TextView) view.findViewById(R.id.textView2);
			textv3 = (TextView) view.findViewById(R.id.textView3);
			icon = (ImageView) view.findViewById(R.id.imageView1);
			textv1.setText(item + "" + applicationList.get(item).getLabel());
			textv2.setText(applicationList.get(item).getPackageName());
			textv3.setText(applicationList.get(item).getSourceDir());
			icon.setImageDrawable(applicationList.get(item).getIcon());
			return view;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
