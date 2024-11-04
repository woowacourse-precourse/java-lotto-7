package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.config.Config;
import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public static final int LOTTO_UNIT_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(Config config) {
        this.inputView = config.getInputView();
        this.outputView = config.getOutputView();
    }

    public void run() {
        int purchaseAmount = calculatePurchaseAmount(inputView.scanPurchasePrice());
        List<Lotto> lottos = generateLottos(purchaseAmount);
        outputView.printLottos(purchaseAmount, lottos);

        Lotto winningNumbers = inputView.scanWinningNumbers();
        int bonusNumber = inputView.scanBonusNumber(winningNumbers);

        Map<PrizeRank, Integer> prizeRankCounts = getPrizeRankCounts(lottos, winningNumbers, bonusNumber);
        double rateOfReturn = getRateOfReturn(prizeRankCounts, purchaseAmount);

        outputView.printPrizeStats(prizeRankCounts, rateOfReturn);
    }

    public int calculatePurchaseAmount(int purchasePrice) {
        return purchasePrice / LOTTO_UNIT_PRICE;
    }

    public List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_SIZE)));
        }
        return lottos;
    }

    public Map<PrizeRank, Integer> getPrizeRankCounts(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> prizeRankCounts = new HashMap<>();
        for (PrizeRank prizeRank : PrizeRank.values()) {
            prizeRankCounts.put(prizeRank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
            PrizeRank prizeRank = PrizeRank.getPrizeRank(matchCount, isBonusMatch);
            prizeRankCounts.put(prizeRank, prizeRankCounts.get(prizeRank) + 1);
        }
        return prizeRankCounts;
    }

    public double getRateOfReturn(Map<PrizeRank, Integer> prizeRankCounts, int purchaseAmount) {
        // 수익률 = 총상금 / 구입금액 * 100
        return getTotalPrizeAmount(prizeRankCounts) / getPurchasePrice(purchaseAmount) * 100;
    }

    public double getTotalPrizeAmount(Map<PrizeRank, Integer> prizeRankCounts) {
        return prizeRankCounts.entrySet().stream()
                // 총상금 = 등수 별 (당첨 매수 * 상금)
                .mapToDouble(entry -> entry.getValue() * entry.getKey().getPrizeAmount())
                .sum();
    }

    public double getPurchasePrice(int purchaseAmount) {
        // 구입금액 = 구입개수 * 로또 구매 금액
        return purchaseAmount * LOTTO_UNIT_PRICE;
    }
}
