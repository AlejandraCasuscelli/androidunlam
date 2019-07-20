package com.alejandra.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Helpers.ImagenesAdapter;
import Modelo.Imagen;
import Modelo.Producto;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleProductoActivity extends AppCompatActivity {

    @BindView(R.id.cantidadfotos)
    TextView cantidadfotos;

    @BindView(R.id.titulo)
    TextView titulo;

    @BindView(R.id.precio)
    TextView precio;

    @BindView(R.id.loading)
    ProgressBar loading;

    @BindView(R.id.vendidos)
    TextView vendidos;

    @BindView(R.id.stock)
    TextView stock;

    @BindView(R.id.textoGarantia)
    TextView textoGarantia;

    @BindView(R.id.contenedorDetalle)
    LinearLayout contenedorDetalle;

    Producto prod;

    private ImagenesAdapter adapter;

    @BindView(R.id.recyclerFotos)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        ButterKnife.bind(this);
        CargarDetalleDeProducto(this, getIntent().getExtras().getString("idproducto"));
    }

    private void ConfigurarRecyclerView(List<Imagen> imagenes) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ImagenesAdapter(imagenes, this);
        recyclerView.setAdapter(adapter);
    }

    private void CargarDetalleDeProducto(final Context context, String idProducto){
        Api.Api.obtenerArticulo(idProducto, new Callback<Producto>() {
        @Override
        public void onResponse(Call<Producto> call, Response<Producto> response) {
            prod = response.body();
            if(prod != null){
                Integer cantidad = prod.getImagenes().size();
                String condicion = "Usado";
                if(prod.getCondicion().equals("new"))
                    condicion = "Nuevo";

                vendidos.setText(condicion + " - " + prod.getVendidos().toString() + " vendidos");
                cantidadfotos.setText(cantidad.toString() + " fotos");
                titulo.setText(prod.getTitulo());
                precio.setText("$ " + prod.getPrecio().toString());
                stock.setText("Cantidad: " + prod.getStock().toString());
                textoGarantia.setText(prod.getGarantia());
                ConfigurarRecyclerView(prod.getImagenes());
                contenedorDetalle.setVisibility(View.VISIBLE);
            }
            loading.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<Producto> call, Throwable t) {
            loading.setVisibility(View.GONE);
            Log.e("Log", "error");
        }
    });
    }
}
