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
import com.example.bitsandpizza.entidades.Pizza;
import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>{
    private ArrayList<Pizza> listPizzas;
    private Context activity;

    public PizzaAdapter(ArrayList<Pizza> listPizzas, Context activity) {
        this.listPizzas = listPizzas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creamos el cardView aqui
        return new PizzaViewHolder((CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder pizzaViewHolder, int position) {
        //mostramos textos
        Pizza p = listPizzas.get(position);
        pizzaViewHolder.imgCvFoto.setImageResource(p.getFoto());
        pizzaViewHolder.tvCvNombre.setText(p.getName());

        //añado listener
        pizzaViewHolder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ItemDetailActivity.class);
                for (int i = 0; listPizzas.size() > i; i++) {
                    if (position == i) {
                        intent.putExtra("Pizza", listPizzas.get(position));
                        activity.startActivity(intent);
                    }
                }
            }
        });
    }

    public ArrayList<Pizza> getListPizzas() {
        return listPizzas;
    }

    @Override
    public int getItemCount() {
        return listPizzas.size();
    }

    public static class PizzaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCvFoto;
        private TextView tvCvNombre;
        private CardView cvCardView;

        public PizzaViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cvCardView = (CardView) itemView.findViewById(R.id.cvCardView);
            imgCvFoto = (ImageView) itemView.findViewById(R.id.imgCvFoto);
            tvCvNombre = (TextView) itemView.findViewById(R.id.tvCvNombre);
        }
    }
}
