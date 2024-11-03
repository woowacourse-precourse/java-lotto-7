package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.global.ErrorMessage;

public class Extractor {

    private static final String DELIMITER = ",";

    public Extractor() {}

    public List<Integer> extractLottoNumber(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER)).map(s -> Integer.parseInt(s.trim())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_LOTTO_NUMBER);
        }
    }
}
