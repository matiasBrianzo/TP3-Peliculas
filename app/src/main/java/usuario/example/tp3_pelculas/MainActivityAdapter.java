package usuario.example.tp3_pelculas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import usuario.example.tp3_pelculas.modelo.Pelicula;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private Context context;
    private List<Pelicula>peliculas;
    private LayoutInflater inflater;

    public MainActivityAdapter(Context context, List<Pelicula> peliculas, LayoutInflater inflater) {
        this.context = context;
        this.peliculas = peliculas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.item_view,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.ViewHolder holder, int position) {
        holder.titulo.setText(peliculas.get(position).getTitulo());
        Glide.with(context)
                .load(peliculas.get(position).getUrlfoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoProducto);
        holder.resena.setText(peliculas.get(position).getResena());
      //  holder.actor.setText(peliculas.get(position).getActor());
      //  holder.director.setText(peliculas.get(position).getDirector());
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fotoProducto;
        TextView titulo,resena,actor,director;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoProducto = itemView.findViewById(R.id.ivfoto);
            titulo = itemView.findViewById(R.id.tvtitulo);
            resena = itemView.findViewById(R.id.tvresena);
            actor = itemView.findViewById(R.id.tvactoresprincipales);
            director = itemView.findViewById(R.id.tvdirector);

        }
    }

}



