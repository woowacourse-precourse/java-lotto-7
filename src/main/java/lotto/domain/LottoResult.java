package lotto.domain;

import java.util.Map;

import static lotto.service.ValidationService.validatePurchaseAmount;

public class LottoResult {
    private final Map<Rank,Integer> results;

    public LottoResult(Map<Rank,Integer> results){
        this.results=results;
    }

    public Map<Rank,Integer> getResults(){
        return results;
    }


    public double calculateEarningsRate(int purchaseAmount) {
        // 총 상금
        int totalPrize = 0;

        // 당첨 결과를 순회하며 총 상금 계산
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey(); // 당첨 순위
            int ticketCount = entry.getValue(); // 해당 순위의 티켓 수

            totalPrize += rank.getPrize() * ticketCount; // 상금 합산
        }

        // 수익률 계산
        double earningsRate = (double) totalPrize / purchaseAmount * 100;

        // 소수점 둘째 자리에서 반올림
        return Math.round(earningsRate * 10.0) / 10.0; // 소수점 첫째 자리까지 반올림
    }




}
