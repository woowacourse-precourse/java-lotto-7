package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoStore;
import lotto.model.lotto.prize.LottoPrizeCalculator;
import lotto.model.lotto.prize.LottoPrizeInfo;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void run() {
        try {
            Long purchaseAmount = getValidatedPurchaseAmount();
            LottoStore lottoStore = new LottoStore(purchaseAmount);
            view.printRottos(lottoStore.getLottos());

            List<Integer> winningNumbers = getValidatedWinningNumbers();
            Integer bonusNumber = getValidatedBonusNumber(winningNumbers);

            LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottoStore.getLottos(), new Lotto(winningNumbers), bonusNumber);

            Map<LottoPrizeInfo, Integer> prizeCounts = lottoPrizeCalculator.getPrizeCounts();
            Double rate = lottoPrizeCalculator.calculateProfitRate(purchaseAmount);

            view.printStatistics(prizeCounts, rate);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            run();
        }
    }

    private Long getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = view.inputPurchaseAmount();
                return InputValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String input = view.inputWinningLottos();
                return InputValidator.validateWinningLottos(input);
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private Integer getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = view.inputBonusNumber();
                return InputValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }
}
