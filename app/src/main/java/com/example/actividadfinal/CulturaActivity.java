package com.example.actividadfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CulturaActivity<n> extends AppCompatActivity {

    private int nuevocontador;
    private int correct = 0;
    private int fail = 0;
    private TextView pregunta;
    private TextView respuestacorrecta;
    private TextView respuestaincorrecta;
    private TextView titlecorrecta;
    private TextView titleincorrecta;
    private RadioButton respuesta1;
    private RadioButton respuesta2;
    private RadioButton respuesta3;
    private RadioGroup gruporespuesta;
    private Button validador;
    private Button comenzar;
    private Button menu;
    int seleccion;
    int[] respuestas;
    int casos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura);
        pregunta = findViewById(R.id.lblPregunta);
        respuestacorrecta = findViewById(R.id.lblRespuestaCorrecta);
        respuestaincorrecta = findViewById(R.id.lblRespuestaIncorrecta);
        titlecorrecta = findViewById(R.id.lblTitleCorrecta);
        titleincorrecta = findViewById(R.id.lblTitleIncorrecta);
        gruporespuesta = findViewById(R.id.radgroup);
        respuesta1 = findViewById(R.id.rbtRespuesta1);
        respuesta2 = findViewById(R.id.rbtRespuesta2);
        respuesta3 = findViewById(R.id.rbtRespuesta3);
        validador = findViewById(R.id.btnValidar);
        comenzar = findViewById(R.id.btnComenzar);
        menu = findViewById(R.id.btnMenu);
        final boolean intento = true;
        final int[] contador = {1};


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcalculo = new Intent(CulturaActivity.this,MainActivity.class);
                startActivity(intentcalculo);
                //
                finish();
            }
        });


        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pregunta.setVisibility(View.VISIBLE);
                comenzar.setVisibility(View.INVISIBLE);
                validador.setVisibility(View.VISIBLE);
                pregunta.setText("Preparado, Ahora comencemos!");
            }
        });

        validador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                respuestas = new int[6];
                respuestas[0] = 0;
                respuestas[1] = 1;
                respuestas[2] = 3;
                respuestas[3] = 2;
                respuestas[4] = 2;
                respuestas[5] = 1;

                if(gruporespuesta.getCheckedRadioButtonId() == R.id.rbtRespuesta1){
                    seleccion = 1;
                }else  if (gruporespuesta.getCheckedRadioButtonId() == R.id.rbtRespuesta2){
                    seleccion =2;
                }else if(gruporespuesta.getCheckedRadioButtonId() == R.id.rbtRespuesta3){
                    seleccion =3;
                }

                if (intento){
                   gruporespuesta.setVisibility(View.VISIBLE);
                   casos = contador[0]++;
                   funcaos(casos);
                }
                if(nuevocontador !=6){
                    if(nuevocontador != 0){
                        if(respuestas[nuevocontador] == seleccion){
                            Toast.makeText(getApplicationContext(),"Respuesta Correcta",Toast.LENGTH_SHORT).show();
                            gruporespuesta.clearCheck();
                            nuevocontador++;
                            correct++;
                        }else{
                            Toast.makeText(getApplicationContext(),"Respuesta Incorrecta",Toast.LENGTH_SHORT).show();
                            gruporespuesta.clearCheck();
                            nuevocontador++;
                            fail++;
                        }
                        if(nuevocontador == 6){
                            finalizar();
                        }
                    }else {
                        nuevocontador++;
                    }
                }
            }
        });
    }


    public void finalizar(){
        pregunta.setVisibility(View.INVISIBLE);
        gruporespuesta.setVisibility(View.INVISIBLE);
        validador.setVisibility(View.INVISIBLE);
        titlecorrecta.setVisibility(View.VISIBLE);
        titleincorrecta.setVisibility(View.VISIBLE);
        respuestacorrecta.setVisibility(View.VISIBLE);
        respuestaincorrecta.setVisibility(View.VISIBLE);
        respuestacorrecta.setText(String.valueOf(correct));
        respuestaincorrecta.setText(String.valueOf(fail));

    }

    public void funcaos(int casos){
        switch (casos){
            case 1:
                pregunta.setText("¿En que año nacio cristobal colon?");
                respuesta1.setText("1451");
                respuesta2.setText("1444");
                respuesta3.setText("1467");
                break;
            case 2:
                pregunta.setText("¿Qué pasó ayer en París de 6 a 7?");
                respuesta1.setText("Una guerra mundial");
                respuesta2.setText("El tiempo");
                respuesta3.setText("Una hora");
                break;
            case 3:
                pregunta.setText("¿Cuanto tiempo duro la guerra de los mil dias?");
                respuesta1.setText("1000 Dias");
                respuesta2.setText("1130 Dias");
                respuesta3.setText("1200 Dias");
                break;
            case 4:
                pregunta.setText("¿Cual es la fecha del acuerdo de paz en Colombia?");
                respuesta1.setText("17 de octubre de 2018");
                respuesta2.setText("12 de septiembre de 2015");
                respuesta3.setText("24 de noviembre de 2016");
                break;
            case 5:
                pregunta.setText("¿Quien fue Gabriel García Márquez?");
                respuesta1.setText("Un escritor");
                respuesta2.setText("Un actor");
                respuesta3.setText("Una persona");
                break;
        }
    }

}
