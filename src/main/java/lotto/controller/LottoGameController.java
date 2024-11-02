package lotto.controller;

import static lotto.view.output.OutputView.printPurchasedLottoery;

import lotto.domain.LottoCount;
import lotto.domain.LottoShop;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private LottoCount lottoCount;
    private LottoShop lottoShop;

    public void run() {
        prepareMoney(); // 금액 입력받고, 금액만큼 로또 숫자 뽑는거
        purchaseLotteries(lottoCount);
//        drawLotteryNumbers
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

}
