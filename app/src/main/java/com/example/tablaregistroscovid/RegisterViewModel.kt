package com.example.tablaregistroscovid

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tablaregistroscovid.repository.RepositoryPerson
import kotlinx.coroutines.launch

class RegisterViewModel(private val repositoryPerson: RepositoryPerson) : ViewModel() {

    private var _personList: LiveData<List<DataModelTable>> = repositoryPerson.getAllPersons()
    var personList: LiveData<List<DataModelTable>> = _personList

    fun initPersonObserver() {

        viewModelScope.launch {

            repositoryPerson.getAllPersons()
        }

    }

    fun saveData(person: DataModelTable) {
        viewModelScope.launch {
            repositoryPerson.savePerson(person)
        }
    }

}
