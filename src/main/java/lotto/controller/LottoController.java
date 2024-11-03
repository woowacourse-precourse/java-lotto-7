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
        Long purchaseAmount = InputValidator.validatePurchaseAmount(view.inputPurchaseAmount());
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        List<Lotto> lottos = lottoStore.getLottos();
        view.printRottos(lottos);

        List<Integer> winningLottos = InputValidator.validateWinningLottos(view.inputLottos());
        Integer bonusNumber = InputValidator.validateBonusNumber(view.inputBonus());
        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottos, new Lotto(winningLottos), bonusNumber);
        Map<LottoPrizeInfo, Integer> prizeCounts = lottoPrizeCalculator.getPrizeCounts();
        Double rate = lottoPrizeCalculator.calculateProfitRate(purchaseAmount);
        view.printStatistics(prizeCounts, rate);
    }
}
