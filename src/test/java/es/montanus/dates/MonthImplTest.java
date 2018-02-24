package es.montanus.dates;

import junit.framework.TestCase;

public class MonthImplTest extends TestCase {

    private static final String NOT_THROWN = "Expected IllegalMonthNumberException was not thrown";

    public void testInvalidMonthNumber_NegativeValue() {
        try {
            new MonthImpl(-1, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(IllegalMonthNumberException.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testInvalidMonthNumber_Zero() {
        try {
            new MonthImpl(0, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(IllegalMonthNumberException.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testInvalidMonthNumber_BiggerThan12() {
        try {
            new MonthImpl(13, new FakeYear());
            fail(NOT_THROWN);
        }
        catch (IllegalMonthNumberException e) {
            assertEquals(IllegalMonthNumberException.ILLEGAL_MONTH_NUMBER_MSG, e.getMessage());
        }
    }

    public void testMonthEquality() {
        final Year year = new FakeYear(false, true);

        Month month = new MonthImpl(MonthImpl.FEBRUARY, year);
        Month sameMonth = new MonthImpl(MonthImpl.FEBRUARY, year);
        Month differentMonth = new MonthImpl(MonthImpl.MARCH, year);

        assertFalse(month.equals(null));
        assertTrue(month.equals(sameMonth));
        assertFalse(month.equals(differentMonth));
        assertFalse(month.equals(new Object()));
    }

    public void testEqualMonthsHaveSameHashCode() {
        final int yearNumber = 2018;

        Month month = new MonthImpl(MonthImpl.FEBRUARY, new YearImpl(yearNumber));
        Month sameMonth = new MonthImpl(MonthImpl.FEBRUARY, new YearImpl(yearNumber));
        assertEquals(month.hashCode(), sameMonth.hashCode());
    }

    public void testLastDaysOfMonth_NonLeapYear() {

        final Year year = new FakeYear(false);
        assertEquals(31, getLastDayOfMonth(MonthImpl.JANUARY, year));
        assertEquals(28, getLastDayOfMonth(MonthImpl.FEBRUARY, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.MARCH, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.APRIL, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.MAY, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.JUNE, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.JULY, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.AUGUST, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.SEPTEMBER, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.OCTOBER, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.NOVEMBER, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.DECEMBER, year));
    }

    public void testLastDaysOfMonth_LeapYear() {
        final Year year = new FakeYear(true);
        assertEquals(31, getLastDayOfMonth(MonthImpl.JANUARY, year));
        assertEquals(29, getLastDayOfMonth(MonthImpl.FEBRUARY, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.MARCH, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.APRIL, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.MAY, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.JUNE, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.JULY, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.AUGUST, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.SEPTEMBER, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.OCTOBER, year));
        assertEquals(30, getLastDayOfMonth(MonthImpl.NOVEMBER, year));
        assertEquals(31, getLastDayOfMonth(MonthImpl.DECEMBER, year));
    }

    private int getLastDayOfMonth(int monthNumber, Year year) {
        Month month = new MonthImpl(monthNumber, year);
        return month.getLastDayOfMonth();
    }
}