package com.example.animals.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Animal.class, version = 1)
public abstract class AnimalDatabase extends RoomDatabase{

    public abstract AnimalDao AnimalDao();
    private static volatile AnimalDatabase INSTANCE;

    public static AnimalDatabase getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (AnimalDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(),
                                    AnimalDatabase.class, "DB_NAME")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
