package lotto.domain;

import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number, WinningLotto winningLotto, LottoConfig lottoConfig) {
        validate(number, winningLotto, lottoConfig);
        this.number = number;
    }

    public static BonusNumber ofNumberAndWinningLottoAndConfig(
            int number, WinningLotto winningLotto, LottoConfig lottoConfig) {
        return new BonusNumber(number, winningLotto, lottoConfig);
    }

    private void validate(int number, WinningLotto winningLotto, LottoConfig lottoConfig) {
        validateDuplicationNumber(number, winningLotto);
        validateLessThanLottoNumberMax(number, lottoConfig);
        validateMoreThanLottoNumberMin(number, lottoConfig);
    }

    private void validateDuplicationNumber(int number, WinningLotto winningLotto) {
        if (winningLotto.isContains(number)) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    private void validateMoreThanLottoNumberMin(int number, LottoConfig lottoConfig) {
        if (number < lottoConfig.getLottoNumberMin()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int number, LottoConfig lottoConfig) {
        if (number > lottoConfig.getLottoNumberMax()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

    public boolean isMatch(int number) {
        return this.number == number;
    }
}
