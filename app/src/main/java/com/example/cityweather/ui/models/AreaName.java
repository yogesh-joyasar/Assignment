package com.example.cityweather.ui.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "area_name")
public class AreaName {

    @Ignore
    public AreaName(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public AreaName(String value){
        this.value = value;
    }


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "area_name")
    @SerializedName("value")
    @Expose
    public String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}