package com.example.bitsandpizza.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitsandpizza.MainActivity;
import com.example.bitsandpizza.R;
import com.example.bitsandpizza.adapters.StoreAdapter;
import com.example.bitsandpizza.entidades.Store;

import java.util.ArrayList;

public class StoreFragment extends Fragment {
    private ArrayList<Store> listStores;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_store, container, false);
        addRecyclerView();
        return view;
    }

    private void addRecyclerView() {
        //extendes Fragment, hay que heredarlo para que funcione
        RecyclerView rvListStore = (RecyclerView) view.findViewById(R.id.rvListStore);

        //añado layout de como se va a ver
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListStore.setLayoutManager(linearLayoutManager);

        //creamos la lista de pizzas
        listStores = Store.initListStores();

        //añado adaptador
        StoreAdapter adapter = new StoreAdapter(listStores,view.getContext());
        listStores = adapter.getlistStores();
        rvListStore.setAdapter(adapter);
    }


}
