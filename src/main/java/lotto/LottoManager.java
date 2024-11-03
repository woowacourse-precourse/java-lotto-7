package lotto;

import java.util.List;

public class LottoManager {
    List<Lotto> myLotto;
    Lotto winningLotto;
    Integer bonusNumber;

    public LottoManager(List<Lotto> myLotto, Lotto winningLotto, Integer bonusNumber) {
        if (myLotto.isEmpty()) {
            throw new IllegalArgumentException("로또를 구매해야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 볼은 1부터 45까지의 숫자여야 합니다.");
        }
        this.myLotto = myLotto;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> processResult() {

        return null;
    }

    public Double calculateProfitRate() {
        return null;
    }

    public void printWinnigStatistics() {
    }
}


