package lotto.model;

import java.util.Map;
import lotto.constants.PrizeRank;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;
    private final int money;

    public LottoGame(LottoTickets lottoTickets, WinningLotto winningLotto, int money) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = winningLotto;
        this.money = money;
    }

    public LottoGameResult calculateLottoResults() {
        Map<PrizeRank, Integer> prizeResultMap = lottoTickets.getPrizeRankCountMap(winningLotto);

        long prizeMoney = prizeResultMap.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        double profitRate = Math.round((double) prizeMoney / money);

        return new LottoGameResult(prizeResultMap, profitRate);
    }
}
