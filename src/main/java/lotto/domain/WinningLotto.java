package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {
    Map<Lotto, Integer> winningLottoWithBonusNumber = new HashMap<>();

    public Map<Lotto, Integer> getWinningLotto() {
        return winningLottoWithBonusNumber;
    }

    public void setWinningLotto(Map<Lotto, Integer> winningLotto) {
        this.winningLottoWithBonusNumber = winningLotto;
    }
}
