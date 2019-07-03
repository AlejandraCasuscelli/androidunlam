package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import Modelo.Producto;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleProductoActivity extends AppCompatActivity {

    @BindView(R.id.fotoProducto)
    ImageView fotoProducto;
    Producto prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Picasso.with(this).load("https://s03.s3c.es/imag/_v0/770x420/7/2/e/Zapatilla-Vans-Ward-Canvas..jpg").into(fotoProducto);
    }

//     Api.Api.obtenerArticulo("MLA643261465", new Callback<Producto>() {
//        @Override
//        public void onResponse(Call<Producto> call, Response<Producto> response) {
//            prod = response.body();
//            String saraza = prod.getId();
//        }
//
//        @Override
//        public void onFailure(Call<Producto> call, Throwable t) {
//            Log.e("Log", "error");
//        }
//    });
}
