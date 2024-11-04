package lotto.domain;

import static lotto.common.CollectionValidator.validateDuplicate;
import static lotto.common.CollectionValidator.validateRange;
import static lotto.common.CollectionValidator.validateSize;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoBuilder builder() {
        return new WinningLottoBuilder();
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.matchNumbers(winningNumbers);
        boolean isBonusMatch = lotto.matchBonusNumber(bonusNumber);
        return Rank.rank(matchCount, isBonusMatch);
    }

    public static class WinningLottoBuilder {
        private static final int MIN = 1;
        private static final int MAX = 45;

        private List<Integer> winningNumbers = new ArrayList<>();
        private Integer bonusNumber;

        public WinningLottoBuilder winningNumbers(List<Integer> winningNumbers) {
            validateSize(winningNumbers,WINNING_NUMBER_SIZE);
            validateRange(MIN, MAX,winningNumbers);
            validateDuplicate(winningNumbers);
            this.winningNumbers = new ArrayList<>(winningNumbers);
            return this;
        }

        public WinningLottoBuilder bonusNumber(Integer bonusNumber) {
            validateRange(MIN, MAX,bonusNumber);
            this.bonusNumber = bonusNumber;
            return this;
        }

        public WinningLotto build() {
            validateDuplicate(winningNumbers,bonusNumber);
            return new WinningLotto(this.winningNumbers, this.bonusNumber);
        }
    }
}
