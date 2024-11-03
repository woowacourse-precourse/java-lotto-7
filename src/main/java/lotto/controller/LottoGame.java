package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRanking;
import lotto.domain.ReturnMoneyRate;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final MoneyController moneyController;
    private final LottoController lottoController;

    public LottoGame() {
        moneyController = new MoneyController();
        lottoController = new LottoController();
    }

    public void startGame() {
        int money = moneyController.initMoney();
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> issuedLottos = lottoIssuer.generateLottos(money);
        OutputView.displayIssuedLotto(issuedLottos);

        List<Integer> winningNumbers = lottoController.getValidatedWinningNumbers();
        int bonus = lottoController.getValidatedBonusNumber(winningNumbers);
        calculateLottoResult(issuedLottos, winningNumbers, bonus);
    }

    private void calculateLottoResult(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoRanking lottoRanking = new LottoRanking();
        Map<Integer, Integer> result = lottoRanking.calculateRank(issuedLottos, winningNumbers, bonusNumber);

        OutputView.displayResult(result);

        calculateReturnMoneyRate(result);
    }

    private void calculateReturnMoneyRate(Map<Integer, Integer> result) {
        ReturnMoneyRate returnMoneyRate = new ReturnMoneyRate();
        int totalWinnings = returnMoneyRate.calculateSum(result);
        double rateOfReturn = returnMoneyRate.calculateRate(totalWinnings, moneyController.getMoney());

        OutputView.displayMoneyRate(rateOfReturn);
    }
}
