package lotto.controller;

import static lotto.view.output.OutputView.printPurchasedLottoery;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoShop;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private LottoCount lottoCount;
    private LottoShop lottoShop;
    private Lotto winningLotto;
    private int bonusNumber;

    public void run() {
        prepareMoney(); // 금액 입력받고, 금액만큼 로또 숫자 뽑는거
        purchaseLotteries(lottoCount);
        prepareWinningLotto();
        drawLottery();
//        int lottoPurchase = InputView.inputLottoPurchase();
//        List<Integer> winningNumbers = InputView.inputWinningNumbers();
//        int bonusNumber = InputView.inputBonusNumber();
    }

    private void prepareMoney() {
        OutputView.printPurchasePrice();
        int lottoPurchase = InputView.inputLottoPurchase();
        lottoCount = LottoCount.calculatePurchaseCount(lottoPurchase);
    }

    private void purchaseLotteries(LottoCount lottoCount) {
        lottoShop = LottoShop.buyLotteries(lottoCount);
        showLotteries();
    }

    private void showLotteries() {
        printPurchasedLottoery(lottoShop);
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
        OutputView.printBonusNumber();
        try {
            bonusNumber = InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            drawBonusNumber();
        }

    }

    private void drawLottery() {

    }

}
