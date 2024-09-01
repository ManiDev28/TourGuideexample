package com.example.tourguide;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private ArrayList <baseModel> cardList;
    private OnClickListener onClickListener;
    public RecycleAdapter(Fragment fragment,ArrayList<baseModel> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       baseModel items=cardList.get(position);
       int text1=cardList.get(position).getText1();
       int image1=cardList.get(position).getImage1();
       holder.setData(text1,image1);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position, items);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, baseModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       private TextView text1;
       private ImageView image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.name);
            image1=itemView.findViewById(R.id.image);
        }

        public void setData(int text,int id){
            text1.setText(text);
            image1.setImageResource(id);
        }

    }







}


