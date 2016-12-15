package com.gmbdesign.s39_001_appinflate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Creamos una instancia del boton definido en la vista, para esto lo buscamos por su id
        Button botonInvertirTxt = (Button) findViewById(R.id.myBotonInvertirTxt);

        //Creamos una instancia del listener y le pasamos la actividad que se está ejecutando
        PulsaBotonListener pulsaBoton = new PulsaBotonListener(this);

        //Configuramos el listener que va a escuchar los eventos del boton
        botonInvertirTxt.setOnClickListener(pulsaBoton);

    }
}
