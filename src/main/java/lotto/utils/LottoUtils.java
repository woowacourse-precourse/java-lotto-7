package lotto.utils;

import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;

public class LottoUtils {

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static int parseInt(String s) {
        int result = 0;

        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            LottoException.throwNumberFormatException(ExceptionMessage.ONLY_INTEGER);
        }

        return result;
    }

    public static boolean isDigit(String s) {
        return s.matches("[0-9]");
    }

}
