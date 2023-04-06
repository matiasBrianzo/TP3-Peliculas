package usuario.example.tp3_pelculas;

import androidx.appcompat.app.AppCompatActivity;
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
    private ArrayList<Pelicula> peliculas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context= getApplicationContext();
        peliculas.add(new Pelicula("Indiana Jones","https://i.pinimg.com/originals/80/6d/ce/806dce66a7ed780e14da5a4b3e23234a.jpg","El padre del intrépido arqueólogo Indiana Jones","Harrison Ford, Sean Connery","Steven Spielberg"));
        peliculas.add(new Pelicula("Star Trek","https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/08/star-trek-alla-2774543.jpg","El joven James T. Kirk, Spock y el resto de la tripulación del Enterprise ","James Tiberius Kirk,Zachary Quinto (Spock),Simon Pegg (Montgomery Scott)"," J. J. Abrams"));
        peliculas.add(new Pelicula("Star War","https://wallpapers.com/images/featured/plzcoaffexgf4h81.jpg","La nave en la que viaja la princesa Leia es capturada por las tropas imperiales al mando del temible Darth Vader.","Luke Skywalker Mark Hamill","George Lucas"));

        RecyclerView rv = binding.rvlista;
        GridLayoutManager grilla = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

        MainActivityAdapter adapter = new MainActivityAdapter(context,peliculas,getLayoutInflater());
        rv.setAdapter(adapter);

        /*
        *  ListaProductoAdapter adapter = new ListaProductoAdapter(getContext(),list,inflater);
        rv.setAdapter(adapter);

        *
        * */

       // return root;

    }
}