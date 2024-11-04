package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.Lotto;

import java.util.List;

public class LottoService {

    private final Lotto lotto;
    private final Bonus bonus;

    public LottoService(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    // 3. 로또 당첨 번호를 입력하는 기능
    public void addWinningNumbers(List<Integer> winningNumbers) {
        lotto.addNumbers(winningNumbers);
    }

    // 4. 로또 보너스 번호를 입력하는 기능
    public void updateBonusNumber(int number) {
        bonus.updateNumber(number);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
