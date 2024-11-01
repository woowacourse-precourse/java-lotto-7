package lotto.util;

import static lotto.util.StringValidator.validateNotBlank;

public class StringConverter {

    public static int toInt(String value) {
        validateNotBlank(value);
        return Integer.parseInt(value.trim());
    }

}
