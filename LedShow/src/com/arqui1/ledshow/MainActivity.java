package com.arqui1.ledshow;

//import com.wifigt.scaner.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {
	private String arrayDirecciones[] = { "Derecha a Izquierda","Izquierda a Derecha","Arriba hacia Abajo","Abajo hacia Arriba"};
	private int posicionDireccion=0;
	
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
		Intent intent;
		
		switch (item.getItemId()) {
		case R.id.menu_fuente:
			intent = new Intent(getApplicationContext(), FuentesActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_fClaro_tOscuro:
			System.out.println("menu_fClaro_tOscuro");
			intent = new Intent(getApplicationContext(), FondoSolidoActivity.class);
			intent.putExtra(FondoSolidoActivity.MODO, 0);
			startActivity(intent);
			return true;
		case R.id.menu_fOscuro_tClaro:
			System.out.println("menu_fOscuro_tClaro");
			intent = new Intent(getApplicationContext(), FondoSolidoActivity.class);
			intent.putExtra(FondoSolidoActivity.MODO, 1);
			startActivity(intent);
			return true;
		case R.id.menu_fParpadeante_tClaro:
			System.out.println("menu_fParpadeante_tClaro");
			intent = new Intent(getApplicationContext(), FondoParpadeanteActivity.class);
			intent.putExtra(FondoParpadeanteActivity.MODO, 0);
			startActivity(intent);
			return true;
		case R.id.menu_fParpadeante_tOscuro:
			System.out.println("menu_fParpadeante_tOscuro");
			intent = new Intent(getApplicationContext(), FondoParpadeanteActivity.class);
			intent.putExtra(FondoParpadeanteActivity.MODO, 1);
			startActivity(intent);
			return true;
		case R.id.menu_direccion:
			this.alertDialogListDireccion();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	public void alertDialogListDireccion() {
		AlertDialog.Builder myDialog = new AlertDialog.Builder(
				MainActivity.this);

		final ListView listview = new ListView(MainActivity.this);
		LinearLayout layout = new LinearLayout(MainActivity.this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(listview);
		myDialog.setTitle("Direaccion");
		myDialog.setView(layout);
		myDialog.setSingleChoiceItems(arrayDirecciones, posicionDireccion,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});

		myDialog.setNegativeButton("Cancelar",
		// agregando accion al boton cancelar
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					}
				}); // fin de alert.setNegativeButton

		myDialog.setPositiveButton("Aceptar",
		// agregando accion al boton cancelar
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

						int checkedItem = ((AlertDialog) dialog).getListView()
								.getCheckedItemPosition();
						posicionDireccion = checkedItem;
					}
				}); // fin de alert.setPositiveButton

		myDialog.show();
	}
}
