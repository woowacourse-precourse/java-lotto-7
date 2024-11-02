package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        if(winningLotto.getNumbers().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 담청 번호와 중복되면 안됩니다.");
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
