package com.example.goat.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("time")
    @Expose
    var time: Int? = null

    @SerializedName("precipIntensity")
    @Expose
    var precipIntensity: Double? = null

    @SerializedName("precipIntensityError")
    @Expose
    var precipIntensityError: Double? = null

    @SerializedName("precipProbability")
    @Expose
    var precipProbability: Double? = null

    @SerializedName("precipType")
    @Expose
    var precipType: String? = null

    @SerializedName("summary")
    @Expose
    var summary: String? = null

    @SerializedName("icon")
    @Expose
    var icon: String? = null

    @SerializedName("temperature")
    @Expose
    var temperature: Double? = null

    @SerializedName("apparentTemperature")
    @Expose
    var apparentTemperature: Double? = null

    @SerializedName("dewPoint")
    @Expose
    var dewPoint: Double? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null

    @SerializedName("windSpeed")
    @Expose
    var windSpeed: Double? = null

    @SerializedName("windGust")
    @Expose
    var windGust: Double? = null

    @SerializedName("windBearing")
    @Expose
    var windBearing: Int? = null

    @SerializedName("cloudCover")
    @Expose
    var cloudCover: Double? = null

    @SerializedName("uvIndex")
    @Expose
    var uvIndex: Int? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Double? = null

    @SerializedName("ozone")
    @Expose
    var ozone: Double? = null

    @SerializedName("sunriseTime")
    @Expose
    var sunriseTime: Int? = null

    @SerializedName("sunsetTime")
    @Expose
    var sunsetTime: Int? = null

    @SerializedName("moonPhase")
    @Expose
    var moonPhase: Double? = null

    @SerializedName("precipIntensityMax")
    @Expose
    var precipIntensityMax: Double? = null

    @SerializedName("precipIntensityMaxTime")
    @Expose
    var precipIntensityMaxTime: Int? = null

    @SerializedName("temperatureHigh")
    @Expose
    var temperatureHigh: Double? = null

    @SerializedName("temperatureHighTime")
    @Expose
    var temperatureHighTime: Int? = null

    @SerializedName("temperatureLow")
    @Expose
    var temperatureLow: Double? = null

    @SerializedName("temperatureLowTime")
    @Expose
    var temperatureLowTime: Int? = null

    @SerializedName("apparentTemperatureHigh")
    @Expose
    var apparentTemperatureHigh: Double? = null

    @SerializedName("apparentTemperatureHighTime")
    @Expose
    var apparentTemperatureHighTime: Int? = null

    @SerializedName("apparentTemperatureLow")
    @Expose
    var apparentTemperatureLow: Double? = null

    @SerializedName("apparentTemperatureLowTime")
    @Expose
    var apparentTemperatureLowTime: Int? = null

    @SerializedName("windGustTime")
    @Expose
    var windGustTime: Int? = null

    @SerializedName("uvIndexTime")
    @Expose
    var uvIndexTime: Int? = null

    @SerializedName("temperatureMin")
    @Expose
    var temperatureMin: Double? = null

    @SerializedName("temperatureMinTime")
    @Expose
    var temperatureMinTime: Int? = null

    @SerializedName("temperatureMax")
    @Expose
    var temperatureMax: Double? = null

    @SerializedName("temperatureMaxTime")
    @Expose
    var temperatureMaxTime: Int? = null

    @SerializedName("apparentTemperatureMin")
    @Expose
    var apparentTemperatureMin: Double? = null

    @SerializedName("apparentTemperatureMinTime")
    @Expose
    var apparentTemperatureMinTime: Int? = null

    @SerializedName("apparentTemperatureMax")
    @Expose
    var apparentTemperatureMax: Double? = null

    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    var apparentTemperatureMaxTime: Int? = null
}
