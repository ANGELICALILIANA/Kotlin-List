package com.example.tablaregistroscovid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablaregistroscovid.databinding.TableCovid19Binding

class TableAdapter (val listGeneralCovid:List<DataModelTable>):RecyclerView.Adapter<TableAdapter.TableHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return TableHolder(layoutInflater.inflate(R.layout.table_covid19, parent, false))
    }

    override fun getItemCount(): Int = listGeneralCovid.size

    override fun onBindViewHolder(holder: TableHolder, position: Int) {
        holder.render(listGeneralCovid[position])
    }

    class TableHolder(val   view: View) : RecyclerView.ViewHolder(view) {

        val binding = TableCovid19Binding.bind(view)

        fun render(listGeneralCovid: DataModelTable) {
            binding.tvIdUsuario.text = listGeneralCovid.idPerson.toString()
            binding.tvFistName.text = "${listGeneralCovid.firstName} ${ listGeneralCovid.lastName }"
            binding.tvDate.text = listGeneralCovid.date
            binding.tvState.text = listGeneralCovid.state.name
        }
    }
}
