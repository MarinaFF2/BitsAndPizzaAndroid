package com.example.bitsandpizza.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitsandpizza.R;
import com.example.bitsandpizza.adapters.PizzaAdapter;
import com.example.bitsandpizza.entidades.Pizza;

import java.util.ArrayList;

public class PizzaFragment extends Fragment {
    private ArrayList<Pizza> listPizzas;
    private RecyclerView rvListPizza;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pizza, container, false);
        addRecyclerView();
        return view;
    }

    private void addRecyclerView() {
        //extendes Fragment, hay que heredarlo para que funcione
        rvListPizza = (RecyclerView) view.findViewById(R.id.rvListPizza);

        //añado layout de como se va a ver
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListPizza.setLayoutManager(linearLayoutManager);

        //creamos la lista de pizzas
        listPizzas = Pizza.initListPizzas();

        //añado adaptador
        PizzaAdapter adapter = new PizzaAdapter(listPizzas,view.getContext());
        listPizzas = adapter.getListPizzas();
        rvListPizza.setAdapter(adapter);

    }
}
