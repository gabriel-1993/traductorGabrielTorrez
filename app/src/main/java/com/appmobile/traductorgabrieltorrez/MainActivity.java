package com.appmobile.traductorgabrieltorrez;

import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.appmobile.traductorgabrieltorrez.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*referencia viewModel*/
    private MainActivityViewModel mv;
    /*referencia binding*/
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getMmensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMsjs.setText(s);
            }
        });

        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palabra = binding.edIngreso.getText().toString().trim().toLowerCase();
                mv.verificar(palabra);
            }
        });



    }
}