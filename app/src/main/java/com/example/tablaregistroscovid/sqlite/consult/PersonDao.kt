package com.example.tablaregistroscovid.sqlite.consult

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tablaregistroscovid.sqlite.entities.PersonEntity

@Dao
interface PersonDao {

    @Query("SELECT * FROM PersonEntity WHERE PERSON_ID =:personId")
    fun getAllPersonById(personId: Int): LiveData<PersonEntity>

    @Query("SELECT * FROM PersonEntity")
    fun getAllPerson(): LiveData<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPerson(personEntity: PersonEntity): Long
}