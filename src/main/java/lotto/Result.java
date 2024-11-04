package lotto;

import java.util.List;

public class Result {
    private final int[] resultCount = new int[5]; // 3개 일치부터 6개 일치까지
    private final int[] prizes = {5000, 50000, 1500000, 30000000, 2000000000};

    public void addResult(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            resultCount[4]++;
        } else if (matchCount == 5 && hasBonus) {
            resultCount[3]++;
        } else if (matchCount == 5) {
            resultCount[2]++;
        } else if (matchCount == 4) {
            resultCount[1]++;
        } else if (matchCount == 3) {
            resultCount[0]++;
        }
    }

    public List<Integer> getResultCounts() {
        return List.of(resultCount[0], resultCount[1], resultCount[2], resultCount[3], resultCount[4]);
    }

    public double calculateProfitRate(int price) {
        int totalPrize = 0;
        for (int i = 0; i < resultCount.length; i++) {
            totalPrize += resultCount[i] * prizes[i];
        }
        return (double) totalPrize / price * 100;
    }
}
