package lotto;

import java.util.List;

import static lotto.Validation.validateMoney;

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

    public double getRateOfReturn() {
        return Math.round((double) (Winning.getTotalMoney() * 100) / (myLotto.getCount() * LOTTO_COST) * 10) / 10.0;
    }

    public void printMyLotto() {
        myLotto.print();
    }
}
