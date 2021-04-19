package com.example.tablaregistroscovid.sqlite.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PersonEntity")

data class PersonEntity(
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "PERSON_ID")
        var personId: Int = 0,

        @NonNull
        @ColumnInfo(name = "FIRST_NAME")
        var firstName: String,

        @NonNull
        @ColumnInfo(name = "LAST_NAME")
        var lastName: String,

        @NonNull
        @ColumnInfo(name = "STATE")
        var state: String,

        @NonNull
        @ColumnInfo(name = "PICTURE")
        var picture: Int,

        @NonNull
        @ColumnInfo(name = "SEX")
        var sex: String,

        @NonNull
        @ColumnInfo(name = "AGE")
        var age: Int,

        @NonNull
        @ColumnInfo(name = "DATE")
        var date: String
)

