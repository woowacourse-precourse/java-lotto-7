package lotto.model;

import lotto.constants.Ranking;
import lotto.constants.lottoType.CalculateType;
import lotto.constants.lottoType.LottoType;

import java.util.EnumMap;
import java.util.Map;

public class Customer {

    private int lottoTickets = LottoType.ZERO_TICKET.getValue();
    private final Map<Ranking, Integer> lottoResults = new EnumMap<>(Ranking.class);

    public void buyLottoTickets(int clientMoney) {
        lottoTickets += clientMoney / LottoType.LOTTO_PRICE.getValue();
    }

    public void initializeRankingResults() {
        for (Ranking ranking : Ranking.values()) {
            lottoResults.put(ranking, LottoType.LOTTO_INIT_RANK.getValue());
        }
    }

    public void updateLottoRanking(Ranking ranking) {
        lottoResults.put(ranking, lottoResults.get(ranking) + LottoType.RANK_INCREMENT_VALUE.getValue());
    }

    public double getWinningsYield(int clientMoney) {
        if (getResultSum() == CalculateType.NO_WINNINGS_MONEY.getIntValue()) {
            return CalculateType.NO_WINNINGS_MONEY.getIntValue();
        }
        double yield = ((double) getResultSum() / clientMoney) * CalculateType.PERCENT_100.getValue();
        return Math.round(yield * CalculateType.ROUNDING_SCALE.getIntValue()) / CalculateType.ROUNDING_DIVISOR.getValue();
    }

    public long getResultSum() {
        long sum = LottoType.ZERO_MONEY.getValue();
        for (Ranking ranking : lottoResults.keySet()) {
            sum += (long) ranking.getWinnings() * lottoResults.get(ranking);
        }
        return sum;
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

    public Map<Ranking, Integer> getLottoResults() {
        return lottoResults;
    }

}
