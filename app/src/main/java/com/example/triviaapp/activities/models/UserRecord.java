package com.example.triviaapp.activities.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserRecord implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Ans_1")
    private String aone;

    @ColumnInfo(name = "Ans_2")
    private String atwo;

    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "Time")
    private String  time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAone() {
        return aone;
    }

    public void setAone(String aone) {
        this.aone = aone;
    }

    public String getAtwo() {
        return atwo;
    }

    public void setAtwo(String atwo) {
        this.atwo = atwo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}