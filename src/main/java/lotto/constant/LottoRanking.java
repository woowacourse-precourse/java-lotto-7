package lotto.constant;

import java.util.List;
import lotto.model.Lotto;

public enum LottoRanking {

    NONE_PRIZE(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 150000),
    SECOND_PRIZE(6, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private final int correctCount;
    private final boolean needBonusNumber;
    private final int prize;

    LottoRanking(int correctCount, boolean needBonusNumber, int prize) {
        this.correctCount = correctCount;
        this.needBonusNumber = needBonusNumber;
        this.prize = prize;
    }

    public LottoRanking checkLottoPrize(Lotto lotto, List<Integer> weeklyNumbers, int weeklyBonusNumber) {

        List<Integer> numbers = lotto.getNumbers();
        boolean hasBonusNumber = false;
        int count = 0;

        for (int number : numbers) {
            if (weeklyNumbers.contains(number)) {
                count++;
            }

            if(weeklyBonusNumber == number) {
                count++;
                hasBonusNumber = true;
            }
        }

        checkLottoRanking(count, hasBonusNumber);
    }

    public LottoRanking checkLottoRanking(int correctCount, boolean hasBonusNumber) {
        if(correctCount == FIFTH_PRIZE.correctCount) {
            return FIFTH_PRIZE;
        }

        if(correctCount == FOURTH_PRIZE.correctCount) {
            return FOURTH_PRIZE;
        }

        if(correctCount == THIRD_PRIZE.correctCount) {
            return THIRD_PRIZE;
        }

        if(correctCount == SECOND_PRIZE.correctCount && hasBonusNumber) {
            return SECOND_PRIZE;
        }

        if(correctCount == FIRST_PRIZE.correctCount && !hasBonusNumber) {
            return FIRST_PRIZE;
        }

        return NONE_PRIZE;
    }

    public int getPrize() {
        return prize;
    }
}
