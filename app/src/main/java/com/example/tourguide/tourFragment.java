package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
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

public class tourFragment extends Fragment {

    public ArrayList<baseModel> cardList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tourist_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        RecyclerView recycler=view.findViewById(R.id.recycler_view);
        RecycleAdapter adapter=new RecycleAdapter(this,cardList);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
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
        cardList.add(new baseModel(R.string.tour_1,R.drawable.tour1,"geo:0,0?q=Meesapulimala"));
        cardList.add(new baseModel(R.string.tour_2,R.drawable.tour2,"geo:0,0?q=Ernakulam National park"));
        cardList.add(new baseModel(R.string.tour_3,R.drawable.tour3,"geo:0,0?q=Matupetty Dam"));
    }


}
