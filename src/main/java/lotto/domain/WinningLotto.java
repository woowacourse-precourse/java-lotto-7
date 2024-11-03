package lotto.domain;

import lotto.validator.BonusNumberValidator;

import java.util.List;

public class WinningLotto {

  private final Lotto winningNumbers;
  private final int bonusNumber;

  public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
    this.winningNumbers = new Lotto(winningNumbers);
    BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  public Rank calculateRank(Lotto lotto) {
    int matchCount = lotto.countMatchingNumbers(winningNumbers);
    boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
    return Rank.getRank(matchCount, bonusMatch);
  }
}
