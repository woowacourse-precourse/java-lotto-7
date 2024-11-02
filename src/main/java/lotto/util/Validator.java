package lotto.util;

import java.util.List;

public class Validator {
    public static boolean isDuplicate(List<?> items) {
        return items.stream().distinct().count() != items.size();
    }
}