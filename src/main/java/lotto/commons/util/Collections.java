package lotto.commons.util;

public class Collections {
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
}
