package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchListActivity extends AppCompatActivity {

    @BindView(R.id.textoBuscado)
    TextView textoBuscado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ButterKnife.bind(this);
        textoBuscado.setText(getIntent().getExtras().getString("textoBuscar"));
    }

    @OnClick(R.id.btnDetalle)
    public void ClickEnIrADetalle(){
        Intent intent = new Intent(SearchListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
