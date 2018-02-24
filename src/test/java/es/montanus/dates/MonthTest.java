package es.montanus.dates;

import junit.framework.TestCase;

public class MonthTest extends TestCase {

    public void testMonthEquality() {
        final int yearNumber = 2018;

        Month month = new Month(Month.FEBRUARY, new Year(yearNumber));
        Month sameMonth = new Month(Month.FEBRUARY, new Year(yearNumber));
        Month differentMonth = new Month(Month.MARCH, new Year(yearNumber));

        assertFalse(month.equals(null));
        assertTrue(month.equals(sameMonth));
        assertFalse(month.equals(differentMonth));
        assertFalse(month.equals(new Object()));
    }

    public void testEqualMonthsHaveSameHashCode() {
        final int yearNumber = 2018;

        Month month = new Month(Month.FEBRUARY, new Year(yearNumber));
        Month sameMonth = new Month(Month.FEBRUARY, new Year(yearNumber));
        assertEquals(month.hashCode(), sameMonth.hashCode());
    }

    public void testLastDaysOfMonth_NonLeapYear() {

        final Year year = new Year(2018);
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
        final Year year = new Year(2016);
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