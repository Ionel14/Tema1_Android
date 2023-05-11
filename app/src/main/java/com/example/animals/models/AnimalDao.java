package com.example.animals.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnimalDao {
    @Query("Select *From Animals")
    public List<Animal> getAllAnimals();

    @Insert
    public void addAnimal(Animal animal);

    @Delete
    public void deleteAnimal(Animal animal);

    @Update
    public void updateAnimal(Animal animal);

    @Query("Select *From Animals where name Like :name")
    public Animal getAnimal(String name);
}
