package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Game {
    public void start() {
        OutputView.requestMoney();
        Money money = new Money(InputView.readMoney());
        LottoManager lottoManager = new LottoManager();
        Store store = new Store();
        lottoManager.buyLotto(store, money);
        OutputView.printLottos(lottoManager.getLottos());
        OutputView.requestWinningNumbers();
        Lotto winningNumbers = new Lotto(InputView.readNumbers());
        OutputView.requestBonusNumber();
        int bonusNumber = InputView.readNumber();
        Comparator comparator = new Comparator();
        List<Result> lottoResults =  comparator.compareLottos(lottoManager.getLottos(), winningNumbers, bonusNumber);
        lottoManager.setResults(lottoResults);
        money.receiveWinningAmount(lottoManager.getWinningAmount());
        OutputView.printStastistics();
        OutputView.printRateOfReturn(money.getRateOfReturn());
    }
}
