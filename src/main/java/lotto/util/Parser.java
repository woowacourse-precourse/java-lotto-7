package lotto.util;

import java.util.*;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.StringConstant.*;


public class Parser {

    public List<Integer> ParseWinningNumber(String number) {

        List<Integer> result = new ArrayList<>();
        String[] numbers = number.split(NUMBER_DELIMITER);

        for (String num : numbers) {
            int value = stringToInt(num.trim());
            result.add(value);
        }

        return result;
    }

    private static int stringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_FORMAT.getMessage(), e);
        }
    }
}
