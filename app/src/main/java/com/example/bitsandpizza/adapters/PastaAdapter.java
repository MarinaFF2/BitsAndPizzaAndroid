package com.example.bitsandpizza.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bitsandpizza.ItemDetailActivity;
import com.example.bitsandpizza.R;
import com.example.bitsandpizza.entidades.Pasta;
import java.util.ArrayList;

public class PastaAdapter extends RecyclerView.Adapter<PastaAdapter.PastaViewHolder>{
    private ArrayList<Pasta> listPastas;
    private Context activity;
    public PastaAdapter(ArrayList<Pasta> listPastas, Context activity) {
        this.listPastas = listPastas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PastaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creamos el cardView aqui
        return new PastaViewHolder((CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastaViewHolder pastaViewHolder, int position) {
        //mostramos textos
        Pasta p = listPastas.get(position);
        pastaViewHolder.imgCvFoto.setImageResource(p.getFoto());
        pastaViewHolder.tvCvNombre.setText(p.getName());

        //añado listener
        pastaViewHolder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ItemDetailActivity.class);
                for (int i = 0; listPastas.size() > i; i++) {
                    if (position == i) {
                        intent.putExtra("Pasta", listPastas.get(position));
                        activity.startActivity(intent);
                    }
                }
            }
        });
    }

    public ArrayList<Pasta> getlistPastas() {
        return listPastas;
    }

    @Override
    public int getItemCount() {
        return listPastas.size();
    }

    public static class PastaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCvFoto;
        private TextView tvCvNombre;
        private CardView cvCardView;

        public PastaViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cvCardView = (CardView) itemView.findViewById(R.id.cvCardView);
            imgCvFoto = (ImageView) itemView.findViewById(R.id.imgCvFoto);
            tvCvNombre = (TextView) itemView.findViewById(R.id.tvCvNombre);
        }
    }
}
