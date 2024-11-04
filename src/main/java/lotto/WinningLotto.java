package lotto;

import java.util.List;


public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;


    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        LottoValidator.validateNumbers(winningLotto.getNumbers());  // 당첨 번호 유효성 검사
        LottoValidator.validateBonusNumber(bonusNumber, winningLotto.getNumbers());  // 보너스 번호 유효성 검사
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    

    public int getBonusNumber() {
        return bonusNumber;
    }

    
    public List<Integer> getNumbers() {
        return winningLotto.getNumbers();
    }
}
