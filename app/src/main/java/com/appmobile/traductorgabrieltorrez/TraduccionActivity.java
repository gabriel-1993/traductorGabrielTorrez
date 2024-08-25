package com.appmobile.traductorgabrieltorrez;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.appmobile.traductorgabrieltorrez.databinding.ActivityMainBinding;
import com.appmobile.traductorgabrieltorrez.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {

    private TraduccionActivityViewModel mv;
    private ActivityTraduccionBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);
        binding = ActivityTraduccionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        mv.getMpalabra().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.tvTraduccion.setText(palabra.getIngles().toString());
                binding.ivTraduccion.setImageResource(palabra.getImagen());
            }
        });

        mv.traducir(getIntent());

    }
}