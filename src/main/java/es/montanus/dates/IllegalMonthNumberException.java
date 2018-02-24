package es.montanus.dates;

class IllegalMonthNumberException extends IllegalArgumentException {
    static final String ILLEGAL_MONTH_NUMBER_MSG = "MonthImpl number must be between 1 and 12.";

    IllegalMonthNumberException() {
        super(ILLEGAL_MONTH_NUMBER_MSG);
    }
}
