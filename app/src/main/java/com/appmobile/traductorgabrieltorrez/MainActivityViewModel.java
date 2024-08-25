package com.appmobile.traductorgabrieltorrez;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    /*mutable para msjs de error*/
    private MutableLiveData<String> mMensaje;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    /*get del mutable para acceder y/o aplicarle observer*/
    public LiveData<String> getMmensaje(){
        /*si no esta inicializada antes de aplicar el observador se inicializa*/
        if(mMensaje == null){
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public void verificar(String palabra){
        //validar que exista la traduccion y no este vacio el campo
        if(palabra.trim().toLowerCase().equals("")){
            //cargar msj error al mutable para renderizarlo
            mMensaje.setValue("Palabra ingresada vacia, por favor ingrese una palabra...");
        }else if (!palabra.equals("gato") && !palabra.equals("perro")){
            //cargar msj error al mutable para renderizarlo
            mMensaje.setValue("No hay resultados para la busqueda, por el momento contamos con perro o gato :) ");
        }else{

            /*para ir a otro activity necesitamos un intent*/
            Intent intent = new Intent(getApplication(),TraduccionActivity.class);

            /*agregar datos al intent*/
            /*crear objeto que representa una coleccion de elmentos: bundle*/
            Bundle bundle = new Bundle();
            bundle.putSerializable("palabra", palabra);
            intent.putExtra("palabra", bundle);

            /*iniciar activity fuera de una activity: agregar bandera al intent indicando que no se inicia de una activity*/
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            /*activar la activity*/
            getApplication().startActivity(intent);
        }
    }




}
