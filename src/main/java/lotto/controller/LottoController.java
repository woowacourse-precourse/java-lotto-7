package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoPrize;
import lotto.util.BonusNumberValidator;
import lotto.model.GenerateLotto;
import lotto.util.PurchaseValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            OutputView.printPurchaseAmountMsg();
            int purchaseAmount = InputView.getPurchaseAmount();
            PurchaseValidator.validatePurchase(purchaseAmount);

            int lottosCount = purchaseAmount / 1000;
            OutputView.printLottoCount(lottosCount);

            List<Lotto> lottos = GenerateLotto.generateLottos(lottosCount);
            OutputView.printLottos(lottos);

            OutputView.printWinnerLotto();
            List<Integer> winningLotto = InputView.getWinningLotto();

            OutputView.printBonusNumber();
            int bonusNumber = InputView.getBonusNumber();
            BonusNumberValidator.validate(bonusNumber, winningLotto);

            Map<LottoPrize, Integer> prizeCount = new HashMap<>();
            int totalPrize = 0;

            for (LottoPrize prize : LottoPrize.values()) {
                prizeCount.put(prize, 0);
            }

            for (Lotto lotto : lottos) {
                int matchCount = (int) lotto.getNumbers().stream()
                        .filter(winningLotto::contains)
                        .count();
                boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
                LottoPrize lottoPrize = LottoPrize.getLottoPrize(matchCount, bonusMatch);

                prizeCount.put(lottoPrize, prizeCount.get(lottoPrize) + 1);
                totalPrize += lottoPrize.getPrize();
            }

            double profit = ((double) totalPrize / purchaseAmount) * 100;
            OutputView.printMatchResult(prizeCount);
            OutputView.printProfit(profit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}