package usuario.example.tp3_pelculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.nio.charset.StandardCharsets;

import usuario.example.tp3_pelculas.databinding.ActivityDetalleBinding;
import usuario.example.tp3_pelculas.databinding.ActivityMainBinding;
import usuario.example.tp3_pelculas.modelo.Pelicula;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context= getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Pelicula pelicula = (Pelicula) bundle.getSerializable("pelicula");

        binding.tvtitulo.setText(pelicula.getTitulo());

        Glide.with(context)
                .load(pelicula.getUrlfoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivfoto);
        binding.tvresena.setText(pelicula.getResena());
        binding.tvactores.setText(pelicula.getActor());
        binding.tvdirector.setText(pelicula.getDirector());

    }
}