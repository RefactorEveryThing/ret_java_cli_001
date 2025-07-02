package com.nextjsvietnam;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {
    @Test
    @DisplayName("TC1: Same Date")
    void SameDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2025, 1, 1);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(0, dateUtils.dateDiff(d1, d2));
    }

    @Test
    @DisplayName("TC2: 1st date less than 2nd date")
    void firstDateLessThanSecondDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2024, 12, 31);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(1, dateUtils.dateDiff(d1, d2));
    }

    @Test
    @DisplayName("TC3: 1st date greater than 2nd date")
    void firstDateGreaterThanSecondDateTestCase() {
        var dateUtils = new DateUtils();
        var d1 = LocalDate.of(2025, 1, 31);
        var d2 = LocalDate.of(2025, 1, 1);
        assertEquals(30, dateUtils.dateDiff(d1, d2));
    }

    @Test
    @DisplayName("TC1: Week27")
    void week27Test() {
        var dateUtils = new DateUtils();
        var today = LocalDate.of(2025, 7, 2);
        assertEquals(27, dateUtils.currentWeek(today));
    }

    @Test
    @DisplayName("TC1: Assumption Sample")
    void assumptionSampleTest() {
        System.out.println(System.getProperty("ENV"));
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        assertEquals("DEV", System.getProperty("ENV"));
    }

    @DisplayName("TC1: Generate a number from specific range")
    @RepeatedTest(
            value = 50,
            name = "Repeating {displayName} {currentRepetition}/{totalRepetitions}"
    )

    void generateNumberTest() {
        int start = 50, end = 100;
        Random random = new Random();
        var randomNumber = random.nextInt(50, end + 1);
        assertTrue( randomNumber >= start && randomNumber <= end);
    }


    @Nested
    class ExampleNestedTestOrGroupTests {
        @DisplayName("Parameter Tests")
        @ParameterizedTest(name = "{displayName} with str={arguments}")
        @ValueSource(strings = {"a", "b", "c"})
        void parametersTest(String str) {
            assertFalse(str.isBlank());
        }

        @DisplayName("MethodSource")
        @ParameterizedTest()
        @MethodSource("phoneNumberList")
        void methodSourceTest(String str) {
            assertFalse(str.isEmpty());
        }

        private static List<String> phoneNumberList(){
            return Arrays.asList("012345678", "123456789");
        }

        @DisplayName("CsvFileSource")
        @ParameterizedTest()
        @CsvFileSource(resources = "/examples.csv", numLinesToSkip = 1)
        void csvFileSourceTest(String input, String expected) {
            String newValue = input.toUpperCase();
            assertEquals(newValue, expected);
        }
    }

    @Disabled("This test is currently failing and needs fixing.")
    @Test
    void failingTest() {
        fail("This test should not be executed.");
    }
}