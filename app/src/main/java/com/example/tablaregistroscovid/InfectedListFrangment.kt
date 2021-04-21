package com.example.tablaregistroscovid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tablaregistroscovid.repository.RepositoryPerson
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * Clase donde se ejecuta el ciclo de vida para la primera vista, tabla de personas con un estado específico frente al Covid.
 */
class InfectedListFrangment : Fragment() {

    /**
     * Instancia de llamado a la DB
     */
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

            findNavController().navigate(R.id.action_FirstFragment_to_registerFragment)
        }
    }

    /**
    Función que inicializa el recycler dentro del cuál se encontrarán los elementos
     */
    fun initRecycler(listPersons: List<DataModelTable>) {

        listRecycler.adapter = TableAdapter(listPersons, object : TableAdapter.OnAdapterNotifier {

            override fun onItemSelected(personId: Int) {
                Toast.makeText(this@InfectedListFrangment.requireContext(), "Item Seleccionado ${personId}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
        listRecycler.layoutManager = LinearLayoutManager(this.context)
    }

}