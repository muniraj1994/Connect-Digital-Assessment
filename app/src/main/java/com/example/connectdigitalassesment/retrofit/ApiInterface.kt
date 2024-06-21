package com.example.connectdigitalassesment.retrofit

import com.example.connectdigitalassesment.model.EmployeeModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("employees")
    suspend fun getEmployees(): EmployeeModel

}