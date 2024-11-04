package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.service.LottoGameService;
import lotto.validator.LottoPurchaseValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        LottoPurchase lottoPurchase = inputPurchaseAmount();
        List<Lotto> purchasedLotto = lottoGameService.generateLottoTickets(lottoPurchase);
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    private LottoPurchase inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                int purchaseAmount = LottoPurchaseValidator.validateAndParse(input);
                return lottoGameService.createLottoPurchase(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
