package com.example.animals.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animals.R;
import com.example.animals.models.Animal;
import com.example.animals.models.Continent;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Animal> animals;

    public AnimalsAdapter(List<Animal> animals){this.animals = animals;}

    @Override
    public int getItemViewType(int position) {
        return animals.get(position).getContinent().getKey();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AnimalViewHolder viewHolder;
        View view = null;
        switch (Continent.values()[viewType]) {
            case Europe: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_eu, parent, false);
                break;
            }
           case Africa: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_africa, parent, false);
                break;
            }
            case Asia:
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_asia, parent, false);
                break;
            }
            case America:
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_america, parent, false);
                break;
            }
            case Australia:
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_australia, parent, false);
                break;
            }
        }
        viewHolder = new AnimalViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof AnimalViewHolder) {
            Animal animal = (Animal) animals.get(position);

            ((AnimalViewHolder)holder).bind(animal);
        }
        Log.e("Adapter", "onBindViewHolder; position=" + position);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder {

        TextView animalNameTextView;
        TextView animalContinentTextView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalNameTextView = itemView.findViewById(R.id.animal_name);
            animalContinentTextView = itemView.findViewById(R.id.animal_continent);
        }

        public void bind(Animal animal) {
            animalNameTextView.setText(animal.getName());
            animalContinentTextView.setText(animal.getContinent().toString());
        }
    }

}
