package com.example.goat;

import com.example.goat.model.Forecast;

public class ForecastSingleton {
    private static ForecastSingleton instance = null;
    private Forecast forecast;

    private ForecastSingleton() {};

    public static ForecastSingleton getInstance() {
        if (instance == null) {
            instance = new ForecastSingleton();
        }
        return(instance);
    }

    public boolean isValid() {
        return getInstance().forecast != null;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
