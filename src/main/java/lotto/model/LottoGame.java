package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final LottoPrice lottoPrice;
    private List<Lotto> lottos;
    private int totalPrice;

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
        totalPrice = lottos.stream()
                .mapToInt(lotto -> calculatePrizeAmount(lotto, winningLotto))
                .sum();
    }

    private int calculatePrizeAmount(Lotto lotto, WinningLotto winningLotto) {
        LottoMatching lottoMatching = new LottoMatching(lotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();
        return prize.getPrizeAmount();
    }

    public double calculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(totalPrice, lottoPrice.price());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
