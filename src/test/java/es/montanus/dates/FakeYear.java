package es.montanus.dates;

public class FakeYear implements Year {
    private final boolean leap;
    private final boolean equals;

    public FakeYear(boolean leap) {
        this(leap, true);
    }

    public FakeYear(boolean leap, boolean equals) {
        this.leap = leap;
        this.equals = equals;
    }

    public boolean isLeap() {
        return leap;
    }

    @Override public boolean equals(Object obj) {
        return equals;
    }
}
