package com.example.tablaregistroscovid

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tablaregistroscovid.repository.RepositoryPerson
import kotlinx.android.synthetic.main.register_fragment.*
import java.util.*

class RegisterFragment : Fragment() {

    /**
     * Instancia de los datos obtenido de la BD
     */
    private val generalViewModel: RegisterViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(RepositoryPerson(this.requireActivity().application))
        ).get(RegisterViewModel::class.java)
    }

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSaveData.setOnClickListener {

            val sexVadation = generoTextView.text.toString()
            var sex = ESex.MASCULINO

            if (sexVadation == ESex.MASCULINO.name || sexVadation == ESex.FEMENINO.name) {

                sex = ESex.valueOf(sexVadation)
            } else {
                Toast.makeText(this.context, "$sexVadation No es válido", Toast.LENGTH_SHORT).show()
            }

            generalViewModel.saveData(

                DataModelTable(
                    idPerson = null,
                    firstName = nameTextView.text.toString(),
                    lastName = lastNameTextView.text.toString(),
                    date = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()),
                    state = EState.VACUNADO,
                    age = ageTextView.text.toString().toInt().unaryPlus(),
                    sex = sex,
                    picture = R.drawable.ic_add_circle_24
                )
            )

            findNavController().navigateUp()
        }

        btnCancelData.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}