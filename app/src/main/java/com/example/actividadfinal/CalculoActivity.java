package com.example.actividadfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculoActivity extends Activity {

    private Button btnran;
    private Button menu;
    private EditText respuesta;
    private TextView numero1;
    private TextView numero2;
    private TextView resultado;
    private TextView operacion;
    private Button validador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        numero1 = findViewById(R.id.lblNumero1);
        validador = findViewById(R.id.btnValidar);
        menu = findViewById(R.id.btnMenu);
        numero2 = findViewById(R.id.lblNumero2);
        operacion = findViewById(R.id.lblOperacion);
        respuesta = findViewById(R.id.txtrespuesta);
        btnran = findViewById(R.id.btnrandon);
        resultado = findViewById(R.id.lblResultado);

        btnran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double rand1 = (Math.random()*49)+1;
                double rand2 = (Math.random()*49)+1;
                double ranop =  (Math.round((Math.random()*3)))+1;
                numero1.setText(String.valueOf(Math.round(rand1)));
                numero2.setText(String.valueOf(Math.round(rand2)));
                numero1.setVisibility(View.VISIBLE);
                resultado.setVisibility(View.INVISIBLE);
                numero2.setVisibility(View.VISIBLE);
                operacion.setVisibility(View.VISIBLE);
                respuesta.setText("");
                if (ranop == 1){
                    suma();
                }else if (ranop == 2){
                    resta();
                }else if(ranop == 3){
                    multiplicacion();
                }else if (ranop == 4){
                    division();
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Que mala suerte",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        validador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(respuesta.getText().toString().trim().equals(resultado.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Respuesta Correcta",Toast.LENGTH_SHORT).show();
                    resultado.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(),"Respuesta Incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void suma(){
        resultado.setText(String.valueOf( Math.round(Double.parseDouble(numero1.getText().toString()) + Double.parseDouble(numero2.getText().toString()))));
        operacion.setText("+");
    }

    private void resta(){
        resultado.setText(String.valueOf( Math.round(Double.parseDouble(numero1.getText().toString()) - Double.parseDouble(numero2.getText().toString()))));
        operacion.setText("-");
    }

    private void multiplicacion(){
        resultado.setText(String.valueOf( Math.round(Double.parseDouble(numero1.getText().toString()) * Double.parseDouble(numero2.getText().toString()))));
        operacion.setText("*");
    }

    private void division(){
        DecimalFormat formato1 = new DecimalFormat("#.##");
        resultado.setText(formato1.format(Double.parseDouble(numero1.getText().toString()) / Double.parseDouble(numero2.getText().toString())));
        operacion.setText("/");
    }
}
