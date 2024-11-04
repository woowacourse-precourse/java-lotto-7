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

    private void validate(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        validateLottoNumbers(lottoNumbers);
        validateBonusLottoNumber(lottoNumbers, bonusLottoNumber);
    }

    private void validateLottoNumbers(LottoNumbers lottoNumbers) {
        if (!lottoNumbers.hasSize(WINNING_LOTTO_NUMBER_SIZE)) {
            String detail = String.format("당첨 로또 번호의 개수는 %d 개여야 합니다.", WINNING_LOTTO_NUMBER_SIZE);
            throw LottoNumberInvalidException.lottoNumberSize(detail);
        }
        if (!lottoNumbers.hasUniqueElements()) {
            throw LottoNumberInvalidException.lottoNumberDuplicate();
        }
    }

    private void validateBonusLottoNumber(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        if (lottoNumbers.contains(bonusLottoNumber)) {
            throw LottoNumberInvalidException.bonusNumberDuplicate();
        }
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoNumbers=" + lottoNumbers +
                ", bonusLottoNumber=" + bonusLottoNumber +
                '}';
    }
}
