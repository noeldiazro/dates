package es.montanus.dates;

class YearImpl implements Year {
    private final int number;

    YearImpl(int number) {
        this.number = number;
    }

    @Override public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof YearImpl)) return false;

        YearImpl that = (YearImpl)obj;
        return this.number == that.number;
    }

    @Override public int hashCode() {
        return number;
    }

    public boolean isLeap() {
        return isDivisibleBy(4) && (!isDivisibleBy(100) || isDivisibleBy(400));
    }

    private boolean isDivisibleBy(int factor) {
        return number % factor == 0;
    }
}
