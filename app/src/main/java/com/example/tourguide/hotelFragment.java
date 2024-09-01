package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hotelFragment extends Fragment {

    public ArrayList<baseModel> cardList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hotel_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        RecyclerView recycler=view.findViewById(R.id.recycler_view);
        RecycleAdapter adapter=new RecycleAdapter(this, cardList);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
        adapter.setOnClickListener(new RecycleAdapter.OnClickListener() {
            @Override
            public void onClick(int position, baseModel model) {
                Uri gmmIntentUri = Uri.parse(model.getLink());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
                    mapIntent.setPackage("com.google.android.apps.maps");
                }
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
        cardList.add(new baseModel(R.string.rest1,R.drawable.resort1,"geo:10.051827273107534, 77.0572317239811?z=70"));
        cardList.add(new baseModel(R.string.rest2,R.drawable.resort2,"geo:10.070150197543912, 77.06112762398139?z=70"));
    }


}
