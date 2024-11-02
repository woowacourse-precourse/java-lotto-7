package lotto.utils;

public class Decimals {
    public static double round(double value, int decimalPlaces) {
        if (decimalPlaces < 1) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, decimalPlaces);
        long roundedValue = Math.round(value * factor);
        return (double) roundedValue / factor;
    }
}
