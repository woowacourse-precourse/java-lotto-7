package controller;

import domain.FindWinningLotto;
import domain.LottoCollection;
import domain.WinningNumbers;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        int moneyToBuyLotto = InputView.moneyToBuyLotto();
        int countOfLotto = OutputView.countBuyingLotto(moneyToBuyLotto);
        List<List<Integer>> lottoCollection = LottoCollection.generateLottos(countOfLotto);
        OutputView.printLottoCollection(lottoCollection);
        String winningNumber = InputView.winningNumber();
        List<Integer> winningNumberCollection = WinningNumbers.generateWinningNumbers(winningNumber);
        int bonusNumber = InputView.bonusNumber();
        FindWinningLotto.LottoRank.findWinningLotto(lottoCollection, winningNumberCollection, bonusNumber);
        OutputView.printResultStatisticMessage();
        OutputView.printResultOfStatistic();
        OutputView.printRateOfReturn(moneyToBuyLotto);
    }
}
