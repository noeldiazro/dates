package es.montanus.dates;

class Year {
    private int number;

    Year(int number) {
        this.number = number;
    }

    @Override public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Year))
            return false;

        Year that = (Year)obj;
        return this.number == that.number;
    }

    @Override public int hashCode() {
        return number;
    }

    boolean isLeap() {
        return isDivisibleBy(4) && (!isDivisibleBy(100) || isDivisibleBy(400));
    }

    private boolean isDivisibleBy(int factor) {
        return number % factor == 0;
    }
}
