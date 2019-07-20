package Helpers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alejandra.app.DetalleProductoActivity;
import com.alejandra.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Modelo.Producto;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder>{

    private List<Producto> productos = new ArrayList();
    Context context;

    public ProductosAdapter(List<Producto> productos, Context ctx) {
        this.productos = productos;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_producto, null);
        return new ProductosAdapter.ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final Producto productoAMostrar = this.productos.get(position);

        viewHolder.titulo.setText(productoAMostrar.getTitulo());
        viewHolder.precio.setText("$ " + productoAMostrar.getPrecio());

        if(!productoAMostrar.getUrlImagenMiniatura().isEmpty())
        Picasso.with(context).load(productoAMostrar.getUrlImagenMiniatura()).placeholder(R.drawable.placeholder).into(viewHolder.imgminiatura);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleProductoActivity.class);
                intent.putExtra("idproducto",productoAMostrar.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(productos != null)
            return productos.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titulo)
        TextView titulo;

        @BindView(R.id.precio)
        TextView precio;

        @BindView(R.id.imgminiatura)
        ImageView imgminiatura;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
