package lotto.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfitCalculator {
    private Map<LottoRank, Integer> rankCounts;
    double profitRate;
    int purchasePrice;

    private void initializeRankCount() {
        rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    private LottoRank chooseLottoRank(List<Integer> numbers, List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusBallNumber){
        Set<Integer> numberSet = new HashSet<>(numbers);
        numberSet.retainAll(winningNumbers);

        int matchCount = numberSet.size();
        boolean hasBonusNumber=false;
        if(!numberSet.contains(bonusBallNumber) && numbers.contains(bonusBallNumber)) hasBonusNumber= true;
        LottoRank lottoRank = LottoRank.getRank(matchCount, hasBonusNumber);
        return lottoRank;
    }

    public void calculateRankCount(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusBallNumber){
        initializeRankCount();
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            LottoRank lottoRank = chooseLottoRank(numbers, lottoTickets, winningNumbers, bonusBallNumber);
            rankCounts.put(lottoRank, rankCounts.get(lottoRank)+1);
        }
    }

    public void calculateProfit(){
        System.out.println(purchasePrice);
        int profitPrice=0;
        for (Map.Entry<LottoRank, Integer> rankCount : rankCounts.entrySet()) {
            LottoRank lottoRank = rankCount.getKey();
            int count = rankCount.getValue();
            int lottoPrice = lottoRank.getPrize();
            profitPrice += lottoPrice*count;
        }
        profitRate = (double)profitPrice/purchasePrice*100;
    }

    public void settingPurchasePrice(int purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
