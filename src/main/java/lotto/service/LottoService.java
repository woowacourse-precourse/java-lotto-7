package lotto.service;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoShop;
import lotto.domain.Player;
import lotto.domain.WinningLotto;

public class LottoService {

    private final LottoShop lottoShop;
    private final LottoEvaluator evaluator;
    private final PrizeCalculator prizeCalculator;

    public LottoService(LottoShop lottoShop, LottoEvaluator evaluator, PrizeCalculator prizeCalculator) {
        this.lottoShop = lottoShop;
        this.evaluator = evaluator;
        this.prizeCalculator = prizeCalculator;
    }

    public void buyLotto(Player player, int money) {
        player.addLottoTickets(lottoShop.purchaseLottoTickets(money));
    }

    public Map<LottoRank, Integer> getLottoRankCounts(Player player, WinningLotto winningLotto) {
        return evaluator.evaluateLottoRankCounts(player.getLottoTickets(), winningLotto);
    }

    public int getTotalPrize(Player player, WinningLotto winningLotto) {
        return prizeCalculator.calculateTotalPrize(player.getLottoTickets(), winningLotto);
    }
}
