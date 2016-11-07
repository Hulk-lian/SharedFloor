package com.jtsw.sharedfloor;


import android.util.Patterns;

/**
 *ESP: Clase pensada para tener las validaciones de datos
 */

public class DataValidator{

    public static boolean emailPattern(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && !email.isEmpty();
    }
}
