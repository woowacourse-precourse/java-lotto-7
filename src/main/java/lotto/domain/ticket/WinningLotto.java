package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoRank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = winningNumbers.countMatch(userLotto);
        boolean hasBonusNumber = userLotto.contains(bonusNumber);
        return LottoRank.of(matchCount, hasBonusNumber);
    }
}