package com.appmobile.traductorgabrieltorrez;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TraduccionActivityViewModel extends AndroidViewModel {

    /*mutable para palabra*/
    private MutableLiveData<Palabra> mPalabra;

    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);
    }

    /*get del mutable para acceder y/o aplicarle observer*/
    public LiveData<Palabra> getMpalabra(){
        /*si no esta inicializada antes de aplicar el observador se inicializa*/
        if(mPalabra == null){
            mPalabra = new MutableLiveData<>();
        }
        return mPalabra;
    }

    public void traducir(Intent intent){
        //recuperar bundle
        Bundle bundle = intent.getBundleExtra("palabra");

        //parsear serializable a string para recueprar nuestra palabra
        String palabra =(String) bundle.getSerializable("palabra");

        if(palabra!=null){

            // Crear el array de objetos Palabra
            Palabra[] palabras = new Palabra[]
                    {new Palabra("perro", "dog", R.drawable.checo),
                     new Palabra("gato", "cat", R.drawable.chango)
                    };

            // Buscar el objeto Palabra que coincida con el español
            Palabra resultado = null;

            // Recorrer el array usando un bucle for
            for (int i = 0; i < palabras.length; i++)
            {
                if (palabras[i].getEspañol().equals(palabra))
                {
                    resultado = palabras[i];
                    break; // Salir del bucle si se encuentra la coincidencia
                }
            }

            // Si se encuentra el objeto Palabra, asignarlo a mutable mPalabra
            if (resultado != null)
            {
                mPalabra.setValue(resultado);

            }
        }
    }

}
