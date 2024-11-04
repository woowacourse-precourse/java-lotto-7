package lotto.model;

import lotto.constants.Ranking;

import java.util.EnumMap;
import java.util.Map;

public class Customer {

    private int lottoTickets = 0;
    private Map<Ranking, Integer> lottoResults = new EnumMap<>(Ranking.class);

    public void buyLottoTickets(int money) {
        lottoTickets += money / 1000;
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

    public void initializeRankingResults() {
        for (Ranking ranking : Ranking.values()) {
            lottoResults.put(ranking, 0);
        }
    }

    public void updateLottoRanking(Ranking ranking) {
        lottoResults.put(ranking, lottoResults.get(ranking) + 1);
    }

    public Map<Ranking, Integer> getLottoResults() {
        return lottoResults;
    }

    public double getWinningsYield(int clientMoney) {
        double yield = ((double) clientMoney / getResultSum()) * 100.0;
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
