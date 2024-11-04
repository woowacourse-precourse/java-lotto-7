package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Rank,Integer> results;

    public LottoResult(Map<Rank,Integer> results){
        this.results=results;
    }

    public Map<Rank,Integer> getResults(){
        return results;
    }


    public double calculateEarningsRate(int purchaseAmount){

        int totalPrize = 0;

        for(Map.Entry<Rank,Integer> entry : results.entrySet()){
            Rank rank = entry.getKey(); // 당첨 순위
            int ticketCount = entry.getValue(); // 해당 순위의 티켓 수

            totalPrize +=rank.getPrize() * ticketCount;
        }

        double earningsRate = (double) totalPrize / purchaseAmount*100;

        return earningsRate;
    }


}
