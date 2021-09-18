package com.example.lesson22.ui.onBoard;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.lesson22.R;
import com.example.lesson22.databinding.ItemForViewPagerBinding;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.ViewHolder> {


    private int[] lottie = new int[]{
            R.raw.taxi, R.raw.animate_one, R.raw.animate_one};

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
        LottieAnimationView lottieAnimationView;
        Button btnStart;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lottieAnimationView = itemView.findViewById(R.id.lottie);
            btnStart = itemView.findViewById(R.id.btnStart);
//            lottieAnimationView.playAnimation();
        }


        public void onBind(int position) {
            lottieAnimationView.setAnimation(lottie[position]);
            if (position==2){
                btnStart.setVisibility(View.VISIBLE);
            }
            else {
                btnStart.setVisibility(View.GONE);
            }
            btnStart.setOnClickListener(v -> {
                setOnClickListener.onClick();
            });
        }


    }
}
