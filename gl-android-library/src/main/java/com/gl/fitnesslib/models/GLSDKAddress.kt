package com.gl.fitnesslib.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by pierre-alexandrevezinet on 15/08/2017.
 *
 */


class GLSDKAddress {

    /**
     *  Return the street passed to the constructor.
     */
    @SerializedName("street")
    @Expose
    private val street: String

    /**
     * Return the postal code passed to the constructor.
     */
    @SerializedName("postalCode")
    @Expose
    private val postalCode: String

    /**
     * Return the city passed to the constructor.
     */
    @SerializedName("city")
    @Expose
    private val city: String

    /**
     * @param street
     **
     * @param postalCode
     **
     * @param city
     *
     */
    constructor(street: String, postalCode: String, city: String) {
        this.street=street
        this.postalCode=postalCode
        this.city=city
    }

}