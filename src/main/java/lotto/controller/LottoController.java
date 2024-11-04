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
        Long purchaseAmount = getValidatedPurchaseAmount();
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        view.printRottos(lottoStore.getLottos());

        List<Integer> winningLottos = getValidateWinNumbers();
        Integer bonusNumber = getValidatedBonusNumber(winningLottos);

        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottoStore.getLottos(), new Lotto(winningLottos), bonusNumber);
        Map<LottoPrizeInfo, Integer> prizeCounts = lottoPrizeCalculator.getPrizeCounts();
        Double rate = lottoPrizeCalculator.calculateProfitRate(purchaseAmount);

        view.printStatistics(prizeCounts, rate);
    }

    private Long getValidatedPurchaseAmount() {
        while (true) {
            try {
                return InputValidator.validatePurchaseAmount(view.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getValidateWinNumbers() {
        while (true) {
            try {
                return InputValidator.validateWinningLottos(view.inputWinningLottos());
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private Integer getValidatedBonusNumber(List<Integer> winNumbers) {
        while (true) {
            try {
                return InputValidator.validateBonusNumber(view.inputBonusNumber());
            } catch (Exception e) {
                view.printError(e.getMessage());
            }
        }
    }
}
