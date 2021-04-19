package com.example.tablaregistroscovid

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.tablaregistroscovid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

   /* var listGeneralCovid: List<DataModelTable> = listOf(
        DataModelTable(id = "1", firsName = "Angélica", lastName = "Liliana", date = "Hoy", state = "Aliviada"),
        DataModelTable(id = "2", firsName = "Angélica", lastName = "Liliana", date = "Hoy", state = "Aliviada"),
        DataModelTable(id = "3", firsName = "Angélica", lastName = "Liliana", date = "Hoy", state = "Aliviada")
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)
        //recyclerViewTable()
        //setSupportActionBar(findViewById(R.id.toolbar))

        //findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
          //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()
        //}
    }

override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

   /* fun recyclerViewTable(){
        binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
        val adapter = TableAdapter(listGeneralCovid)
        binding.recyclerViewList.adapter = adapter
    }*/


}