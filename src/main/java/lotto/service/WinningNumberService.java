package lotto.service;

import lotto.enums.ExceptionMessage;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.util.Converter;
import lotto.validator.BonusValidator;
import lotto.validator.LottoValidator;

public class WinningNumberService {
    private final LottoValidator lottoValidator;
    private final BonusValidator bonusValidator;

    public WinningNumberService(LottoValidator lottoValidator, BonusValidator bonusValidator) {
        this.lottoValidator = lottoValidator;
        this.bonusValidator = bonusValidator;
    }

    public Lotto createWinningLotto(String input) {
        lottoValidator.validate(input);
        return new Lotto(Converter.toNumberList(input));
    }

    public int createBonusNumber(String input) {
        bonusValidator.validate(input);
        return Integer.parseInt(input);
    }

    public WinningNumbers createWinningNumbers(Lotto winngLotto, int bonusNumber) {
        validateBonusNumber(winngLotto, bonusNumber);
        return new WinningNumbers(winngLotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
