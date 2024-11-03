package lotto.front.parser;

import java.util.Arrays;
import java.util.List;
import lotto.global.exception.InvalidLottoNumberFormatException;

public class LottoNumbersParser {
    private static final String LOTTO_NUMBER_REGEX = "^-?\\d+(,-?\\d+)*$";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    public static List<Integer> parse(String drawnNumbers) {
        validate(drawnNumbers);

        try {
            return Arrays.stream(drawnNumbers.split(LOTTO_NUMBER_DELIMITER)).map(Integer::valueOf).toList();
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidLottoNumberFormatException();
        }
    }

    private static void validate(String lottoNumbers) {
        if (!lottoNumbers.matches(LOTTO_NUMBER_REGEX)) {
            throw new InvalidLottoNumberFormatException();
        }
    }
}
