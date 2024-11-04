package lotto.model;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<PrizeSheet, Integer> result;
    private Integer revenue = 0;

    public LottoResult() {
        result = new EnumMap<>(PrizeSheet.class);
        for (PrizeSheet prize : PrizeSheet.values()) {
            result.put(prize, 0); // 각 등수별 초기화
        }
    }

    public void recordResult(int matchCount, boolean bonusMatch) {
        // matchCount와 bonusMatch를 기반으로 당첨 등수를 찾음
        PrizeSheet rank = findPrizeRank(matchCount, bonusMatch);

        if (rank != null) {
            result.put(rank, result.get(rank) + 1); // 등수별 당첨 횟수 증가
            addRevenue(rank.getPrize()); // 등수별 상금 추가
        }
    }

    private PrizeSheet findPrizeRank(int matchCount, boolean bonusMatch) {
        // matchCount와 bonusMatch 조건에 맞는 PrizeSheet 등수 찾기
        for (PrizeSheet prize : PrizeSheet.values()) {
            if (prize.getMatchCount() == matchCount && prize.isMatchBonus() == bonusMatch) {
                return prize;
            }
        }
        return null;
    }

    public void printResults() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrizeSheet prize : PrizeSheet.values()) {
            String formattedPrize = NumberFormat.getInstance().format(prize.getPrize());
            String output = prize.getMatchCount() + "개 일치";

            // Check if this prize requires bonus ball match information
            if (prize.isMatchBonus()) {
                output += ", 보너스 볼 일치";
            }

            output += " (" + formattedPrize + "원) - " + result.get(prize) + "개";
            System.out.println(output);
        }
    }

    public void addRevenue(Integer addRevenue) {
        revenue += addRevenue;
    }

    public void finalizeLottoResultsProcess(int lottoAmount) {
        if (result.isEmpty()) {
            throw new IllegalStateException("[ERROR] 로또 결과가 존재하지 않아 수익률을 계산할 수 없습니다.");
        }
        printResults();
        double profitRate = computeProfitRate(lottoAmount);
        printProfitRate(profitRate);
    }

    public double computeProfitRate(int lottoAmount) {
        if (revenue == 0) {
            return 0;
        }
        return (double) revenue / (lottoAmount * 1000) * 100;
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}