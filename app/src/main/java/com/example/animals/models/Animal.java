package com.example.animals.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Animals")
public class Animal {
    @PrimaryKey(autoGenerate = true)
    public Integer animalId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "continent")
    private String continent;

    public Animal(String name, String continent)
    {
        this.name = name;
        this.continent = continent;
    }
    public Animal(){}

    public String getName(){
        return name;
    }

    public String getContinent(){
        return continent;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContinent(String cont){
        continent = cont;
    }



}
