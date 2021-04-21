package com.example.tablaregistroscovid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        optionState()
    }

    /**
     *Función
     */
    fun optionState() {

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.planets_array,
            R.layout.spinner_text_view
        ).also {
            it.setDropDownViewResource(R.layout.spinner_text_view)
            stateSpinner.adapter = it
        }

        stateSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@DescriptionFragment.requireContext(),
                    "No hay Selección",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(
                    this@DescriptionFragment.requireContext(),
                    "Item Seleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}