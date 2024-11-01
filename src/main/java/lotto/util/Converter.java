package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException.NotAllowCharacterInputException;

public class Converter {

    private static final String DELIMITER = ",";

    private Converter() {
    }

    public static List<Integer> convertToIntgerList(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(number -> getNumber(number.trim()))
                .toList();
    }

    private static Integer getNumber(final String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NotAllowCharacterInputException();
        }
    }
}
