package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Api.MercadoLibreApi;
import Modelo.Producto;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.textoBuscar)
    EditText textoBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBuscar)
    public void clickEnBtnBuscar(){
        Intent intent = new Intent(HomeActivity.this, SearchListActivity.class);
        intent.putExtra("textoBuscar", textoBuscar.getText().toString());
        startActivity(intent);
    }
}
