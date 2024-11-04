package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_BONUS;

import lotto.vo.LottoNumber;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void validateDuplication(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.message());
        }
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = userLotto.countMatchingNumbers(winningNumbers);
        boolean hasBonusMatch = userLotto.contains(bonusNumber);

        return LottoRank.valueOf(matchCount, hasBonusMatch);
    }
}
