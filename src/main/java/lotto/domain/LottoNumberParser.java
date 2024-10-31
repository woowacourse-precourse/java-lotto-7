package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class LottoNumberParser {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String WRONG_DELIMITER = ".*[./].*";

    public static List<Number> parse(String numbers) {
        validateEmptyLottoNumbers(numbers);
        validateDelimiter(numbers);

        List<String> splitNumbers = paresNumbers(numbers);
        validateLottoSize(splitNumbers);

        List<Number> lottoNumbers = new ArrayList<>();

        for (String number : splitNumbers) {
            lottoNumbers.add(Number.from(number));
        }

        return lottoNumbers;
    }

    private static List<String> paresNumbers(String numbers) {
        return List.of(numbers.split(LOTTO_NUMBER_DELIMITER));
    }

    private static void validateEmptyLottoNumbers(String numbers) {
        if (numbers == null || numbers.isBlank()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_EMPTY_NUMBER);
        }
    }

    private static void validateDelimiter(String numbers) {
        if (!numbers.contains(LOTTO_NUMBER_DELIMITER) || numbers.matches(WRONG_DELIMITER)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_WRONG_DELIMITER);
        }
    }

    private static void validateLottoSize(List<String> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_SIZE);
        }
    }
}
