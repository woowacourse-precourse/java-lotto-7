package lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.Validation.validateMoney;
import static lotto.Validation.validateWinningNumber;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private final MyLotto myLotto;

    public LottoGame(String money) {
        validateMoney(money);
        int lottoCount = Integer.parseInt(money) / LOTTO_COST;
        this.myLotto = new MyLotto(lottoCount);
    }

    public void matchNumbers(List<Integer> winningNumbers, int bonusNumber) {
        myLotto.matchNumbers(winningNumbers, bonusNumber);
    }

    public void printMyLotto() {
        myLotto.print();
    }
}
