package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoProfitRate;
import lotto.domain.LottoResultDetails;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLottoNumber;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {

    public LottoSystem() {

    }

    public void run() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        int lottoQuantity = purchasePrice.getLottoTicketCount();
        Lottos lottos = Lottos.of(lottoQuantity);
        OutputView.displayPurchasedLottoNumbers(lottos);

        WinningLottoNumber winningLottoNumber = inputWinningLottoNumber();
        LottoResultDetails.count(lottos,winningLottoNumber);
        LottoProfitRate lottoProfitRate = LottoProfitRate.of(purchasePrice);
        OutputView.printLottoDetails(lottoProfitRate);
    }

    private static PurchasePrice inputPurchasePrice() {
        try {
            String purchasePrice = InputView.readPurchasePrice();
            return new PurchasePrice(purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchasePrice();
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
