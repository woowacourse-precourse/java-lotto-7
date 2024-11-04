package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final LottoPrice lottoPrice;
    private List<Lotto> lottos;
    private int totalPrice;
    private final Map<LottoPrize, Integer> prizeCounts = new HashMap<>();

    public LottoGame(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public void buyLotto() {
        int lottoCount = lottoPrice.calculateLottoCount();
        lottos = publishLotto(lottoCount);
    }

    private List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.generateLotto());
        }
        return lottos;
    }

    public void checkWinningLotto(WinningLotto winningLotto) {
        resetPrizeCounts();
        totalPrice = lottos.stream()
                .mapToInt(lotto -> {
                    int prizeAmount = calculatePrizeAmount(lotto, winningLotto);
                    LottoPrize prize = getPrize(lotto, winningLotto);
                    prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
                    return prizeAmount;
                })
                .sum();
    }

    private int calculatePrizeAmount(Lotto lotto, WinningLotto winningLotto) {
        LottoMatching lottoMatching = new LottoMatching(lotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();
        return prize.getPrizeAmount();
    }

    private LottoPrize getPrize(Lotto lotto, WinningLotto winningLotto) {
        LottoMatching lottoMatching = new LottoMatching(lotto, winningLotto);
        return lottoMatching.getLottoPrize();
    }

    private void resetPrizeCounts() {
        prizeCounts.clear();
    }

    public double calculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(totalPrice, lottoPrice.price());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoPrize, Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
