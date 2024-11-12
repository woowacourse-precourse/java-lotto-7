package lotto;

import lotto.Message.ErrorMessage;
import lotto.model.BonusNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<Integer> parseToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Utils::parseToInt)
                .collect(Collectors.toList());
    }

    public static int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.toString());
        }
    }
}
