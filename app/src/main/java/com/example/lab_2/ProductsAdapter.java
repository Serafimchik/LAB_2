package com.example.lab_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    private ArrayList<String> mDataset;


    public ProductsAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ProductsAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one, parent, false);
        ProductsAdapter.ProductViewHolder viewHolder = new ProductsAdapter.ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ProductViewHolder holder, int position) {
        holder.listItemProductView.setText(mDataset.get(position));
        holder.button_delete.setOnClickListener(view -> {
            mDataset.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView listItemProductView;
        ImageButton button_delete;

        public ProductViewHolder(View itemView) {
            super(itemView);
            listItemProductView = itemView.findViewById(R.id.product_item);
            button_delete = itemView.findViewById(R.id.delete_button);
        }
    }
}