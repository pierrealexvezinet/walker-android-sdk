package com.gl.library.services.ws

import android.content.ContentValues.TAG
import android.os.Environment
import android.util.Log
import com.gl.fitnesslib.callbacks.GLSDKServiceCallback
import com.gl.fitnesslib.interfaces.IGLSDKService
import com.gl.fitnesslib.services.GLSDKServiceGenerator
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLConnection
import java.io.*
import java.util.*

/**
 * Created by pierre-alexandrevezinet on 19/06/2017.
 */

class GLSDKService {

    var jsonObject: JSONObject? = null
    var jsonData: String? = null
    var jsonArray: JSONArray? = null
    val GLSDKServiceCallback: GLSDKServiceCallback
    var baseUrl: String = ""
    var GLSDKServiceGenerator: GLSDKServiceGenerator

    /**
     * @param ULSDKServiceCallback
     *
     * @param
     */
    constructor(baseUrl: String, ULSDKServiceCallback: GLSDKServiceCallback) {
        this.GLSDKServiceCallback = ULSDKServiceCallback
        this.baseUrl = baseUrl
        GLSDKServiceGenerator = GLSDKServiceGenerator(baseUrl)
    }

    //****************************************************************************************//
    //*****************************GOOGLE FIT WS IMPLEMENTATION*******************************//
    //****************************************************************************************//

    /**
     * List all available datas sources

     * @param token
     * */

    fun getAllAvailableDatas(token: String) {

        val service = GLSDKServiceGenerator.createService(IGLSDKService::class.java, token)
        val call = service.getAllAvailableDatasources()
        call.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(_call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    try {
                        jsonData = response.body()!!.string()
                        jsonArray = JSONArray(jsonData)
                        GLSDKServiceCallback.onServiceSuccess(jsonArray as Any)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        GLSDKServiceCallback.onServiceFailed("GET ALL AVAILABLE DATAS SOURCES : " + jsonArray.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
                    } catch (e: IOException) {
                        GLSDKServiceCallback.onServiceFailed("GET ALL AVAILABLE DATAS SOURCES : " + jsonArray.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
                        e.printStackTrace()
                    }
                } else {
                    GLSDKServiceCallback.onServiceFailed(response.errorBody()!!.string() as Any)
                }
            }

            override fun onFailure(_call: Call<ResponseBody>, t: Throwable) {
                GLSDKServiceCallback.onServiceFailed("GET ALL AVAILABLE DATAS SOURCES :  STACKTRACE : " + " " + t.stackTrace.toString() + " MESSAGE :" + t.message)
            }

        })

    }

    /**
     * Login an user

     * @param login

    fun login(login: ULSDKLogin) {
    val service = GLSDKServiceGenerator.createServiceLessToken(IGLSDKService::class.java)
    val call = service.login(login)
    call.enqueue(object : Callback<ResponseBody> {

    override fun onResponse(_call: Call<ResponseBody>, response: Response<ResponseBody>) {

    if (response.isSuccessful) {

    try {
    jsonData = response.body()!!.string()
    jsonObject = JSONObject(jsonData)
    GLSDKServiceCallback.onServiceSuccess(jsonObject as Any)
    } catch (e: JSONException) {
    e.printStackTrace()
    jsonObject = JSONObject(response.errorBody()!!.string())
    GLSDKServiceCallback.onServiceFailed("LOGIN : " + jsonObject.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    } catch (e: IOException) {
    e.printStackTrace()
    GLSDKServiceCallback.onServiceFailed("LOGIN : " + jsonObject.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    }
    } else {
    GLSDKServiceCallback.onServiceFailed("LOGIN : " + response.errorBody()!!.string() as Any)
    }
    }

    override fun onFailure(_call: Call<ResponseBody>, t: Throwable) {
    GLSDKServiceCallback.onServiceFailed("LOGIN :  STACKTRACE : " + " " + t.stackTrace.toString() + " MESSAGE :" + t.message)
    }
    })
    } */

    /**
     * Delete profile

     * @param token

    fun deleteProfile(token: String, profileId: String) {

    val service = GLSDKServiceGenerator.createService(IGLSDKService::class.java, token)
    val call = service.deleteProfile(profileId)
    call.enqueue(object : Callback<ResponseBody> {

    override fun onResponse(_call: Call<ResponseBody>, response: Response<ResponseBody>) {
    if (response.isSuccessful) {
    try {
    jsonData = response.body()!!.string()
    jsonObject = JSONObject(jsonData)
    GLSDKServiceCallback.onServiceSuccess(jsonObject as Any)
    } catch (e: JSONException) {
    e.printStackTrace()
    GLSDKServiceCallback.onServiceFailed("DELETE PROFILE : " + jsonObject.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    } catch (e: IOException) {
    e.printStackTrace()
    GLSDKServiceCallback.onServiceFailed("DELETE PROFILE: " + jsonObject.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    }
    } else {
    GLSDKServiceCallback.onServiceFailed(response.errorBody()!!.string() as Any)
    }
    }

    override fun onFailure(_call: Call<ResponseBody>, t: Throwable) {
    GLSDKServiceCallback.onServiceFailed("DELETE PASSWORD :  STACKTRACE : " + " " + t.stackTrace.toString() + " MESSAGE :" + t.message)
    }

    })

    }*/

    /**
     * Retrieve one random question for the user

     * @param token
     * @param nbDay

    fun getQuestionByNbDay(token: String, nbDay: Number) {

    val service = GLSDKServiceGenerator.createService(IGLSDKService::class.java, token)
    val call = service.getQuestionByNbDay(nbDay)
    call.enqueue(object : Callback<ResponseBody> {

    override fun onResponse(_call: Call<ResponseBody>, response: Response<ResponseBody>) {
    if (response.isSuccessful) {
    try {
    jsonData = response.body()!!.string()
    jsonArray = JSONArray(jsonData)
    GLSDKServiceCallback.onServiceSuccess(jsonArray as Any)
    } catch (e: JSONException) {
    e.printStackTrace()
    GLSDKServiceCallback.onServiceFailed("GET QUESTIONS BY NB DAY : " + jsonArray.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    } catch (e: IOException) {
    e.printStackTrace()
    GLSDKServiceCallback.onServiceFailed("GET QUESTIONS BY NB DAY : " + jsonArray.toString() + " STACKTRACE : " + " " + e.stackTrace.toString() + " MESSAGE :" + e.message)
    }
    } else {
    GLSDKServiceCallback.onServiceFailed(response.errorBody()!!.string() as Any)
    }
    }

    override fun onFailure(_call: Call<ResponseBody>, t: Throwable) {
    GLSDKServiceCallback.onServiceFailed("GET QUESTIONS BY NB DAY :  STACKTRACE : " + " " + t.stackTrace.toString() + " MESSAGE :" + t.message)
    }

    })

    }  */
}

