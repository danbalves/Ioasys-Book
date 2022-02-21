package com.example.ioasysbooks.data_remote.service

import com.example.ioasysbooks.data_remote.model.BooksListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookService {

    @GET("books")
    suspend fun getBooksService(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int,
    ):
            Response<BooksListResponse>


    @GET("books")
    suspend fun getSearchBookService(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int,
        @Query("title") title: String
    ):
            Response<BooksListResponse>
}