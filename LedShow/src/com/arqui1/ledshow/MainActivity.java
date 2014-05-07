package com.arqui1.ledshow;

//import com.wifigt.scaner.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_fuente:
			this.lanzarActividadFuentes();
			return true;
		case R.id.menu_fClaro_tOscuro:
			System.out.println("menu_fClaro_tOscuro");
			Intent intent = new Intent(getApplicationContext(), FondoSolidoActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_fOscuro_tClaro:
			System.out.println("menu_fOscuro_tClaro");
			return true;
		case R.id.menu_fParpadeante_tClaro:
			System.out.println("menu_fParpadeante_tClaro");
			return true;
		case R.id.menu_fParpadeante_tOscuro:
			System.out.println("menu_fParpadeante_tOscuro");
			return true;
		case R.id.menu_direccion:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	private void lanzarActividadFuentes(){
		Intent intent = new Intent(getApplicationContext(), FuentesActivity.class);
		startActivity(intent);
	}

}
