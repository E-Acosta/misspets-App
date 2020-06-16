package com.everacosta.misspets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.everacosta.misspets.models.PetsResponseData;

import java.util.ArrayList;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.ViewHolderPet>{
    ArrayList<PetsResponseData> PetsList;
    Context context;

    public PetsAdapter(ArrayList<PetsResponseData> petsList, Context context) {
        PetsList = petsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitempet,null,false);
        return new ViewHolderPet(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPet holder, int position) {
        holder.tvName.setText(PetsList.get(position).getName());
        holder.tvType.setText(PetsList.get(position).getType());
        holder.tvDir.setText(PetsList.get(position).getAddress());
        holder.tvDate.setText(PetsList.get(position).getDate());
        holder.tvPhone.setText(PetsList.get(position).getPhone());
        holder.tvDescription.setText(PetsList.get(position).getDescription());
        Glide.with(context)
                .load(PetsList.get(position).getImage())
                .into(holder.imPhoto);
    }

    @Override
    public int getItemCount() {
        return PetsList.size();
    }

    public class ViewHolderPet extends RecyclerView.ViewHolder {
        TextView tvName,tvType,tvDir,tvDate,tvPhone,tvDescription;
        ImageView imPhoto;
        ConstraintLayout parent;
        public ViewHolderPet(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvPetName);
            tvType=itemView.findViewById(R.id.tvPetType);
            tvDir=itemView.findViewById(R.id.tvPetDir);
            tvDate=itemView.findViewById(R.id.tvPetDate);
            tvPhone=itemView.findViewById(R.id.tvPetPhone);
            tvDescription=itemView.findViewById(R.id.tvPetDescription);
            imPhoto=itemView.findViewById(R.id.ivPhotoPet);
            parent=itemView.findViewById(R.id.parent_layout);
        }
    }
}
