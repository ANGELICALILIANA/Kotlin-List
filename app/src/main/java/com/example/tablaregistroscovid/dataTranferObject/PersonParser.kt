package com.example.tablaregistroscovid.dataTranferObject

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tablaregistroscovid.ESex
import com.example.tablaregistroscovid.EState
import com.example.tablaregistroscovid.sqlite.entities.PersonEntity
import com.example.tablaregistroscovid.DataModelTable as DataModelTable1

object PersonParser {

    fun convertBDToObject(personEntity: PersonEntity): DataModelTable1 {

        return DataModelTable1(
            idPerson = personEntity.personId,
            firstName = personEntity.firstName,
            lastName = personEntity.lastName,
            date = personEntity.date,
            state = EState.valueOf(personEntity.state),
            age = personEntity.age,
            picture = personEntity.picture,
            sex = ESex.valueOf(personEntity.sex)
        )
    }

    fun convertObjectToBD(personObject: DataModelTable1): PersonEntity {

        return PersonEntity(
            //personId = personObject.idPerson,
            firstName = personObject.firstName,
            lastName = personObject.lastName,
            date = personObject.date,
            state = personObject.state.name,
            age = personObject.age,
            picture = personObject.picture,
            sex = personObject.sex.name
        )
    }

    fun getPersonList(personList: LiveData<List<PersonEntity>>): LiveData<List<DataModelTable1>> {
        return Transformations.map(personList) {
            it?.map { objectBD -> convertBDToObject(objectBD) }
        }
    }
}