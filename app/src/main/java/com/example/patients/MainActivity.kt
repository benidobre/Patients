package com.example.patients

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProviders.of(this).get(MyViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.load()
        viewModel.patitents.observe(this, Observer { list ->
            val namesList: List<String> = list.map { it.first_name }
            val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, namesList)
            list_view.adapter = adapter
        })

        list_view.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, position.toString(), Toast.LENGTH_LONG).show()
            val item = viewModel.patitents.value!![position]
            startActivity(DetailActivity.newIntent(this).putExtra("pat", item))
        }


    }
}
