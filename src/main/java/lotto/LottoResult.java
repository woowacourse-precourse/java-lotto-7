package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> resultMap;
    private final int totalPurchaseAmount;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, int totalPurchaseAmount) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.resultMap = new HashMap<>();
        initializeResultMap();
    }

    private void initializeResultMap() {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public void calculateResults(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            Rank rank = getRank(matchCount, lotto.getNumbers());
            if (rank != Rank.MISS) {
                addResult(rank);
            }
        }
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private Rank getRank(int matchCount, List<Integer> lottoNumbers) {
        if (matchCount == 6) {
            return Rank.FIRST;
        } else if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
            return Rank.SECOND;
        } else if (matchCount == 5) {
            return Rank.THIRD;
        } else if (matchCount == 4) {
            return Rank.FOURTH;
        } else if (matchCount == 3) {
            return Rank.FIFTH;
        } else {
            return Rank.MISS;
        }
    }

    public void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개%n",
                        rank.getMatchCount(), String.format("%,d원", rank.getPrize()), getCount(rank));
            } else if (rank != Rank.MISS) {
                System.out.printf("%d개 일치 (%s) - %d개%n",
                        rank.getMatchCount(), String.format("%,d원", rank.getPrize()), getCount(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateYield());
    }

    private int getCount(Rank rank) {
        return resultMap.getOrDefault(rank, 0);
    }

    public double calculateYield() {
        double totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += getCount(rank) * rank.getPrize();
        }
        if (totalPurchaseAmount == 0) {
            return 0;
        }
        return Math.round((totalPrize / totalPurchaseAmount) * 1000.0) / 10.0;
    }
}