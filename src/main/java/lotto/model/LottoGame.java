package lotto.model;

import java.math.BigInteger;
import java.util.Map;
import lotto.constants.PrizeRank;

public class LottoGame {

    private static final double TO_ROUND = 10.0;
    private static final int HUNDRED = 100;
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

        BigInteger prizeMoney = prizeResultMap.entrySet().stream()
                .map(entry -> BigInteger.valueOf(entry.getKey().getPrizeMoney())
                        .multiply(BigInteger.valueOf(entry.getValue())))
                .reduce(BigInteger.ZERO, BigInteger::add);

        double profitRate = Math.round(TO_ROUND * (HUNDRED * prizeMoney.doubleValue() / money)) / TO_ROUND;

        return new LottoGameResult(prizeResultMap, profitRate);
    }
}
