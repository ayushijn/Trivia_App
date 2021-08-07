package com.example.triviaapp.activities.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.triviaapp.activities.models.UserRecord;

import interfaces.RecordDao;

@Database(entities = {UserRecord.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RecordDao recordDao();
    private static AppDatabase appDb;

    public static AppDatabase getInstance(Context context) {
        if (null == appDb) {
            appDb = buildDatabaseInstance(context);
        }
        return appDb;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,"ALL_NOTES")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        appDb = null;
    }
    public AppDatabase getAppDatabase() {
        return appDb;
    }

}
