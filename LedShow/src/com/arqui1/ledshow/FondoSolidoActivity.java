package com.arqui1.ledshow;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class FondoSolidoActivity extends Activity implements OnClickListener {
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
	
	private ToggleButton btn_color1;
	private ToggleButton btn_color2;
	private ToggleButton btn_color3;
	private ToggleButton btn_color4;
	private ToggleButton btn_color5;
	private ToggleButton btn_color6;
	private ToggleButton btn_color7;
	private ToggleButton btn_color8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fondo_solido);
		Intent intent = getIntent();
		modo = intent.getIntExtra(MODO, -1);

		btn_color1 = (ToggleButton) findViewById(R.id.tb_1);
		btn_color2 = (ToggleButton) findViewById(R.id.tb_2);
		btn_color3 = (ToggleButton) findViewById(R.id.tb_3);
		btn_color4 = (ToggleButton) findViewById(R.id.tb_4);
		btn_color5 = (ToggleButton) findViewById(R.id.tb_5);
		btn_color6 = (ToggleButton) findViewById(R.id.tb_6);
		btn_color7 = (ToggleButton) findViewById(R.id.tb_7);
		btn_color8 = (ToggleButton) findViewById(R.id.tb_8);

		btn_color1.setOnClickListener(this);
		btn_color2.setOnClickListener(this);
		btn_color3.setOnClickListener(this);
		btn_color4.setOnClickListener(this);
		btn_color5.setOnClickListener(this);
		btn_color6.setOnClickListener(this);
		btn_color7.setOnClickListener(this);
		btn_color8.setOnClickListener(this);

		this.cargarColores();
		this.limpiarSeleccionLina1();
		this.limpiarSeleccionLina2();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fondo_solido, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case (R.id.tb_1):
			this.limpiarSeleccionLina1();
			btn_color1.setChecked(true);
			btn_color1.setBackgroundResource(linea1_check[0]);
			break;
		case (R.id.tb_2):
			this.limpiarSeleccionLina1();
			btn_color2.setChecked(true);
			btn_color2.setBackgroundResource(linea1_check[1]);
			break;
		case (R.id.tb_3):
			this.limpiarSeleccionLina1();
			btn_color3.setChecked(true);
			btn_color3.setBackgroundResource(linea1_check[2]);
			break;
		case (R.id.tb_4):
			this.limpiarSeleccionLina1();
			btn_color4.setChecked(true);
			btn_color4.setBackgroundResource(linea1_check[3]);
			break;
		case (R.id.tb_5):
			this.limpiarSeleccionLina2();
			btn_color5.setChecked(true);
			btn_color5.setBackgroundResource(linea2_check[0]);
			break;
		case (R.id.tb_6):
			this.limpiarSeleccionLina2();
			btn_color6.setChecked(true);
			btn_color6.setBackgroundResource(linea2_check[1]);
			break;
		case (R.id.tb_7):
			this.limpiarSeleccionLina2();
			btn_color7.setChecked(true);
			btn_color7.setBackgroundResource(linea2_check[2]);
			break;
		case (R.id.tb_8):
			this.limpiarSeleccionLina2();
			btn_color8.setChecked(true);
			btn_color8.setBackgroundResource(linea2_check[3]);
			break;
		}
	}

	private void limpiarSeleccionLina1() {
		btn_color1.setChecked(false);
		btn_color2.setChecked(false);
		btn_color3.setChecked(false);
		btn_color4.setChecked(false);
		
		btn_color1.setBackgroundResource(linea1[0]);
		btn_color2.setBackgroundResource(linea1[1]);
		btn_color3.setBackgroundResource(linea1[2]);
		btn_color4.setBackgroundResource(linea1[3]);
	}

	private void limpiarSeleccionLina2() {
		btn_color5.setChecked(false);
		btn_color6.setChecked(false);
		btn_color7.setChecked(false);
		btn_color8.setChecked(false);
		
		btn_color5.setBackgroundResource(linea2[0]);
		btn_color6.setBackgroundResource(linea2[1]);
		btn_color7.setBackgroundResource(linea2[2]);
		btn_color8.setBackgroundResource(linea2[3]);
	}

	private void cargarColores() {
		switch (modo) {
		case 0:
			linea1=claro_false;
			linea1_check = claro_true;
			linea2=oscuros_false;
			linea2_check=oscuro_true;
			break;

		case 1:
			linea1=oscuros_false;
			linea1_check = oscuro_true;
			linea2=claro_false;
			linea2_check = claro_true;
			break;
		default:
		}
	}
	


}
