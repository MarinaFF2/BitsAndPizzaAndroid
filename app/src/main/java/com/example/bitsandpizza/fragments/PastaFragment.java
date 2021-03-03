package com.example.bitsandpizza.fragments;

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
import com.example.bitsandpizza.adapters.PastaAdapter;
import com.example.bitsandpizza.entidades.Pasta;

import java.util.ArrayList;

public class PastaFragment extends Fragment {
    private ArrayList<Pasta> listPastas;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pasta, container, false);
        addRecyclerView();
        return view;
    }

    private void addRecyclerView() {
        //extendes Fragment, hay que heredarlo para que funcione
        RecyclerView rvListPasta = (RecyclerView) view.findViewById(R.id.rvListPasta);

        //añado layout de como se va a ver
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListPasta.setLayoutManager(linearLayoutManager);

        //creamos la lista de pizzas
        listPastas = Pasta.initListPastas();

        //añado adaptador
        PastaAdapter adapter = new PastaAdapter(listPastas,view.getContext());
        listPastas = adapter.getlistPastas();
        rvListPasta.setAdapter(adapter);

    }
}
