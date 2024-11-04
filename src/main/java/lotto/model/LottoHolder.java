package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoHolder {
    private LottoCollection lottoCollection;
    private Map<Ranking, Integer> rankCounts;

    
    public LottoHolder(LottoCollection lottoCollection) {
        this.lottoCollection = lottoCollection;
    }
    
    public List<Lotto> getLottos() {
        return lottoCollection.getLottos();
    }
    
    public void calculateRankCounts(DrawnLotto drawnLotto) {
        rankCounts = new EnumMap<>(Ranking.class);

        for (Lotto lotto : lottoCollection.getLottos()) {
            Ranking ranking = Ranking.calculate(drawnLotto, lotto);
            if (ranking != Ranking.LOSE) {
                rankCounts.put(ranking, rankCounts.getOrDefault(ranking, 0) + 1);
            }
        }
    }
    public Map<Ranking, Integer> getRankCounts() {
        return rankCounts;
    }
    
    public double calculateProfitRate() {
        int totalPrize = 0;
        int purchaseAmount = lottoCollection.getLottos().size() * 1000;
        for (Map.Entry<Ranking, Integer> entry : rankCounts.entrySet()) {
            totalPrize += entry.getKey().award * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}
