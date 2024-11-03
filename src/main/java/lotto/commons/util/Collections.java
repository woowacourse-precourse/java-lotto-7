package lotto.commons.util;

import java.math.BigDecimal;
import java.util.function.Function;

public class Collections {

    private Collections() {}

    public static <T> String joinToString(Iterable<T> list) {
        return Collections.joinToString(list, "");
    }

    public static <T> String joinToString(Iterable<T> list, String separator) {
        return Collections.joinToString(list, separator, "" ,"");
    }

    public static <T> String joinToString(Iterable<T> list, String separator, String prefix, String suffix) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        int count = 0;
        for (T element : list) {
            if (++count > 1) {
                builder.append(separator);
            }
            builder.append(element.toString());
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> BigDecimal sumOf(Iterable<T> list, Function<T, BigDecimal> func) {
        BigDecimal sum = BigDecimal.ZERO;
        for (T element : list) {
            sum = sum.add(func.apply(element));
        }
        return sum;
    }
}
