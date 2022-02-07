package com.example.goat

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.goat.model.Forecast
import com.google.android.gms.location.FusedLocationProviderClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LandingActivityViewModel : ViewModel() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var forecast: Forecast
    private lateinit var onForecastResultInterface: OnForecastResultInterface

    fun setFusedLocationProviderClient(fusedLocationProviderClient: FusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient
    }

    fun setOnForecastResultInterface(onForecastResultInterface: OnForecastResultInterface) {
        this.onForecastResultInterface = onForecastResultInterface
    }

    fun checkPermissions(landingActivity: Activity) {
        if (ContextCompat.checkSelfPermission(
                landingActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    landingActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    landingActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    1
                )
            } else {
                ActivityCompat.requestPermissions(
                    landingActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    1
                )
            }
        } else {
            getLastKnownLocation()
        }
    }

    fun onRequestPermissionsResult(
        context: Context,
        requestCode: Int,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if ((ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED)
                ) {
                    getLastKnownLocation()
                }
            } else {
                Toast.makeText(context, "Permission Denied: Do nothing!", Toast.LENGTH_SHORT).show()
            }
            return
        }
    }

    @SuppressLint("MissingPermission")
    //Permission has already been checked when this is called
    private fun getLastKnownLocation() {
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    onLocationObtained(location)
                }
            }
    }

    private fun onLocationObtained(location: Location) {
        Network.init().getForecast(location.latitude.toString(), location.longitude.toString())
            .enqueue(object : Callback<Forecast> {
                override fun onResponse(
                    call: Call<Forecast>?,
                    response: Response<Forecast>?
                ) {
                    if (response?.body() != null) {
                        forecast = response.body()!!
                        onForecastObtained()
                    }
                }

                override fun onFailure(call: Call<Forecast>?, t: Throwable?) {
                    Log.d("moltag", "onFailure: ")
                }
            })
    }

    private fun onForecastObtained() {
        ForecastSingleton.getInstance().forecast = forecast
        onForecastResultInterface.onForecastResult(ForecastSingleton.getInstance().forecast)
    }
}