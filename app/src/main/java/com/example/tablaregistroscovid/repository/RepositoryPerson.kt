package com.example.tablaregistroscovid.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tablaregistroscovid.DataModelTable
import com.example.tablaregistroscovid.dataTranferObject.PersonParser
import com.example.tablaregistroscovid.sqlite.DatabasePerson

class RepositoryPerson(application: Application) {

    private val personDatabase: DatabasePerson? = DatabasePerson.getInstance(application)

    fun getAllPersons(): LiveData<List<DataModelTable>> {
        return PersonParser.getPersonList(personDatabase!!.getPersonDao().getAllPerson())
    }

    fun savePerson(person: DataModelTable) {
        Thread {
            personDatabase?.getPersonDao()!!.setPerson(PersonParser.convertObjectToBD(person))
        }.start()
    }
}