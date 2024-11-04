package lotto.domain;

import static lotto.common.CollectionValidator.validateDuplicate;
import static lotto.common.CollectionValidator.validateSize;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int WINNING_NUMBER_SIZE = 6;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        validateSize(winningNumbers,WINNING_NUMBER_SIZE);
        validateDuplicate(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, Integer bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.matchNumbers(winningNumbers);
        boolean isBonusMatch = lotto.matchBonusNumber(bonusNumber);
        return Rank.rank(matchCount, isBonusMatch);
    }
}
