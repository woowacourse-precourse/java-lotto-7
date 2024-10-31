package lotto.entity;

import java.util.List;

public class LottoMachine {
    private final Purchase purchase;
    private final WinningNumbers winningNumbers;

    public LottoMachine(int paymentAmount, List<Integer> numbers, int bonusNumber) {
        this.purchase = new Purchase(paymentAmount);
        this.winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }
}
