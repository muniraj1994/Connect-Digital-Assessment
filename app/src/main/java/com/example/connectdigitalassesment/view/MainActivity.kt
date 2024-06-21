package com.example.connectdigitalassesment.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectdigitalassesment.viewmodel.EmployeeViewModel
import com.example.connectdigitalassesment.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EmployeeAdapter
    private lateinit var emptyTextView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]

        progressBar = findViewById(R.id.progressBar)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EmployeeAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.employees.observe(this) { employees ->
            employees?.let {
                recyclerView.visibility = if (it.isNotEmpty()) View.VISIBLE else View.GONE
                progressBar.visibility = View.GONE
                adapter = EmployeeAdapter(it)
                recyclerView.adapter = adapter
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}
