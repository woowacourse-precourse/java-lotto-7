package lotto.parser;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_NOT_DIGIT;

public class LottoNumbersInputParser {
    private static final String DELIMITER = ",";

    private static LottoNumbersInputParser instance;

    private LottoNumbersInputParser() {
    }

    public static LottoNumbersInputParser getInstance() {
        if (instance == null) {
            instance = new LottoNumbersInputParser();
        }

        return instance;
    }

    public List<Integer> parse(String input) {
        String[] lottoNumbers = input.split(DELIMITER);

        return mapIntegerList(lottoNumbers);
    }

    private List<Integer> mapIntegerList(String[] lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_DIGIT.getMessage());
        }
    }
}
