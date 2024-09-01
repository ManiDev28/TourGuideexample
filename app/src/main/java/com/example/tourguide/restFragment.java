package com.example.tourguide;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class restFragment extends Fragment {

    public ArrayList<baseModel> cardList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.restaurant_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        RecyclerView recycler=view.findViewById(R.id.recycler_view);
        RecycleAdapter adapter=new RecycleAdapter(this,cardList);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
        //onClickListener for recycler

        adapter.setOnClickListener(new RecycleAdapter.OnClickListener() {
            @Override
            public void onClick(int position, baseModel model) {
                Uri gmmIntentUri = Uri.parse(model.getLink());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                try {
                    startActivity(mapIntent);
                } catch (Exception e) {
                    Toast.makeText(getContext(),"There is no supporting Application", Toast.LENGTH_SHORT).show();
                }
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void initData(){
        cardList.add(new baseModel(R.string.resort1,R.drawable.blanket_hotel4,"geo:10.037489942372977,77.0466606307274?z=70"));
        cardList.add(new baseModel(R.string.resort2,R.drawable.hotel_hillview,"geo:10.00993304850397, 77.04159255792051?z=70"));
    }


}