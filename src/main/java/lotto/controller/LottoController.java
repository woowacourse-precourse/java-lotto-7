package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.OutputviewFormatter;

public class LottoController {
    public static void run() {
        LottoService lottoService = new LottoService();
        final Money money = requestPurchaseMoneyAmount();

        Lottos lottos = lottoService.generateLottos(money.getPurchasableLottoCount());
        OutputView.printPurchasedLottos(money.getPurchasableLottoCount(), OutputviewFormatter.formatLottoNumbers(lottos));
    }

    private static Money requestPurchaseMoneyAmount() {
        try {
            OutputView.printRequestPurchaseMoneyAmount();
            int purchaseMoneyAmount = InputView.readNumber();
            return new Money(purchaseMoneyAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestPurchaseMoneyAmount();
        }
    }
}
