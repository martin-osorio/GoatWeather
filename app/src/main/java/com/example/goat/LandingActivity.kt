package com.example.goat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.goat.model.Forecast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.text.SimpleDateFormat
import java.util.*


class LandingActivity : AppCompatActivity(), OnForecastResultInterface {

    private lateinit var viewModel: LandingActivityViewModel
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_activity_layout)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        viewModel = ViewModelProvider(this).get(LandingActivityViewModel::class.java)
        viewModel.setFusedLocationProviderClient(fusedLocationProviderClient)
        viewModel.setOnForecastResultInterface(this)
        viewModel.checkPermissions(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        viewModel.onRequestPermissionsResult(this, requestCode, grantResults)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onForecastResult(forecast: Forecast) {
        val today = forecast.daily?.data?.get(0)

        val date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat.getDateInstance()
        val formattedDate = dateFormat.format(date)
        val timeFormat = SimpleDateFormat.getTimeInstance()
        val formattedTime = timeFormat.format(date)

        findViewById<TextView>(R.id.time).text = "At: $formattedTime"
        findViewById<TextView>(R.id.date).text = "On: $formattedDate"
        findViewById<TextView>(R.id.high).text = "High of: " + today?.temperatureHigh.toString()
        findViewById<TextView>(R.id.low).text = "Low of: " + today?.temperatureLow.toString()
        findViewById<TextView>(R.id.icon_text).text = today?.icon.toString()

        findViewById<View>(R.id.root).setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}