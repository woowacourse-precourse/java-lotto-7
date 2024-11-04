package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Ranking,Integer> rankingResult;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.rankingResult=new EnumMap<>(Ranking.class);

        for(Ranking ranking:Ranking.values()){
            rankingResult.put(ranking,0);
        }

        calculateResults(lottos, winningLotto);
    }

    private void calculateResults(List<Lotto> lottos, WinningLotto winningLotto) {
        for(Lotto lotto:lottos){
            Ranking ranking=calculateRanking(lotto,winningLotto);
            rankingResult.put(ranking,rankingResult.get(ranking)+1);
        }
    }

    private Ranking calculateRanking(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> lottoNumbers=lotto.getNumbers();
        List<Integer> winningNumbers=winningLotto.getNumbers();

        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = lottoNumbers.contains(winningLotto.getBonusNumber());

        return Ranking.getRanking((int) matchCount, matchBonus);
    }

    public int getCountByRank(Ranking ranking) {
        return rankingResult.getOrDefault(ranking,0);
    }

    public double calculateRate(Money money) {
        long totalPrize = rankingResult.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        return (totalPrize * 100.0) / money.getMoney();
    }
}
