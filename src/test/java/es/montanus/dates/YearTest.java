package es.montanus.dates;

import junit.framework.TestCase;

public class YearTest extends TestCase {
    private Year year;

    @Override public void setUp() {
        year = new Year(2018);
    }

    public void testYearsWithSameNumberAreEqual() {
        Year sameYear = new Year(2018);
        assertTrue(year.equals(sameYear));
    }

    public void testYearsWithDifferentNumberAreDifferent() {
        Year differentYear = new Year(2017);
        assertFalse(year.equals(differentYear));
    }

    public void testYearDoesNotEqualNull() {
        assertFalse(year.equals(null));
    }

    public void testYearDoesNotEqualNonYearObjects() {
        assertFalse(year.equals(new Object()));
    }

    public void testEqualYearsHaveSameHashcode() {
        Year sameYear = new Year(2018);
        assertEquals(year.hashCode(), sameYear.hashCode());
    }

    public void testLeapYear() {
        Year leapYear = new Year(2016);
        assertTrue(leapYear.isLeap());
    }

    public void testNonLeapYear() {
        assertFalse(year.isLeap());
    }

    public void testRareNonLeapYear() {
        Year rareNonLeapYear = new Year(1900);
        assertFalse(rareNonLeapYear.isLeap());
    }

    public void testRareLeapYear() {
        Year rareLeapYear = new Year(2000);
        assertTrue(rareLeapYear.isLeap());
    }
}
