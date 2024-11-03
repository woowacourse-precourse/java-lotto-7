package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.RegexUtils;

import java.util.HashSet;
import java.util.Set;

public abstract class Validator implements LottoConstants {


    public Boolean nonEmpty(String viewMessage, String input) {
        if (!input.isEmpty()) {
            return true;
        }

        throw new RetryInputException(viewMessage, input);
    }

    public Boolean isNumeric(String viewMessage, String input) {
        if (RegexUtils.isNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_NUMERIC.getMessage());
    }

    public Boolean isPositiveNumeric(String viewMessage, String input) {
        if (RegexUtils.isPositiveNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_POSITIVE_NUMERIC.getMessage());
    }

    public Boolean hasNoDuplicates(String viewMessage, Set<Integer> winningNumbers) {
        Set<Integer> numbers = new HashSet<>(winningNumbers);

        if (numbers.size() == winningNumbers.size()) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.HAS_DUPLICATE_NUMBER.getMessage());
    }

    public Boolean isLottoNumberRange(String viewMessage, int number) {
        if (number < MIN_BALL || number > MAX_BALL) {

            throw new RetryInputException(viewMessage, ErrorMessages.IS_OUT_OF_LOTTO_NUMBER.getMessage());
        }
        return true;
    }


    protected abstract Boolean validate(String request);
}
