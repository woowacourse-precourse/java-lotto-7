package lotto.controller;

import java.util.List;
import lotto.service.LottoManager;
import lotto.service.LottoValueProvider;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.money.Budget;
import lotto.service.domain.money.Money;
import lotto.service.domain.numbergenerator.RandomNumberGenerator;
import lotto.service.domain.numbergenerator.WoowaLottoGenerator;
import lotto.service.domain.statistics.StatisticsReport;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final RandomNumberGenerator randomNumberGenerator = new WoowaLottoGenerator();
    private final LottoValueProvider lottoValueProvider = new LottoManager();

    public void run() {
        outputHandler.printPurchasedLotto(makePurchasedLotto());
        outputHandler.printStatisticsReport(makeStatisticsReport());
    }

    private List<Lotto> makePurchasedLotto() {
        return lottoValueProvider.makePurchasedLotto(makePurchaseMoney());
    }

    private StatisticsReport makeStatisticsReport() {
        return lottoValueProvider.makeWinningStatistics(makeWinngNumber(), makeBonusNumber());
    }

    private List<Integer> makeWinngNumber() {
        return inputHandler.makeWinNumber();
    }

    private int makeBonusNumber() {
        return inputHandler.makeBonusNumber();
    }

    private int makePurchaseMoney() {
        return inputHandler.makeMoney();
    }
}
