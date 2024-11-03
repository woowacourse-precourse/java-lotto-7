package lotto.domain;

import lotto.validator.LotteryValidator;

import java.util.List;

public class Lottery {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public Lottery(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(List<Integer> lottoNums, int bonusNumber) {
        LotteryValidator.validateValueRange(bonusNumber);
        LotteryValidator.validateDuplicate(lottoNums, bonusNumber);
    }
    public Lotto getWinningLotto() {return winningLotto;}
    public int getBonusNumber() {return bonusNumber;}
}
