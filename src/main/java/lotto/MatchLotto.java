package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MatchLotto {
    private final int totalLottoPrice;
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final LottoNumbers lottoNumbers;

    public MatchLotto(int totalLottoPrice, List<Integer> winningNumber, int bonusNumber, LottoNumbers lottoNumbers) {
        this.totalLottoPrice = totalLottoPrice;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottoNumbers = lottoNumbers;
    }

    private Map<Rank, Integer> getTotalResult() {
        Map<Rank, Integer> rankCountMap = new TreeMap<>(Comparator.reverseOrder());
        for(Rank rank:Rank.values()){
            rankCountMap.put(rank, 0);
        }
        for(Lotto lotto:lottoNumbers.getLottos()){
            int matchCount = lotto.matchWinningNumber(winningNumber);
            boolean bonusMatch = lotto.matchBonusNumber(bonusNumber);
            if(matchCount >= 3) {
                Rank rank = Rank.fromValue(matchCount, bonusMatch);
                rankCountMap.put(rank, rankCountMap.get(rank) + 1);
            }
        }
        return rankCountMap;
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for(Lotto lotto:lottoNumbers.getLottos()){
            int matchCount = lotto.matchWinningNumber(winningNumber);
            boolean bonusMatch = lotto.matchBonusNumber(bonusNumber);
            if(matchCount >= 3) {
                totalPrizeMoney += Rank.fromValue(matchCount, bonusMatch).getPrize();
            }
        }
        return totalPrizeMoney;
    }

    private BigDecimal getProfitRate() {
        BigDecimal profitRate = new BigDecimal(Double.toString(((double)getTotalPrizeMoney() / (double)totalLottoPrice) * 100));
        return profitRate.setScale(1, RoundingMode.HALF_UP);
    }

    private void printRankResult(Rank rank, int count) {
        NumberFormat format = NumberFormat.getInstance();
        if(rank.getMatchCount() == 5 && rank.getBonusMatch()){
            String output = String.format("%d개 일치, 보너스 볼 일치 (%s)원 - %d개", rank.getMatchCount(), format.format(rank.getPrize()), count);
            System.out.println(output);
        }
        if(!rank.getBonusMatch()){
            String output = String.format("%d개 일치 (%s)원 - %d개", rank.getMatchCount(), format.format(rank.getPrize()), count);
            System.out.println(output);
        }
    }

    public void printTotalResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Rank, Integer> entry : getTotalResult().entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            printRankResult(rank, count);
        }
        System.out.println("총 수익률은 " + getProfitRate() + "%입니다.");
    }
}
