package lotto.controller;

import static lotto.view.output.OutputView.printMatchNumber;
import static lotto.view.output.OutputView.printPurchasedLottery;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.validation.BonusNumberValidator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private LottoCount lottoCount;
    private LottoShop lottoShop;
    private Lotto winningLotto;
    private int bonusNumber;

    public void run() {
        prepareMoney();
        purchaseLotteries(lottoCount);
        prepareWinningLotto();
        drawLottery();

    }

    private void prepareMoney() {
        OutputView.printPurchasePrice();
        try {
            long lottoPurchase = InputView.inputLottoPurchase();
            lottoCount = LottoCount.calculatePurchaseCount(lottoPurchase);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            OutputView.printLine();
            prepareMoney();
        }
    }

    private void purchaseLotteries(LottoCount lottoCount) {
        lottoShop = LottoShop.buyLotteries(lottoCount);
        showLotteries();
    }

    private void showLotteries() {
        printPurchasedLottery(lottoShop, lottoCount);
    }

    private void prepareWinningLotto() {
        drawWinningNumbers();
        drawBonusNumber();
    }

    private void drawWinningNumbers() {
        OutputView.printLine();
        OutputView.printWinningNumbers();
        try {
            winningLotto = InputView.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            drawWinningNumbers();
        }
    }

    private void drawBonusNumber() {
        OutputView.printLine();
        OutputView.printBonusNumber();
        try {
            bonusNumber = InputView.inputBonusNumber();
            BonusNumberValidator.validateDuplicate(bonusNumber, winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            drawBonusNumber();
        }
    }

    private void drawLottery() {
        OutputView.printWinningStatics();
        LottoResult lottoResult = new LottoResult(lottoShop, winningLotto, bonusNumber);
        printMatchNumber(lottoResult, bonusNumber);
        OutputView.printTotalProfit(lottoResult, lottoCount);
    }
}
