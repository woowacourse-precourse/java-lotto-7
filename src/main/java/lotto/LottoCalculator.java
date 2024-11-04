package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottos;
    private final Map<String, Integer> resultCounts;
    private final int purchaseAmount;

    public LottoCalculator(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos, int purchaseAmount) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
        this.resultCounts = initializeResultCounts();
        this.purchaseAmount = purchaseAmount;
    }

    private Map<String, Integer> initializeResultCounts() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("3개 일치 (5,000원)", 0);
        counts.put("4개 일치 (50,000원)", 0);
        counts.put("5개 일치 (1,500,000원)", 0);
        counts.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        counts.put("6개 일치 (2,000,000,000원)", 0);
        return counts;
    }

    public void calculateResults() {
        lottos.forEach(this::processLottoMatch);
        printResults();
        printProfitRate();
    }

    private void processLottoMatch(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto.getNumbers());
        boolean bonusMatch = checkBonusMatch(lotto.getNumbers());

        // 각 조건을 개별 메서드로 분리하여 카운트를 증가시킵니다.
        ifThreeMatches(matchCount);
        ifFourMatches(matchCount);
        ifFiveMatchesWithoutBonus(matchCount, bonusMatch);
        ifFiveMatchesWithBonus(matchCount, bonusMatch);
        ifSixMatches(matchCount);
    }

    private int calculateMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean checkBonusMatch(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void ifThreeMatches(int matchCount) {
        if (matchCount == 3) increaseResultCount("3개 일치 (5,000원)");
    }

    private void ifFourMatches(int matchCount) {
        if (matchCount == 4) increaseResultCount("4개 일치 (50,000원)");
    }

    private void ifFiveMatchesWithoutBonus(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && !bonusMatch) increaseResultCount("5개 일치 (1,500,000원)");
    }

    private void ifFiveMatchesWithBonus(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) increaseResultCount("5개 일치, 보너스 볼 일치 (30,000,000원)");
    }

    private void ifSixMatches(int matchCount) {
        if (matchCount == 6) increaseResultCount("6개 일치 (2,000,000,000원)");
    }

    private void increaseResultCount(String resultKey) {
        resultCounts.put(resultKey, resultCounts.get(resultKey) + 1);
    }

    private void printResults() {
        // 순서대로 출력할 키의 리스트
        String[] keys = {
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        };

        System.out.println("당첨 통계");
        System.out.println("---");
        for (String key : keys) {
            System.out.println(key + " - " + resultCounts.get(key) + "개");
        }
    }

    private void printProfitRate() {
        int totalPrize = calculateTotalPrize();
        double profitRate = ((double) totalPrize / purchaseAmount) * 100; // 수정된 수익률 계산
        profitRate = Math.round(profitRate * 10.0) / 10.0; // 소수점 첫째 자리에서 반올림

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        totalPrize += resultCounts.get("3개 일치 (5,000원)") * 5000;
        totalPrize += resultCounts.get("4개 일치 (50,000원)") * 50000;
        totalPrize += resultCounts.get("5개 일치 (1,500,000원)") * 1500000;
        totalPrize += resultCounts.get("5개 일치, 보너스 볼 일치 (30,000,000원)") * 30000000;
        totalPrize += resultCounts.get("6개 일치 (2,000,000,000원)") * 2000000000;
        return totalPrize;
    }

    public Map<String, Integer> getResultCounts() {
        return resultCounts;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
