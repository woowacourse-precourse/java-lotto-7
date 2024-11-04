package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoView lottoView;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        int purchaseAmount = lottoView.requestPurchaseAmount();
        generateLottos(purchaseAmount);

        lottoView.displayPurchaseLottos(lottos);

        List<Integer> winningNumbers = lottoView.requestWinningNumbers();
        int bonusNumber = lottoView.requestBonusNumber();

        Map<LottoRank, Integer> result = calculateResult(winningNumbers, bonusNumber);
        double earningsRate = calculateEarningsRate(result, purchaseAmount);

        lottoView.displayResults(result, earningsRate);
    }

    private Map<LottoRank, Integer> calculateResult(List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for(LottoRank rank : LottoRank.values()){
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private void generateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LottoPrice.PRICE.getPrice();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(Lotto.generateRandomLotto());
        }
    }

    private double calculateEarningsRate(Map<LottoRank, Integer> resultSummary, int purchaseAmount) {
        int totalPrize = resultSummary.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }


}
