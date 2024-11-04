package lotto.domain.winning;

import static lotto.constant.Error.DUPLICATED_WINNING_BONUS_NUMBERS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Winning {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Winning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto lotto) {
        int hitCount = winningNumbers.countHit(lotto);
        boolean hitsBonusNumber = bonusNumber.hits(lotto);

        return Rank.of(hitCount, hitsBonusNumber);
    }

    private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> numbers = winningNumbers.getNumbers();
        int bonus = bonusNumber.getNumber();

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_BONUS_NUMBERS);
        }
    }
}
