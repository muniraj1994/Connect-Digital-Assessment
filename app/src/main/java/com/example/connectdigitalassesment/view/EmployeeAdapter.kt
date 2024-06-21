package com.example.connectdigitalassesment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectdigitalassesment.R
import com.example.connectdigitalassesment.model.Employee

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.bind(employee)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val salaryTextView: TextView = itemView.findViewById(R.id.salaryTextView)
        private val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)

        fun bind(employee: Employee) {
            nameTextView.text = employee.employeeName
            salaryTextView.text = employee.employeeSalary.toString()
            ageTextView.text = employee.employeeAge.toString()
        }
    }
}
