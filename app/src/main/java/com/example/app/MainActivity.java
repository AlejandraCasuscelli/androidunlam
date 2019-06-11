package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fotoProducto)
    ImageView fotoProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Picasso.with(this).load("https://s03.s3c.es/imag/_v0/770x420/7/2/e/Zapatilla-Vans-Ward-Canvas..jpg").into(fotoProducto);
    }
}
