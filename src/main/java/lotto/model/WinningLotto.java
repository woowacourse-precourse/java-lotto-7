package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;

public class WinningLotto {

    private static final int NUMBER_SIZE = 6;

    private final LottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers numbers, LottoNumber bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return numbers.countMatch(lotto.getNumbers());
    }

    public boolean isBonusNumberMatches(Lotto lotto) {
        return lotto.containsLottoNumber(bonusNumber);
    }

    private void validate(LottoNumbers numbers, LottoNumber bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateNumbers(LottoNumbers numbers) {
        if (!numbers.hasSize(NUMBER_SIZE)) {
            throw LottoNumberInvalidException.lottoNumberSize();
        }
        if (!numbers.hasUniqueElements()) {
            throw LottoNumberInvalidException.lottoNumberDuplicate();
        }
    }

    private void validateBonusNumber(LottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw LottoNumberInvalidException.bonusNumberDuplicate();
        }
    }
}
