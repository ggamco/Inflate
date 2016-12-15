package com.gmbdesign.s39_001_appinflate;

import android.util.Log;

/**
 * Created by ggamboa on 15/12/16.
 */

public class StringUtils {

    public static String invertirCadena(String cadena){

        String cadenaInvertida = "";

        for(int i = (cadena.length() -1); i >= 0; i--){
            cadenaInvertida += cadena.charAt(i);
        }

        return cadenaInvertida;
    }

}
