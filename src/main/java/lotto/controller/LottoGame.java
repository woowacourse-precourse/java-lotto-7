package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRanking;
import lotto.domain.ReturnMoneyRate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private int money;

    public void initMoney() {
        money = InputView.getMoney();
        issueLotto(money);
    }

    private void issueLotto(int money) {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> issuedLottos = lottoIssuer.generateLottos(money);
        OutputView.displayIssuedLotto(issuedLottos);

        initWinningLotto(issuedLottos);
    }

    private void initWinningLotto(List<Lotto> issuedLottos) {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        calculateLotto(issuedLottos, winningNumbers, bonusNumber);
    }

    private void calculateLotto(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoRanking lottoRanking = new LottoRanking();
        Map<String, Integer> result = lottoRanking.calculateRank(issuedLottos, winningNumbers, bonusNumber);

        OutputView.displayResult(result);

        calculateReturnMoneyRate(result);
    }

    private void calculateReturnMoneyRate(Map<String, Integer> result) {
        ReturnMoneyRate returnMoneyRate = new ReturnMoneyRate();
        int sum = returnMoneyRate.calculateSum(result);
        int moneyRate = returnMoneyRate.calculateRate(sum, money);

        OutputView.displayMoneyRate(moneyRate);
    }
}
