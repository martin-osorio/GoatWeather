package com.example.goat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity_layout)

        if (ForecastSingleton.getInstance().isValid) {
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter =
                HourlyDatumAdapter(ForecastSingleton.getInstance().forecast.hourly?.data!!)
            recyclerView.adapter = adapter
        }
    }
}