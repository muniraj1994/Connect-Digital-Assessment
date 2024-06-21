package com.example.connectdigitalassesment.repository

import com.example.connectdigitalassesment.model.EmployeeModel
import com.example.connectdigitalassesment.retrofit.RetrofitClient
import com.example.connectdigitalassesment.retrofit.ApiInterface

class EmployeeRepository {
    private val apiInterface: ApiInterface = RetrofitClient.apiInterface
    suspend fun getResponses(): EmployeeModel {
        return apiInterface.getEmployees()

    }
}
