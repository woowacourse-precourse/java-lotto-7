package lotto.model;

import java.util.List;
import lotto.validator.InputValidator.BonusNumberValidator;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        BonusNumberValidator.checkDuplicate(winningNumbers, bonusNumber); // 생성 시 중복 검사
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
