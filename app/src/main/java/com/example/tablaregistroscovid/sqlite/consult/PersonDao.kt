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

    // @Query("INSERT INTO PersonEntity (personId = :personEntity., firstName, lastName, state, picture, sex, age, date)")
    //fun setPerson(personEntity: PersonEntity): LiveData<List<PersonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPerson(personEntity: PersonEntity): Long

    /*@Query("SELECT * FROM " + PersonEntity.TABLE_NAME + " WHERE " + PersonEntity.IS_IN_DETAILS +" =:isSelectedForDetails")
    fun getMoveDetailsSelected(isSelectedForDetails: Boolean = true): LiveData<MovieEntity>

    @Query("SELECT MAX(${PersonEntity.LOCAL_MOVE_ID}) FROM " + PersonEntity.TABLE_NAME)
    fun getLargestId(): Int
*/
}