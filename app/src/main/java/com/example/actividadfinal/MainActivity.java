package com.example.actividadfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button calculo;
    protected Button salir;
    protected Button cultura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculo = findViewById(R.id.btnCalculo);
        cultura = findViewById(R.id.btnCultura);
        salir = findViewById(R.id.btnSalir);

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcalculo = new Intent(MainActivity.this,CalculoActivity.class);
                startActivity(intentcalculo);
                finish();
            }
        });

        cultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCultura = new Intent(MainActivity.this,CulturaActivity.class);
                startActivity(intentCultura);
                finish();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
