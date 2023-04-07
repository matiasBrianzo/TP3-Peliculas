package usuario.example.tp3_pelculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import usuario.example.tp3_pelculas.databinding.ActivityMainBinding;
import usuario.example.tp3_pelculas.modelo.Pelicula;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Context context;
    private MainActivityViewModel vm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context= getApplicationContext();

        RecyclerView rv = binding.rvlista;
        GridLayoutManager grilla = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

        vm.getLista().observe(this, new Observer<ArrayList<Pelicula>>() {
            @Override
            public void onChanged(ArrayList<Pelicula> peliculas) {
                MainActivityAdapter adapter = new MainActivityAdapter(context,peliculas,getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
        vm.llenarLista();
    }
}