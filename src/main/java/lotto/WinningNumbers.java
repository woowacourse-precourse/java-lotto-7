package lotto;

import lotto.store.Lotto;

import java.util.List;

public class WinningNumbers extends Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int bonus;

    public WinningNumbers(List<Integer> winningNumber, int bonus) {
        super(winningNumber);
        if(winningNumber.contains(bonus))
            throw new IllegalArgumentException("당첨 번호에 bonus 번호가 이미 존재합니다.");
        if(isOutOfLottoRange(bonus))
            throw new IllegalArgumentException("bonus는 1~45 사이의 숫자여야 합니다.");

        this.bonus = bonus;
    }

    private boolean isOutOfLottoRange(int num) {
        return num < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < num ;
    }
}
