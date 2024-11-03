package lotto.domain;

import lotto.validator.LotteryValidator;

import java.util.List;

public class Lottery {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Lottery(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void validate(List<Integer> lottoNums, int bonusNumber) {
        LotteryValidator.validateValueRange(bonusNumber);
        LotteryValidator.validateDuplicate(lottoNums, bonusNumber);
    }
    public List<Integer> getWinningNumbers() {return winningNumbers;}
    public int getBonusNumber() {return bonusNumber;}
}
