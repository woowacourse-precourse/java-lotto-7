package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.util.Parser;
import lotto.validator.Validator;

public class Bonus {
    private final int number;

    private Bonus(int number) {
        this.number = number;
    }

    public static Bonus of(String input, Lotto winningLotto) {
        validate(input, winningLotto);
        return new Bonus(Integer.parseInt(input));
    }

    private static void validate(String input, Lotto winningLotto) {
        Validator.validateBlank(input, ErrorMessage.BLANK_BONUS_NUMBER);
        Validator.validateNumeric(input, ErrorMessage.NOT_NUMERIC_BONUS_NUMBER);
        int number = Parser.parseInt(input);
        Validator.validateNumberRange(number, ErrorMessage.OUT_RANGE_BONUS_NUMBER);
        validateDuplicate(number, winningLotto.getNumbers());
    }

    private static void validateDuplicate(int number, List<Integer> winningLotto) {
        if (winningLotto.contains(number)) {
            throw new LottoException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
