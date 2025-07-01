package com.nextjsvietnam;

import java.time.LocalDate;

public class DateUtils {
    public long dateDiff(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)){
            return date1.datesUntil(date2).count();
        }
        return date2.datesUntil(date1).count();
    }

    public long currentWeek(LocalDate d) {
        // Week Number = floor((days since January 1st + starting weekday offset) / 7) + 1
        LocalDate firstDayOfYear = LocalDate.of(d.getYear(), 1, 1);
        var daysSinceFirstDayOfYear = firstDayOfYear.datesUntil(d).count();
        var startWeekDayOffset = (long)firstDayOfYear.getDayOfWeek().getValue();
        return (long)Math.floor((double)(daysSinceFirstDayOfYear + startWeekDayOffset)/7) + 1;
     }
}
