package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import Helpers.ProductosAdapter;
import Modelo.Busqueda;
import Modelo.Producto;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchListActivity extends AppCompatActivity {

    @BindView(R.id.textoBuscado)
    TextView textoBuscado;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.loading)
    ProgressBar loading;

    @BindView(R.id.productoerror)
    TextView productoerror;

    private ProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ButterKnife.bind(this);
        textoBuscado.setText("Búsqueda: " + getIntent().getExtras().getString("textoBuscar"));
        CargarBusqueda(getIntent().getExtras().getString("textoBuscar"));
    }

    private void ConfigurarRecyclerView(List<Producto> productos) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductosAdapter(productos, this);
        recyclerView.setAdapter(adapter);
    }

    public void CargarBusqueda(String itemBusqueda) {

        Api.Api.obtenerListadoProductos(itemBusqueda, new Callback<Busqueda>() {

            @Override
            public void onResponse(Call<Busqueda> call, Response<Busqueda> response) {
                if (response.isSuccessful()) {
                    Busqueda productos = response.body();
                    if(productos != null){
                        ConfigurarRecyclerView(productos.getProductos());
                    } else {
                        productoerror.setVisibility(View.VISIBLE);
                    }

                    loading.setVisibility(View.GONE);
                } else {
                    productoerror.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Busqueda> call, Throwable t) {
                productoerror.setVisibility(View.VISIBLE);
                loading.setVisibility(View.GONE);
            }


        });

    }
}
