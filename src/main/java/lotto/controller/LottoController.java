package lotto.controller;

import lotto.enumerate.Rank;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoShop lottoShop;

    public LottoController(InputView inputView, OutputView outputView, LottoShop lottoShop) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoShop = lottoShop;
    }

    public void run() {
        Money purchase = getMoney();

        Lottos lottos = createLottos(purchase);

        printLottoDetails(lottos);

        WinNumber winNumber = createWinNumber();

        Map<Rank, Integer> lottoRank = getLottoRank(lottos, winNumber);

        printResults(lottoRank, purchase.getPrice());
    }

    private Money getMoney() {
        String purchase = inputView.inputPurchase();
        return new Money(purchase);
    }

    private Lottos createLottos(Money money) {
        return lottoShop.buyLottos(money);
    }

    private void printLottoDetails(Lottos lottos) {
        outputView.printBuyLottoCount(lottos.getBuyLottoQuantity());
        outputView.printLottoNumbers(lottos);
    }

    private WinNumber createWinNumber() {
        String winNumbers = inputView.inputWinningNumbers();
        String bonusNumber = inputView.inputBonusNumber();
        return new WinNumber(winNumbers, bonusNumber);
    }

    private Map<Rank, Integer> getLottoRank(Lottos lottos, WinNumber winNumber) {
        return lottos.findLottoRanks(winNumber);
    }

    private void printResults(Map<Rank, Integer> lottoRank, long purchase) {
        outputView.printRank(lottoRank);
        double earningRate = EarningCalculator.calculate(lottoRank, purchase);
        outputView.printEarningRate(earningRate);
    }
}
