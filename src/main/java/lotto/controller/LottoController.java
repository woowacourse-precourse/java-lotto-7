package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.controller.inputValidator.BonusNumberValidator;
import lotto.controller.inputValidator.PurchaseAmountValidator;
import lotto.controller.inputValidator.WinningNumbersValidator;
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
            LottoStore lottoStore = createLottoStore(purchaseAmount);
            List<Integer> winningNumbers = getValidatedWinningNumbers();
            Integer bonusNumber = getValidatedBonusNumber(winningNumbers);
            calculateStatistics(lottoStore, winningNumbers, bonusNumber, purchaseAmount);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }

    private LottoStore createLottoStore(Long purchaseAmount) {
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        view.printRottos(lottoStore.getLottos());
        return lottoStore;
    }

    private void calculateStatistics(LottoStore lottoStore, List<Integer> winningNumbers, Integer bonusNumber, Long purchaseAmount) {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(lottoStore.getLottos(), new Lotto(winningNumbers), bonusNumber);
        Map<LottoPrizeInfo, Integer> prizeCounts = calculator.getPrizeCounts();
        Double rate = calculator.calculateProfitRate(purchaseAmount);
        view.printStatistics(prizeCounts, rate);
    }

    private Long getValidatedPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountValidator.validate(view.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = view.inputWinningNumbers();
                return WinningNumbersValidator.validate(winningNumbers);
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private Integer getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = view.inputBonusNumber();
                return BonusNumberValidator.validate(bonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }
}
