package lotto.domain.vo;

import static lotto.common.exception.ErrorMessages.BLANK_NOT_ALLOWED;

import lotto.domain.entity.Lotto;
import lotto.domain.validator.InputValidator;
import lotto.domain.validator.NonBlankValidator;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {
    private static final InputValidator nonBlankValidator = new NonBlankValidator();
    private static final String COMMA = ",";

    private WinningLotto(String inputNumbers, BonusNumber bonus) {
        this(Lotto.from(inputNumbers), bonus);
    }

    public static WinningLotto of(String inputNumbers, String inputBonus) {
        validate(inputNumbers);
        return new WinningLotto(inputNumbers, new BonusNumber(inputBonus));
    }

    private static void validate(String input) {
        nonBlankValidator.validate(input);
        validateEndingComma(input);
    }

    private static void validateEndingComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }
}
