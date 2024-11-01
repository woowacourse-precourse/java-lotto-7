package lotto.domain.vo;

import static lotto.common.exception.ErrorMessages.*;

import lotto.domain.entity.Lotto;
import lotto.domain.validator.InputValidator;
import lotto.domain.validator.NonBlankValidator;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {
    private static final InputValidator nonBlankValidator = new NonBlankValidator();
    private static final String COMMA = ",";

    public static WinningLotto of(String inputNumbers, String inputBonus) {
        validate(inputNumbers);
        Lotto lotto = Lotto.from(inputNumbers);
        BonusNumber bonus = new BonusNumber(inputBonus);
        validateDuplicate(lotto, bonus);
        return new WinningLotto(lotto, bonus);
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

    private static void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        LottoNumbers lottoNumbers = lotto.createLottoNumbers();
        if (lottoNumbers.hasNumber(bonusNumber.number())) {
            throw new IllegalArgumentException(DUPLICATED.toString());
        }
    }
}
