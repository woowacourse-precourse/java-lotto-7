package lotto.model.lotto_result;

import java.util.List;

public class DrawNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    DrawNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
