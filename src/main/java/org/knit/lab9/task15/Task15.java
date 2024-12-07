package org.knit.lab9.task15;

public class Task15 {
    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {
            System.out.println(season.getSeasonName() + ": " + season.getType() + ", типичный праздник - " +
                    season.getHoliday());
        }
    }
}
