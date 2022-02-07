package com.example.goat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goat.model.Datum
import java.text.SimpleDateFormat
import java.util.*

class HourlyDatumAdapter(private val data: List<Datum>) :
    RecyclerView.Adapter<HourlyDatumAdapter.HourlyDatumViewHolder>() {

    private val timeFormat = SimpleDateFormat("hh:mm:ss")

    class HourlyDatumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timeTextView: TextView = view.findViewById(R.id.hour)
        val tempTextView: TextView = view.findViewById(R.id.temp)
        val iconTextView: TextView = view.findViewById(R.id.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyDatumViewHolder {
        return HourlyDatumViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.hourly_datum_card_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HourlyDatumViewHolder, position: Int) {
        //I was unable to figure out why dates come out like this
        holder.timeTextView.text = "At: " + timeFormat.format(Date(data[position].time?.toLong()!!))
        holder.tempTextView.text = data[position].temperature.toString() + " F"
        holder.iconTextView.text = data[position].icon
    }

    override fun getItemCount(): Int {
        return data.size
    }
}