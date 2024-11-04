package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<WinningRank, Integer> rankCounts = new HashMap<>();
    private final int purchaseAmount;

    public LottoStatistics(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
        for (WinningRank value : WinningRank.values()) {
            rankCounts.put(value, 0); //당첨 개수 0으로 초기화
        }
    }

    public void recordResult(int matchCount, boolean bonusMatch){
        WinningRank rank = WinningRank.getRank(matchCount, bonusMatch);
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            if(winningNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public void printStatistics(){
        int totalPrize = 0;
        System.out.println("\n당첨 통계\n---");

        for (WinningRank value : WinningRank.values()) {
            if(value != WinningRank.NO_WINNING){
                //당첨이면
                int count = rankCounts.get(value);
                totalPrize += value.getWinningAmount() * count;
                String message = printFormat(value);
                System.out.printf(message, value.getMatchCount(), value.getWinningAmount(), count);
            }
        }
        double profitRate = (totalPrize / (double)purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private String printFormat(WinningRank value){
        if(value == WinningRank.SECOND_WINNING){
            return "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
        }
        return "%d개 일치 (%,d원) - %d개\n";
    }
}
