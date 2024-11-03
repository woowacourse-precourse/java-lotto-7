package lotto.utils;

import static lotto.constants.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.List;

public class InputUtils {

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static List<Integer> convertToIntList(List<String> inputs) {
        return inputs.stream()
                .map(Integer::parseInt)
                .toList();
    }

}
