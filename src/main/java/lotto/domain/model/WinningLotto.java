package lotto.domain.model;

import lotto.util.ErrorMessages;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers winningNumbers;
    private final int bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers.getNumbers(), bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER);
        }
    }

    public LottoRank calculateRank(LottoNumbers userLottoNumbers) {
        long matchCount = userLottoNumbers.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();

        boolean bonusMatch = userLottoNumbers.getNumbers().contains(bonusNumber);

        return LottoRank.valueOf((int) matchCount, bonusMatch);
    }
}