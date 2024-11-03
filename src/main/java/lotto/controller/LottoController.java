package lotto.controller;

import lotto.enums.OutputMessage;
import lotto.enums.WinningStatistics;
import lotto.service.LottoService;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public Lotto[] purchaseLotto() {
        Money money;
        try {
            money = new Money(inputView.getPurchasedMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }

        System.out.printf(OutputMessage.NOTICE_PURCHASE_COUNT.getMessage(), money.getPurchaseAmount() / 1000);
        Lotto[] purchasedLotto = lottoService.issueLotto(money);
        showPurchaseLotto(purchasedLotto);

        return purchasedLotto;
    }

    private void showPurchaseLotto(Lotto[] purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public Lotto setWinningNumber() {
        Lotto lotto;
        try {
            lotto = new Lotto(inputView.getWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumber();
        }
        lotto = setBonusNumber(lotto);
        return lotto;
    }

    public Lotto setBonusNumber(Lotto lotto) {
        try {
            lotto.addBonusNumber(inputView.getBonusNumber());
            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber(lotto);
        }
    }

    public void checkLottoStats(Lotto[] purchasedLotto, Lotto winningLotto) {
        lottoService.countMatchingNumbers(purchasedLotto, winningLotto);
        System.out.println(OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        List<WinningStatistics> stats = Arrays.asList(WinningStatistics.values());
        stats.sort(Collections.reverseOrder());

        for (WinningStatistics stat : stats) {
            System.out.printf(stat.getDescription(), stat.getCount());
        }

        double profitRate = lottoService.calculateProfitRate();
        System.out.printf(OutputMessage.PROFIT_RATE_MESSAGE.getMessage(), profitRate);
    }
}
