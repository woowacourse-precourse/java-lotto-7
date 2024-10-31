package lotto.utils;

public class Decimals {
    public static double round(double value, int decimalPlaces) {
        long factor = (long) Math.pow(10, decimalPlaces);
        long roundedValue = Math.round(value * factor);
        return (double) roundedValue / factor;
    }
}
