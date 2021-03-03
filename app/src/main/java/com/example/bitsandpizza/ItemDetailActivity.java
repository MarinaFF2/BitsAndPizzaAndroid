package com.example.bitsandpizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bitsandpizza.entidades.Pasta;
import com.example.bitsandpizza.entidades.Pizza;
import com.example.bitsandpizza.entidades.Store;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        rellenarView();
        addMenu();
    }
    private void addMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void rellenarView() {
        ImageView imgCvFoto = (ImageView) findViewById(R.id.imgFoto);
        TextView tvCvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        if (getIntent().getSerializableExtra("Pizza") != null) {//si es pizza
            Pizza pizza = (Pizza) getIntent().getSerializableExtra("Pizza");
            imgCvFoto.setImageResource(pizza.getFoto());
            tvCvNombre.setText(pizza.getName());
            tvDescripcion.setText(pizza.getDescription());
        }else if (getIntent().getSerializableExtra("Pasta") != null) {//si es pasta
            Pasta pasta = (Pasta) getIntent().getSerializableExtra("Pasta");
            imgCvFoto.setImageResource(pasta.getFoto());
            tvCvNombre.setText(pasta.getName());
            tvDescripcion.setText(pasta.getDescription());
        }else if (getIntent().getSerializableExtra("Store") != null) { //si es una tienda
            Store store = (Store) getIntent().getSerializableExtra("Store");
            imgCvFoto.setImageResource(store.getFoto());
            tvCvNombre.setText(store.getName());
            tvDescripcion.setText(store.getDescription());
        }else{ //deafult
            imgCvFoto.setImageResource(R.drawable.restaurant);
            tvCvNombre.setText("Name");
            tvDescripcion.setText("Description");
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == android.view.KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}