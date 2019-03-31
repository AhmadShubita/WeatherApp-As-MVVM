package com.example.weather.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Main {

    @Expose
    @SerializedName("temp_min")
    private Double tempMin;

    @Expose
    @SerializedName("temp_max")
    private Double tempMax;

    @Expose
    @SerializedName("pressure")
    private Double pressure;

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Main that = (Main) object;
        if (tempMax != null ? !tempMax.equals(that.tempMax) : that.tempMax != null) return false;
        return tempMin != null ? !tempMin.equals(that.tempMin) : that.tempMin != null;
    }

    @Override
    public int hashCode() {
        int result = tempMax != null ? tempMax.hashCode() : 0;
        result = 31 * result + (tempMin != null ? tempMin.hashCode() : 0);
        return result;
    }


}