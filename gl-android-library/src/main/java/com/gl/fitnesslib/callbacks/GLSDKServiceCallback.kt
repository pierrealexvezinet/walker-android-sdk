package com.gl.fitnesslib.callbacks

/**
 * Created by pierre-alexandrevezinet on 19/06/2017.
 */


interface GLSDKServiceCallback {

    /**
     * Return a response when the service has started.
     */
    fun onServiceStart(response : Any)

    /**
     * Return a response when the service has failed.
     */
    fun onServiceFailed(response : Any)

    /**
     * Return a response when the service has succeeded.
     */
    fun onServiceSuccess(response : Any)
}