package com.example.weather.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmad Shubita on 12/2/19.
 **/

public class Weather {

    @Expose
    @SerializedName("dt")
    private Long date;

    @Expose
    @SerializedName("main")
    private Main main;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Weather that = (Weather) object;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return main != null ? !main.equals(that.main) : that.main != null;
    }

    @Override
    public int hashCode() {
        int result = main != null ? main.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


}