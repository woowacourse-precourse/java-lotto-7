package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.util.constant.Separator;

import java.util.Arrays;
import java.util.List;

public class Convertor {
    public static Long stringToLong(String input) {
        try {
            return Long.parseLong(input);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_LIMIT.getMessage());
        }
    }
    public static List<Integer> splitByList(String input) {
        return Arrays.stream(input.split(Separator.COMMA.getSeparator()))
                .map(Convertor::stringToInt)
                .toList();
    }
    public static int stringToInt(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(ErrorMessage.WITHIN_RANGE.getMessage());
        }
    }
}
