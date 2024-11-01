package lotto.model;

import java.util.List;

// UserLotto와 Lotto를 이용하여 유저의 복권 정보를 비교하고 통계하는 메서드들 모음
public class LottoModel {
    private int bonusNumber;
    private Lotto winningNumbers;
    private UserLotto userLotto;

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setUserLotto(int numberOfLotto) {
        userLotto = new UserLotto(numberOfLotto);
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
