package com.example.cityweather.ui.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "area_name")
data class AreaName(
    @PrimaryKey(autoGenerate = true)
    private val id: Int,
    @ColumnInfo(name = "area_name")
    @SerializedName("value")
    @Expose var value: String
): Serializable{

    override fun toString(): String = value
}