package com.example.android.tesis;

/**
 * Created by rjsan on 5/13/2018.
 */

public class ModelItinerario {

    private String route;

    private String day;

    private int puesto;

    private String schedule;

    public ModelItinerario(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public String getDay() {
        return day;
    }

    public int getPuesto() {
        return puesto;
    }

    public String getSchedule() {
        return schedule;
    }
}
