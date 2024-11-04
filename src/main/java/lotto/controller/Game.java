package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {
    private Money money;
    private LottoManager lottoManager;
    private Store store;
    private Comparator comparator;
    private List<Result> lottoResults;
    private Lotto winningNumbers;
    private int bonusNumber;

    public Game() {
        lottoManager = new LottoManager();
        store = new Store();
        comparator = new Comparator();
    }

    public void start() {
        readMoney();
        buyLottos();
        readWinningNumbers();
        drawLottos();
    }

    private void readMoney() {
        OutputView.requestMoney();
        money = new Money(InputView.readMoney());
    }

    private void buyLottos() {
        lottoManager.buyLotto(store, money);
        OutputView.printLottos(lottoManager.getLottos());
    }

    private void readWinningNumbers() {
        OutputView.requestWinningNumbers();
        winningNumbers = InputView.readWinningNumbers();
        OutputView.requestBonusNumber();
        bonusNumber = InputView.readNumber();
    }

    private void drawLottos() {
        lottoResults = comparator.compareLottos(lottoManager.getLottos(), winningNumbers, bonusNumber);
        lottoManager.setResults(lottoResults);
        money.receiveWinningAmount(lottoManager.getWinningAmount());
        OutputView.printStastistics(Result.getStatistics(lottoResults));
        OutputView.printRateOfReturn(money.getRateOfReturn());
    }
}
