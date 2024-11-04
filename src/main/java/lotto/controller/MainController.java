package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoBundle;
import lotto.model.LottoRanks;
import lotto.model.Wallet;
import lotto.model.WinningNumbers;
import lotto.view.OutputView;

import static lotto.controller.LottoAnswerGenerator.askBonusNumber;
import static lotto.controller.LottoAnswerGenerator.askWinningNumbers;
import static lotto.controller.LottoReader.computeLottoBundleResult;
import static lotto.controller.LottoStatisticGenerator.makeStatistic;
import static lotto.controller.LottoStatisticGenerator.calculateProfit;
import static lotto.controller.LottoStore.makeWallet;
import static lotto.controller.LottoStore.purchaseLottoBundle;

public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
        OutputView.printPurchaseAmount(myWallet.getAffordableLottoAmount());
        LottoBundle lottoBundle = purchaseLottoBundle(myWallet);
        OutputView.printAllLottosNumbers(lottoBundle);
        WinningNumbers winningNumbers = askWinningNumbers();
        BonusNumber bonusNumber = askBonusNumber(winningNumbers);
        LottoRanks lottoRanks = computeLottoBundleResult(lottoBundle, winningNumbers, bonusNumber);
        makeStatistic(lottoRanks, myWallet);
        calculateProfit(lottoRanks, myWallet);
    }
}
