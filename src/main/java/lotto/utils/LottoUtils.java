package lotto.utils;

import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static List<String> divideBySeparator(String separator, String s) {
        return Arrays.stream(s.split(separator)).toList();
    }

    public static List<Integer> convertToIntegerList(List<String> list) {
        List<Integer> result = null;

        try {
            result = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            LottoException.throwNumberFormatException(ExceptionMessage.ONLY_INTEGER);
        }

        return result;
    }

    public static boolean isDigit(String s) {
        return s.matches("[0-9]");
    }

    public static boolean hasDuplicateNumber(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);

        return set.size() != list.size();
    }
}
