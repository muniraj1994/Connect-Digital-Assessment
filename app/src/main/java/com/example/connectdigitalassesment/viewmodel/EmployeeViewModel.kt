package com.example.connectdigitalassesment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.example.connectdigitalassesment.model.Employee
import com.example.connectdigitalassesment.model.EmployeeModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.connectdigitalassesment.repository.EmployeeRepository

class EmployeeViewModel : ViewModel() {

    private val repository = EmployeeRepository()

    private val _employees = MutableLiveData<List<Employee>>()
    val employees: LiveData<List<Employee>> get() = _employees

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    init {
        fetchEmployees()
    }

    private fun fetchEmployees() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response: EmployeeModel = withContext(Dispatchers.IO) {
                    repository.getResponses()
                }
                if (response.status == "success") {
                    val posts: List<Employee> = response.data
                    posts.let {
                        withContext(Dispatchers.Main) {
                            _employees.value = it
                        }
                     }
                } else {
                    //TODO
                }
            } catch (e: Exception) {
                Log.d("Exception: ", " $e")
            } finally {
                _isLoading.value = false
            }
        }
    }

    }
