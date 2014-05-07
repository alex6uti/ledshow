package com.arqui1.ledshow;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class FuentesActivity extends Activity implements OnClickListener {
	private String arrayFuentes[] = { "Fuente1", "Fuente2", "Fuente3" };
	private Button btn_estilo_fuentes;
	private int posicionFuente = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fuentes);

		btn_estilo_fuentes = (Button) findViewById(R.id.btn_estilo);
		btn_estilo_fuentes.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fuentes, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		this.alertDialogList();
	}

	public void alertDialogList() {
		AlertDialog.Builder myDialog = new AlertDialog.Builder(
				FuentesActivity.this);

		final ListView listview = new ListView(FuentesActivity.this);
		LinearLayout layout = new LinearLayout(FuentesActivity.this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(listview);
		myDialog.setTitle("Fuentes");
		myDialog.setView(layout);
		myDialog.setSingleChoiceItems(arrayFuentes, posicionFuente,
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

						// ListView LiView =
						// ((AlertDialog)dialog).getListView();
						int checkedItem = ((AlertDialog) dialog).getListView()
								.getCheckedItemPosition();
						posicionFuente = checkedItem;
						System.out.println("########>>>>>>>>>>>>>"
								+ checkedItem + ".");
						cambiarFuente();
					}
				}); // fin de alert.setPositiveButton

		myDialog.show();

	}

	private void cambiarFuente() {
		switch (posicionFuente) {
		case 0:
			btn_estilo_fuentes.setTextAppearance(FuentesActivity.this,
					R.style.ejemplo_fuente1);
			break;
		case 1:
			btn_estilo_fuentes.setTextAppearance(FuentesActivity.this,
					R.style.ejemplo_fuente2);
			break;
		case 2:
			btn_estilo_fuentes.setTextAppearance(FuentesActivity.this,
					R.style.ejemplo_fuente3);
			break;
		default:
			Toast.makeText(FuentesActivity.this, "Estilo de letra no soportado", Toast.LENGTH_SHORT).show();
		}
		
	}
}
