package com.example.tablaregistroscovid.sqlite

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tablaregistroscovid.sqlite.consult.PersonDao
import com.example.tablaregistroscovid.sqlite.entities.PersonEntity

@Database(
    entities = [
        PersonEntity::class
    ], version = 1
)

abstract class DatabasePerson : RoomDatabase() {

    abstract fun getPersonDao(): PersonDao

    companion object {
        private const val DATABASE_NAME = "DATA_BASE_PERSON"

        @Volatile
        private var INSTANCE: DatabasePerson? = null

        fun getInstance(context: Application): DatabasePerson? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabasePerson::class.java,
                    (DATABASE_NAME)
                ).build()
            }
            return INSTANCE
        }
    }
}