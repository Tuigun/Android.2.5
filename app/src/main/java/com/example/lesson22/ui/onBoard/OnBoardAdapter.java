package com.example.lesson22.ui.onBoard;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson22.R;
import com.example.lesson22.databinding.ItemForViewPagerBinding;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.ViewHolder> {
    int[] image = {
            R.drawable.g, R.drawable.g, R.drawable.g};

    public OnBoardAdapter() {

    }

    public interface OnStartListener{
         void onClick();
         void onClicker();
    }
    private OnStartListener setOnClickListener;

    public void setOnStart(OnStartListener onStart){
        this.setOnClickListener=onStart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_view_pager
                , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageVie;
        Button btnSkip,btnStart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVie = itemView.findViewById(R.id.image_view);
            btnSkip = itemView.findViewById(R.id.btnSkip);
            btnStart = itemView.findViewById(R.id.btnStart);
        }


        public void onBind(int position) {
            imageVie.setImageResource(image[position]);
            if (position==2){
                btnSkip.setVisibility(View.GONE);
            }
            if (position!=2){
                btnStart.setVisibility(View.GONE);
            }
            btnSkip.setOnClickListener(v -> {
              setOnClickListener.onClicker();
            });
            btnStart.setOnClickListener(v -> {
                setOnClickListener.onClick();
            });
        }


    }
}
