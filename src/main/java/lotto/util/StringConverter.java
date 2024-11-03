package lotto.util;

import static lotto.util.StringValidator.validateNotBlank;

public class StringConverter {
    private StringConverter() {
    }

    public static int toInt(String value) {
        validateNotBlank(value);

        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 값입니다.");
        }
    }

    public static String trim(String text) {
        validateNotBlank(text);
        return text.trim();
    }

}
