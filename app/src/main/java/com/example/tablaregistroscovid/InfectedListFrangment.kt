package com.example.tablaregistroscovid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InfectedListFrangment : Fragment() {

    var listGeneralCovid: List<DataModelTable> = listOf(
        DataModelTable(idPerson = 1, firstName = "Angélica", lastName = "Liliana", date = "Hoy", state = EState.VACUNADO, age = 10, picture = -1, sex = ESex.FEMENINO),
        DataModelTable(idPerson = 2, firstName = "Angélica", lastName = "Liliana", date = "Hoy", state = EState.SANO, age = 20, picture = -1, sex = ESex.MASCULINO),
        DataModelTable(idPerson = 3, firstName = "Angélica", lastName = "Liliana", date = "Hoy", state = EState.CONTAGIADO, age = 30, picture = -1, sex = ESex.FEMENINO)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()

        addRegisterButton.setOnClickListener {

            //val action = Infected
            findNavController().navigate(R.id.action_FirstFragment_to_registerFragment)
        }
    }

    /**
    Función que inicializa el recycler dentro del cuál se encontrarán los elementos
     */
    fun initRecycler(){
        listRecycler.adapter = TableAdapter(listGeneralCovid)
        listRecycler.layoutManager = LinearLayoutManager(this.context)
    }
}