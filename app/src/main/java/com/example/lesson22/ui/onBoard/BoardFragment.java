package com.example.lesson22.ui.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.lesson22.R;
import com.example.lesson22.databinding.FragmentBoardBinding;
import com.example.lesson22.databinding.ItemForViewPagerBinding;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;


public class BoardFragment extends Fragment{

private OnBoardAdapter adapter ;
private FragmentBoardBinding boardBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager2 viewPager2=view.findViewById(R.id.view_pager);
        SpringDotsIndicator indicator=view.findViewById(R.id.spring_dots_indicator);
        adapter=new OnBoardAdapter();
        viewPager2.setAdapter(adapter);
        indicator.setViewPager2(viewPager2);
        ViewPager2.PageTransformer transformer;


        adapter.setOnStart(new OnBoardAdapter.OnStartListener() {
            @Override
            public void onClick() {
                NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigateUp();
            }

            @Override
            public void onClicker() {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);

            }
        });
    }
}