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
import com.example.bitsandpizza.entidades.Store;
import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{
    private ArrayList<Store> listStores;
    private Context activity;

    public StoreAdapter(ArrayList<Store> listStores, Context activity) {
        this.listStores = listStores;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creamos el cardView aqui
        return new StoreViewHolder((CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder storeViewHolder, int position) {
        //mostramos textos
        Store p = listStores.get(position);
        storeViewHolder.imgCvFoto.setImageResource(p.getFoto());
        storeViewHolder.tvCvNombre.setText(p.getName());

        //añado listener
        storeViewHolder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ItemDetailActivity.class);
                for (int i = 0; listStores.size() > i; i++) {
                    if (position == i) {
                        intent.putExtra("Store", listStores.get(position));
                        activity.startActivity(intent);
                    }
                }
            }
        });
    }

    public ArrayList<Store> getlistStores() {
        return listStores;
    }

    @Override
    public int getItemCount() {
        return listStores.size();
    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCvFoto;
        private TextView tvCvNombre;
        private CardView cvCardView;

        public StoreViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cvCardView = (CardView) itemView.findViewById(R.id.cvCardView);
            imgCvFoto = (ImageView) itemView.findViewById(R.id.imgCvFoto);
            tvCvNombre = (TextView) itemView.findViewById(R.id.tvCvNombre);
        }
    }
}
