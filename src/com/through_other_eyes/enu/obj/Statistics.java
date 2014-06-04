/*
 * Copyright (C) 2014 through.other.eyes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.through_other_eyes.enu.obj;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author jplatzer
 */
public class Statistics {

    private HashMap<String, Country> countries;

    private double currentPopulation;
    private double currentGDP;

    private GameTimeThread gameTimeThread;

    public Statistics(HashMap<String, Country> countries) {
        this.countries = countries;
        gameTimeThread = new GameTimeThread();
    }

    public void calculate() throws InterruptedException {
        calculatePopulation();
        calculateGDP();
    }

    private void calculatePopulation() {
        double population = 0;
        for (Country country : countries.values()) {
            if (country.isEuMember()) {
                population += country.getPopulation();
            }
        }
        currentPopulation = population;
    }

    private void calculateGDP() throws InterruptedException {
        double gdp = 0;
        for (Country country : countries.values()) {
            if (country.isEuMember()) {
                gdp += country.getGdp();
            }
        }
        currentGDP = gdp;
    }

    public void startGameTimeThread() {
        gameTimeThread.start();
    }

    public double getPopulation() {
        return currentPopulation;
    }

    public double getGDP() {
        return currentGDP;
    }

    public double getGDPpC() {
        return currentGDP / currentPopulation;
    }

    public HashMap<String, Country> getCountries() {
        return countries;
    }
    
    public Calendar getGameTime()
    {
        return gameTimeThread.getGameTime();
    }
}
