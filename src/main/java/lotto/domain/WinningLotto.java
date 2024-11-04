package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Integer> getImmutableWinningNumbers() {
        return winningLotto.getImmutableNumbers();
    }

    public BonusNumber getImmutableBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getImmutableNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
