package es.montanus.dates;

class MonthImpl implements Month {

    static final int JANUARY = 1;
    static final int FEBRUARY = 2;
    static final int MARCH = 3;
    static final int APRIL = 4;
    static final int MAY = 5;
    static final int JUNE = 6;
    static final int JULY = 7;
    static final int AUGUST = 8;
    static final int SEPTEMBER = 9;
    static final int OCTOBER = 10;
    static final int NOVEMBER = 11;
    static final int DECEMBER = 12;

    private static final int MONTHS_IN_A_YEAR = 12;

    private final int number;
    private final Year year;

    MonthImpl(int number, Year year) {
        if (number <= 0 || number > MONTHS_IN_A_YEAR) throw new IllegalMonthNumberException();

        this.number = number;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MonthImpl)) return false;

        MonthImpl that = (MonthImpl)obj;
        return this.number == that.number && this.year.equals(that.year);
    }

    @Override
    public int hashCode() {
        return number + MONTHS_IN_A_YEAR * year.hashCode();
    }

    public int getLastDayOfMonth() {
        int result = 0;
        switch (number) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                result = 31;
                break;
            case FEBRUARY:
                result = year.isLeap() ? 29 : 28;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                result = 30;
                break;
        }
        return result;
    }
}
