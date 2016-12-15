package com.gmbdesign.s39_001_appinflate;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ggamboa on 15/12/16.
 */

//1º Implementamos la interface View.OnClickListener
public class PulsaBotonListener implements View.OnClickListener {

    //2º Declaramos una variable de tipo Context (Padre de activity)
    Context context;

    //3º Creamos un constructor pasando un parámetro de tipo Context o subclase de Context (Activity)
    public PulsaBotonListener(Context context){
        this.context = context;
    }

    //4º Implementamos los metodos abstractos de la interface, concretamente onClick()
    @Override
    public void onClick(View view) {

        //Este metodo es el que va a realizar las acciones una vez el boton sea pulsado
        Log.d("S39_001_Debug", "El boton ha sido pulsado");

        //Creamos una instancia de la actividad en curso
        Activity actividadEnCurso = (Activity) context;

        //Recuperamos la información introducida en el TextField
        EditText editText = (EditText) actividadEnCurso.findViewById(R.id.myNombreET);
        String nombreIntroducido = editText.getText().toString();

        //PUNTO DE CONTROL
        Log.d("S39_001_Debug", "El nombre introducido es: " + nombreIntroducido);

        //Invertimos el nombre introducido por el usuario
        String nombreInvertido = StringUtils.invertirCadena(nombreIntroducido);

        //NOS PREPARAMOS PARA INFLAR LA NUEVA VISTA
        //Recuperamos el contenedor LinearLayout de la actividad para inflar el contenido dentro
        ViewGroup contenedorLayout = (ViewGroup) actividadEnCurso.findViewById(R.id.myContenedor);

        //Declaramos la variable del label que mostrará el resultado
        TextView myEtiquetaResultado;

        //Comprobamos si la nueva vista ha sido ya inflada. Si ya esta inflada sustituimos valores
        //en caso de no estar inflada aun lo hacemos.

        if(contenedorLayout.getChildCount() > 0){

            //Ya ha sido inflada con anterioridad, procedemos a sustituir valores en el label
            Log.d("S39_001_Debug", "La vista ya ha sido inflada, actualizamos el label");
            myEtiquetaResultado  = (TextView) actividadEnCurso.findViewById(R.id.myLabelResultado);
            myEtiquetaResultado.setText("Tu nombre invertido es: " + nombreInvertido);

        }else{

            //La vista no ha sido inflada aun, procedemos a inflarla
            Log.d("S39_001_Debug", "La vista no ha sido inflada, procedemos a inflar e insertamos el valor al label");

            LayoutInflater vistaActual = actividadEnCurso.getLayoutInflater();
            View nuevaVista = vistaActual.inflate(R.layout.contenido_layout, contenedorLayout);

            //una vez inflada la vista, introducimos el valor a mostrar en la etiqueta
            myEtiquetaResultado = (TextView) nuevaVista.findViewById(R.id.myLabelResultado);
            myEtiquetaResultado.setText("Tu nombre invertido es: " + nombreInvertido);

        }


    }
}
