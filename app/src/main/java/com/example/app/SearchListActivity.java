package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchListActivity extends AppCompatActivity {

    TextView textoBuscado;
    Button btnDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        textoBuscado = findViewById(R.id.textoBuscado);
        btnDetalle = findViewById(R.id.btnDetalle);

        String textoBuscar = getIntent().getExtras().getString("textoBuscar");
        textoBuscado.setText(textoBuscar);

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
