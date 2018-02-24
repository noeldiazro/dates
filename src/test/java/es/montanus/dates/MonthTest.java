package es.montanus.dates;

import junit.framework.TestCase;

public class MonthTest extends TestCase {

    private static final String NOT_THROWN = "Expected IllegalMonthNumberException was not thrown";

    public void testInvalidMonthNumber_NegativeValue() {
        try {
            new Month(-1, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(Month.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testInvalidMonthNumber_Zero() {
        try {
            new Month(0, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(Month.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testInvalidMonthNumber_BiggerThan12() {
        try {
            new Month(13, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(Month.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testMonthEquality() {
        final Year year = new FakeYear(false, true);

        Month month = new Month(Month.FEBRUARY, year);
        Month sameMonth = new Month(Month.FEBRUARY, year);
        Month differentMonth = new Month(Month.MARCH, year);

        assertFalse(month.equals(null));
        assertTrue(month.equals(sameMonth));
        assertFalse(month.equals(differentMonth));
        assertFalse(month.equals(new Object()));
    }

    public void testEqualMonthsHaveSameHashCode() {
        final int yearNumber = 2018;

        Month month = new Month(Month.FEBRUARY, new YearImpl(yearNumber));
        Month sameMonth = new Month(Month.FEBRUARY, new YearImpl(yearNumber));
        assertEquals(month.hashCode(), sameMonth.hashCode());
    }

    public void testLastDaysOfMonth_NonLeapYear() {

        final Year year = new FakeYear(false);
        assertEquals(31, getLastDayOfMonth(Month.JANUARY, year));
        assertEquals(28, getLastDayOfMonth(Month.FEBRUARY, year));
        assertEquals(31, getLastDayOfMonth(Month.MARCH, year));
        assertEquals(30, getLastDayOfMonth(Month.APRIL, year));
        assertEquals(31, getLastDayOfMonth(Month.MAY, year));
        assertEquals(30, getLastDayOfMonth(Month.JUNE, year));
        assertEquals(31, getLastDayOfMonth(Month.JULY, year));
        assertEquals(31, getLastDayOfMonth(Month.AUGUST, year));
        assertEquals(30, getLastDayOfMonth(Month.SEPTEMBER, year));
        assertEquals(31, getLastDayOfMonth(Month.OCTOBER, year));
        assertEquals(30, getLastDayOfMonth(Month.NOVEMBER, year));
        assertEquals(31, getLastDayOfMonth(Month.DECEMBER, year));
    }

    public void testLastDaysOfMonth_LeapYear() {
        final Year year = new FakeYear(true);
        assertEquals(31, getLastDayOfMonth(Month.JANUARY, year));
        assertEquals(29, getLastDayOfMonth(Month.FEBRUARY, year));
        assertEquals(31, getLastDayOfMonth(Month.MARCH, year));
        assertEquals(30, getLastDayOfMonth(Month.APRIL, year));
        assertEquals(31, getLastDayOfMonth(Month.MAY, year));
        assertEquals(30, getLastDayOfMonth(Month.JUNE, year));
        assertEquals(31, getLastDayOfMonth(Month.JULY, year));
        assertEquals(31, getLastDayOfMonth(Month.AUGUST, year));
        assertEquals(30, getLastDayOfMonth(Month.SEPTEMBER, year));
        assertEquals(31, getLastDayOfMonth(Month.OCTOBER, year));
        assertEquals(30, getLastDayOfMonth(Month.NOVEMBER, year));
        assertEquals(31, getLastDayOfMonth(Month.DECEMBER, year));
    }

    private int getLastDayOfMonth(int monthNumber, Year year) {
        return new Month(monthNumber, year).getLastDayOfMonth();
    }
}