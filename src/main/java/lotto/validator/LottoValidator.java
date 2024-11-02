package lotto.validator;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.util.Errors;
import lotto.util.InputParser;
import lotto.util.MessageParser;
import lotto.util.Regex;
import org.assertj.core.util.VisibleForTesting;

public class LottoValidator extends Validator {
    private final String lotto;

    public LottoValidator(String lotto) {
        this.lotto = lotto;
    }

    public void validate() {
        validateNotNull();
        validateNotEmpty();
        validateWholeNumber();
        validateList();
    }

    @VisibleForTesting
    void validateNotNull() {
        if (lotto == null) {
            throw new IllegalArgumentException(Errors.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    @VisibleForTesting
    void validateNotEmpty() {
        if (lotto.isBlank()) {
            throw new IllegalArgumentException(Errors.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    @VisibleForTesting
    void validateWholeNumber() {
        if (Arrays.stream(lotto.split(Regex.COMMA.getValue()))
                .anyMatch(number -> !Pattern.matches("-?\\d+", number))) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        }
    }

    @VisibleForTesting
    void validateList() {
        try {
            InputParser.parseList(lotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageParser.combineMessages(Errors.NOT_A_LONG.getMessage()));
        }
    }
}
