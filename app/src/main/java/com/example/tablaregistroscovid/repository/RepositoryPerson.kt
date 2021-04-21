package com.example.tablaregistroscovid.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tablaregistroscovid.DataModelTable
import com.example.tablaregistroscovid.dataTranferObject.PersonParser
import com.example.tablaregistroscovid.sqlite.DatabasePerson
import com.example.tablaregistroscovid.sqlite.consult.PersonDao
import com.example.tablaregistroscovid.sqlite.entities.PersonEntity

/**
 * Clase que accede directamente a la DB
 */
class RepositoryPerson(application: Application) {

    private val personDatabase: DatabasePerson? = DatabasePerson.getInstance(application)

    /**
     * Función que obtiene los datos de la BD
     */
    fun getAllPersons(): LiveData<List<DataModelTable>> {

        val daoInstance: PersonDao = personDatabase!!.getPersonDao()
        val personsInBD: LiveData<List<PersonEntity>> = daoInstance.getAllPerson()
        return PersonParser.getPersonList(personsInBD)
    }

    /**
     * Función que guarda los datos de la DB
     */
    fun savePerson(person: DataModelTable) {
        Thread {
            val daoInstance: PersonDao = personDatabase?.getPersonDao()!!
            val personParser: PersonEntity = PersonParser.convertObjectToBD(person)
            daoInstance.setPerson(personParser)
        }.start()
    }
}