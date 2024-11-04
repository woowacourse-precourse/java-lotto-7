package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.domain.Lotto;
import lotto.domain.LottoProfitRate;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLottoNumber;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoSystem lottoSystem;

    public LottoController() {
        this.lottoSystem = new LottoSystem();
    }

    public void run() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        Lottos lottos = lottoSystem.generateLottos(purchasePrice);
        OutputView.displayPurchasedLottoNumbers(lottos);

        WinningLottoNumber winningLottoNumber = inputWinningLottoNumber();
        LottoProfitRate lottoProfitRate = lottoSystem.generateLottoResults(lottos, winningLottoNumber, purchasePrice);
        OutputView.displayLottoDetails(lottoProfitRate);
    }

    private static PurchasePrice inputPurchasePrice() {
        while (true) {
            try {
                String purchasePrice = InputView.readPurchasePrice();
                return new PurchasePrice(purchasePrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningLottoNumber inputWinningLottoNumber() {
        Lotto winningNumber = readWinningNumber();
        String bonusNumber = readBonusNumber(winningNumber);
        return new WinningLottoNumber(winningNumber, bonusNumber);
    }

    private static Lotto readWinningNumber() {
        while (true) {
            try {
                String winningNumber = InputView.readWinningNumber();
                return Parser.parseWinningNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                String bonusNumber = InputView.readBonusNumber();
                Parser.parseBonusNumber(bonusNumber, winningNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
