package lotto.model;

import validator.LottoValidator;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        LottoValidator.validateLottoNumbers(winningNumbers);
        LottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank determineRank(Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        boolean bonusMatch = lotto.containsBonusNumber(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }
}