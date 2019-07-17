package com.alejandra.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        if(textoBuscar.getText().toString().isEmpty())
            return;
        intent.putExtra("textoBuscar", textoBuscar.getText().toString());
        startActivity(intent);
    }
}
