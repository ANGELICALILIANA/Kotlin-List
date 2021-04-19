package com.example.tablaregistroscovid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tablaregistroscovid.repository.RepositoryPerson
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InfectedListFrangment : Fragment() {

    var listGeneralCovid: List<DataModelTable> = listOf(
        DataModelTable(
            idPerson = 1,
            firstName = "Angélica",
            lastName = "Liliana",
            date = "Hoy",
            state = EState.VACUNADO,
            age = 10,
            picture = -1,
            sex = ESex.FEMENINO
        ),
        DataModelTable(
            idPerson = 2,
            firstName = "Angélica",
            lastName = "Liliana",
            date = "Hoy",
            state = EState.SANO,
            age = 20,
            picture = -1,
            sex = ESex.MASCULINO
        ),
        DataModelTable(
            idPerson = 3,
            firstName = "Angélica",
            lastName = "Liliana",
            date = "Hoy",
            state = EState.CONTAGIADO,
            age = 30,
            picture = -1,
            sex = ESex.FEMENINO
        )
    )

    private val generalViewModel: RegisterViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(RepositoryPerson(this.requireActivity().application))
        ).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generalViewModel.personList.observe(viewLifecycleOwner, Observer { personsData ->

            initRecycler(personsData)

        })

        addRegisterButton.setOnClickListener {

            //val action = Infected
            findNavController().navigate(R.id.action_FirstFragment_to_registerFragment)
        }
    }

    /**
    Función que inicializa el recycler dentro del cuál se encontrarán los elementos
     */
    fun initRecycler(listPersons: List<DataModelTable>) {
        listRecycler.adapter = TableAdapter(listPersons)
        listRecycler.layoutManager = LinearLayoutManager(this.context)
    }
}