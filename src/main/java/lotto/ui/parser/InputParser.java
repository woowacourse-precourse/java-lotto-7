package lotto.ui.parser;

import lotto.exception.LottoException;
import lotto.exception.LottoNumberExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static final String DELIMITER = ",";

    public List<Integer> inputToWinningNumbers(final String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(DELIMITER)).mapToInt(Integer::parseInt).boxed().toList();
        } catch (Exception e) {
            throw new LottoException(LottoNumberExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
