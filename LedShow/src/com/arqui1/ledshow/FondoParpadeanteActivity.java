package com.arqui1.ledshow;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class FondoParpadeanteActivity extends Activity implements
		OnClickListener {
	private int modo = -1;
	public static final String MODO = "modo";

	private int claro_false[] = { R.drawable.claro1_amarillo,
			R.drawable.claro2_blanco, R.drawable.claro3_celeste,
			R.drawable.claro4_naranja };
	
	private int claro_true[] = { R.drawable.claro1_amarillo_check,
			R.drawable.claro2_blanco_check, R.drawable.claro3_celeste_check,
			R.drawable.claro4_naranja_check };

	private int oscuros_false[] = { R.drawable.oscuro1_negro,
			R.drawable.oscuro2_rojo, R.drawable.oscuro3_verde,
			R.drawable.oscuro4_azul };
	
	private int oscuro_true[] = { R.drawable.oscuro1_negro_check,
			R.drawable.oscuro2_rojo_check, R.drawable.oscuro3_verde_check,
			R.drawable.oscuro4_azul_check };

	private int linea1[];
	private int linea1_check[];
	private int linea2[];
	private int linea2_check[];
	private int linea3[];
	private int linea3_check[];

	private ToggleButton btn_f1_1;
	private ToggleButton btn_f1_2;
	private ToggleButton btn_f1_3;
	private ToggleButton btn_f1_4;

	private ToggleButton btn_f2_1;
	private ToggleButton btn_f2_2;
	private ToggleButton btn_f2_3;
	private ToggleButton btn_f2_4;

	private ToggleButton btn_f3_1;
	private ToggleButton btn_f3_2;
	private ToggleButton btn_f3_3;
	private ToggleButton btn_f3_4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fondo_parpadeante);
		Intent intent = getIntent();
		modo = intent.getIntExtra(MODO, -1);

		btn_f1_1 = (ToggleButton) findViewById(R.id.tb_f1_1);
		btn_f1_2 = (ToggleButton) findViewById(R.id.tb_f1_2);
		btn_f1_3 = (ToggleButton) findViewById(R.id.tb_f1_3);
		btn_f1_4 = (ToggleButton) findViewById(R.id.tb_f1_4);

		btn_f2_1 = (ToggleButton) findViewById(R.id.tb_f2_1);
		btn_f2_2 = (ToggleButton) findViewById(R.id.tb_f2_2);
		btn_f2_3 = (ToggleButton) findViewById(R.id.tb_f2_3);
		btn_f2_4 = (ToggleButton) findViewById(R.id.tb_f2_4);

		btn_f3_1 = (ToggleButton) findViewById(R.id.tb_f3_1);
		btn_f3_2 = (ToggleButton) findViewById(R.id.tb_f3_2);
		btn_f3_3 = (ToggleButton) findViewById(R.id.tb_f3_3);
		btn_f3_4 = (ToggleButton) findViewById(R.id.tb_f3_4);

		btn_f1_1.setOnClickListener(this);
		btn_f1_2.setOnClickListener(this);
		btn_f1_3.setOnClickListener(this);
		btn_f1_4.setOnClickListener(this);

		btn_f2_1.setOnClickListener(this);
		btn_f2_2.setOnClickListener(this);
		btn_f2_3.setOnClickListener(this);
		btn_f2_4.setOnClickListener(this);

		btn_f3_1.setOnClickListener(this);
		btn_f3_2.setOnClickListener(this);
		btn_f3_3.setOnClickListener(this);
		btn_f3_4.setOnClickListener(this);

		this.cargarColores();
		this.limpiarSeleccionLinea1();
		this.limpiarSeleccionLinea2();
		this.limpiarSeleccionLinea3();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fondo_parpadeante, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// ---FILA 1-------------------------------
		case (R.id.tb_f1_1):
			this.limpiarSeleccionLinea1();
			btn_f1_1.setChecked(true);
			btn_f1_1.setBackgroundResource(linea1_check[0]);
			break;
		case (R.id.tb_f1_2):
			this.limpiarSeleccionLinea1();
			btn_f1_2.setChecked(true);
			btn_f1_2.setBackgroundResource(linea1_check[1]);
			break;
		case (R.id.tb_f1_3):
			this.limpiarSeleccionLinea1();
			btn_f1_3.setChecked(true);
			btn_f1_3.setBackgroundResource(linea1_check[2]);
			break;
		case (R.id.tb_f1_4):
			this.limpiarSeleccionLinea1();
			btn_f1_4.setChecked(true);
			btn_f1_4.setBackgroundResource(linea1_check[3]);
			break;
		// ---FILA 2------------------------------
		case (R.id.tb_f2_1):
			this.limpiarSeleccionLinea2();
			btn_f2_1.setChecked(true);
			btn_f2_1.setBackgroundResource(linea2_check[0]);
			break;
		case (R.id.tb_f2_2):
			this.limpiarSeleccionLinea2();
			btn_f2_2.setChecked(true);
			btn_f2_2.setBackgroundResource(linea2_check[1]);
			break;
		case (R.id.tb_f2_3):
			this.limpiarSeleccionLinea2();
			btn_f2_3.setChecked(true);
			btn_f2_3.setBackgroundResource(linea2_check[2]);
			break;
		case (R.id.tb_f2_4):
			this.limpiarSeleccionLinea2();
			btn_f2_4.setChecked(true);
			btn_f2_4.setBackgroundResource(linea2_check[3]);
			break;
		// ---FILA 3-----------------------------
		case (R.id.tb_f3_1):
			this.limpiarSeleccionLinea3();
			btn_f3_1.setChecked(true);
			btn_f3_1.setBackgroundResource(linea3_check[0]);
			break;
		case (R.id.tb_f3_2):
			this.limpiarSeleccionLinea3();
			btn_f3_2.setChecked(true);
			btn_f3_2.setBackgroundResource(linea3_check[1]);
			break;
		case (R.id.tb_f3_3):
			this.limpiarSeleccionLinea3();
			btn_f3_3.setChecked(true);
			btn_f3_3.setBackgroundResource(linea3_check[2]);
			break;
		case (R.id.tb_f3_4):
			this.limpiarSeleccionLinea3();
			btn_f3_4.setChecked(true);
			btn_f3_4.setBackgroundResource(linea3_check[3]);
			break;
		}
	}

	private void limpiarSeleccionLinea1() {
		btn_f1_1.setChecked(false);
		btn_f1_2.setChecked(false);
		btn_f1_3.setChecked(false);
		btn_f1_4.setChecked(false);

		btn_f1_1.setBackgroundResource(linea1[0]);
		btn_f1_2.setBackgroundResource(linea1[1]);
		btn_f1_3.setBackgroundResource(linea1[2]);
		btn_f1_4.setBackgroundResource(linea1[3]);
	}

	private void limpiarSeleccionLinea2() {
		btn_f2_1.setChecked(false);
		btn_f2_2.setChecked(false);
		btn_f2_3.setChecked(false);
		btn_f2_4.setChecked(false);

		btn_f2_1.setBackgroundResource(linea2[0]);
		btn_f2_2.setBackgroundResource(linea2[1]);
		btn_f2_3.setBackgroundResource(linea2[2]);
		btn_f2_4.setBackgroundResource(linea2[3]);
	}

	private void limpiarSeleccionLinea3() {
		btn_f3_1.setChecked(false);
		btn_f3_2.setChecked(false);
		btn_f3_3.setChecked(false);
		btn_f3_4.setChecked(false);

		btn_f3_1.setBackgroundResource(linea3[0]);
		btn_f3_2.setBackgroundResource(linea3[1]);
		btn_f3_3.setBackgroundResource(linea3[2]);
		btn_f3_4.setBackgroundResource(linea3[3]);
	}

	private void cargarColores() {
		linea1 = oscuros_false;
		linea1_check = oscuro_true;
		
		linea2 = claro_false;
		linea2_check = claro_true;
		
		switch (modo) {
		case 0:
			linea3 = claro_false;
			linea3_check = claro_true;
			break;

		case 1:
			linea3 = oscuros_false;
			linea3_check = oscuro_true;
			break;
		default:
		}
	}

}
