package com.nextjsvietnam;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {
    @Test
    void SameDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2025, 1, 1);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(0, dateUtils.dateDiff(d1, d2));
    }

    @Test
    void firstDateLessThanSecondDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2024, 12, 31);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(1, dateUtils.dateDiff(d1, d2));
    }

    @Test
    void firstDateGreaterThanSecondDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2025, 1, 31);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(30, dateUtils.dateDiff(d1, d2));
    }

    @Test
    void week27Test() {
        var dateUtils = new DateUtils();
        var today = LocalDate.now();
        assertEquals(27, dateUtils.currentWeek(today));
    }
}