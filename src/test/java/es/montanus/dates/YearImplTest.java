package es.montanus.dates;

import junit.framework.TestCase;

public class YearImplTest extends TestCase {
    private YearImpl year;

    @Override public void setUp() {
        year = new YearImpl(2018);
    }

    public void testYearsWithSameNumberAreEqual() {
        YearImpl sameYear = new YearImpl(2018);
        assertTrue(year.equals(sameYear));
    }

    public void testYearsWithDifferentNumberAreDifferent() {
        YearImpl differentYear = new YearImpl(2017);
        assertFalse(year.equals(differentYear));
    }

    public void testYearDoesNotEqualNull() {
        assertFalse(year.equals(null));
    }

    public void testYearDoesNotEqualNonYearObjects() {
        assertFalse(year.equals(new Object()));
    }

    public void testEqualYearsHaveSameHashcode() {
        YearImpl sameYear = new YearImpl(2018);
        assertEquals(year.hashCode(), sameYear.hashCode());
    }

    public void testLeapYear() {
        YearImpl leapYear = new YearImpl(2016);
        assertTrue(leapYear.isLeap());
    }

    public void testNonLeapYear() {
        assertFalse(year.isLeap());
    }

    public void testRareNonLeapYear() {
        YearImpl rareNonLeapYear = new YearImpl(1900);
        assertFalse(rareNonLeapYear.isLeap());
    }

    public void testRareLeapYear() {
        YearImpl rareLeapYear = new YearImpl(2000);
        assertTrue(rareLeapYear.isLeap());
    }
}
