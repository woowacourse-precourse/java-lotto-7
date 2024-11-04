package lotto.model;

import lotto.constants.Ranking;
import lotto.constants.lottoType.LottoType;

import java.util.EnumMap;
import java.util.Map;

public class Customer {

    private int lottoTickets = 0;
    private Map<Ranking, Integer> lottoResults = new EnumMap<>(Ranking.class);

    public void buyLottoTickets(int money) {
        lottoTickets += money / LottoType.LOTTO_PRICE.getValue();
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

    public void initializeRankingResults() {
        for (Ranking ranking : Ranking.values()) {
            lottoResults.put(ranking, LottoType.LOTTO_INIT_RANK.getValue());
        }
    }

    public void updateLottoRanking(Ranking ranking) {
        lottoResults.put(ranking, lottoResults.get(ranking) + LottoType.LOTTO_RANK_UPDATE_VALUE.getValue());
    }

    public Map<Ranking, Integer> getLottoResults() {
        return lottoResults;
    }

    public double getWinningsYield(int clientMoney) {
        if (getResultSum() == 0) {
            return 0;
        }
        double yield = ((double) getResultSum() / clientMoney) * 100.0;
        return Math.round(yield * 10) / 10.0;
    }

    public long getResultSum() {
        long sum = 0;
        for (Ranking ranking : lottoResults.keySet()) {
            sum += (long) ranking.getWinnings() * lottoResults.get(ranking);
        }
        return sum;
    }

}
