package lotto.domain;

public class WinningNumbers {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto numbers, int bonusNumber) {
        this.lotto = numbers;
        this.bonusNumber = bonusNumber;
    }

}