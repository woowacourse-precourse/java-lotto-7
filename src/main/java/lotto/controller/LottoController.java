package lotto.controller;

import java.util.Map;
import lotto.model.dto.LottoNumbers;
import lotto.model.dto.ResultStatistics;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.model.person.LottoBuyer;
import lotto.model.person.LottoSeller;
import lotto.model.result.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoSeller lottoSeller;
    private final LottoBuyer lottoBuyer;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoSeller = new LottoSeller();
        this.lottoBuyer = new LottoBuyer();
    }

    public void play() {
        purchaseAndPrintLottos();
        final WinningLotto winningLotto = generateWinningLotto();
        printResult(winningLotto);
    }

    private void buyLotto() {
        while (true) {
            try {
                final int money = enterPurchaseAmount();
                lottoBuyer.buyLotto(money, lottoSeller);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int enterPurchaseAmount() {
        return inputView.inputMoney();
    }

    private void printBuyingLottos() {
        outputView.printLottoCount(lottoBuyer.getLottoCount());
        final LottoNumbers lottoNumbers = new LottoNumbers(lottoBuyer.getLottos());
        outputView.printLottoNumbers(lottoNumbers);
    }

    private void purchaseAndPrintLottos() {
        buyLotto();
        printBuyingLottos();
    }

    private WinningLotto generateWinningLotto() {
        while (true) {
            try {
                final Lotto lotto = enterWinningLotto();
                final BonusNumber bonusNumber = enterBonusNumber();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto enterWinningLotto() {
        return new Lotto(inputView.inputLottoNumber());
    }

    private BonusNumber enterBonusNumber() {
        return new BonusNumber(inputView.inputBonusNumber());
    }

    private void printResult(final WinningLotto winningLotto) {
        printStatistics(winningLotto);
        printProfitRate();
    }

    private void printStatistics(final WinningLotto winningLotto) {
        final Map<Rank, Integer> result = lottoBuyer.checkWinningDegree(winningLotto);
        ResultStatistics resultStatistics = new ResultStatistics(result);
        outputView.printLottoResult(resultStatistics);
    }

    private void printProfitRate() {
        double profit = lottoBuyer.checkProfitRate();
        outputView.printProfit(profit);
    }
}
