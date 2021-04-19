package com.example.tablaregistroscovid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tablaregistroscovid.repository.RepositoryPerson

class ViewModelFactory(private val repositoryInstance: RepositoryPerson) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RepositoryPerson::class.java)
            .newInstance(repositoryInstance)
    }
}