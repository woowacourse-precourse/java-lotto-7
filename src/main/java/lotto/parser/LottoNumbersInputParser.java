package lotto.parser;

import lotto.domain.LottoGenerator;
import lotto.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_NOT_DIGIT;

public class LottoNumbersInputParser {
    private static final String DELIMITER = ",";

    private LottoNumbersInputParser() {}

    private static class LottoNumbersInputParserHolder {
        private static final LottoNumbersInputParser INSTANCE = new LottoNumbersInputParser();
    }

    public static LottoNumbersInputParser getInstance() {
        return LottoNumbersInputParserHolder.INSTANCE;
    }

    public List<Integer> parse(String input) {
        String[] lottoNumbers = input.split(DELIMITER);

        return mapInteger(lottoNumbers);
    }

    private List<Integer> mapInteger(String[] lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_DIGIT.getMessage());
        }
    }
}
