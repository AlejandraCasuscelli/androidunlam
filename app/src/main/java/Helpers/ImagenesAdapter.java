package Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alejandra.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Modelo.Imagen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagenesAdapter extends RecyclerView.Adapter<ImagenesAdapter.ViewHolder>{

    private List<Imagen> imagenes = new ArrayList();
    Context context;

    public ImagenesAdapter(List<Imagen> imagenes, Context ctx) {
        this.imagenes = imagenes;
        context = ctx;
    }

    @Override
    public ImagenesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imagenes_detalle, null);
        return new ImagenesAdapter.ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagenesAdapter.ViewHolder viewHolder, final int position) {

        final Imagen imagenAMostrar = this.imagenes.get(position);

        if(!imagenAMostrar.getUrl().isEmpty())
            Picasso.with(context).load(imagenAMostrar.getUrl()).placeholder(R.drawable.placeholder).into(viewHolder.fotoProducto);
    }

    @Override
    public int getItemCount() {
        if(imagenes != null)
            return imagenes.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fotoProducto)
        ImageView fotoProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
