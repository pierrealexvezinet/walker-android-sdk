package com.gl.fitnesslib.interfaces

import com.gl.fitnesslib.models.*
import okhttp3.ResponseBody
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

/**
 * Created by pierre-alexandrevezinet on 19/06/2017.
 */

interface IGLSDKService {

    //****************************************************************************************//
    //*****************************GOOGLE FITNESS WS IMPLEMENTATION*******************************//
    //****************************************************************************************//


    /**
     * @return
     */
    @GET("/users/me/dataSources")
    fun getAllAvailableDatasources(): Call<ResponseBody>


    /**
     * @param login
     * *
     * @return Login an user

    @POST("/api/auth/login")
    fun login(@Body login: ULSDKLogin): Call<ResponseBody>


   /** @return
     */
    @DELETE("/api/profile/{profileId}")
    fun deleteProfile(@Path("profileId") profileId: String): Call<ResponseBody>

    /**
     * Retrieve one random question for the user
     * @return
     */
    @GET("/api/questions/")
    fun getQuestionByNbDay(@Query("from") nbDay: Number): Call<ResponseBody>

     */



}