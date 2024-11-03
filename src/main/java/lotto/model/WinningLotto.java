package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class WinningLotto {

    private static final int WINNING_LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        validate(lottoNumbers, bonusLottoNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.countMatch(lotto.getLottoNumbers());
    }

    public boolean isBonusNumberMatches(Lotto lotto) {
        return lotto.containsLottoNumber(bonusLottoNumber);
    }

    private void validate(LottoNumbers numbers, LottoNumber bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateNumbers(LottoNumbers numbers) {
        if (!numbers.hasSize(WINNING_LOTTO_NUMBER_SIZE)) {
            String detail = String.format("당첨 로또 번호의 개수는 %d 개여야 합니다.", WINNING_LOTTO_NUMBER_SIZE);
            throw LottoNumberInvalidException.lottoNumberSize(detail);
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
