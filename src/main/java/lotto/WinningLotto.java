package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;


    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        LottoValidator.validateNumbers(winningNumbers.getNumbers());  // 당첨 번호 유효성 검사
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers.getNumbers());  // 보너스 번호 유효성 검사
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return winningNumbers.getNumbers();
    }
}
