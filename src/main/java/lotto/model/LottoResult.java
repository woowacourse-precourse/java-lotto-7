package lotto.model;

public class LottoResult {
    private int[] rankCounts; // 각 등수의 당첨 횟수 (index 0: 1등, index 1: 2등, ..., index 5: 꽝)
    private final int[] prizeAmounts = {2000000000, 30000000, 1500000, 50000, 5000}; // 각 등수의 상금

    public LottoResult() {
        rankCounts = new int[6]; // 0-5 인덱스: 1등-꽝
    }

    // 각 등수 추가 메서드
    public void addWin(int rank) {
        if (rank < 1 || rank > 6) {
            throw new IllegalArgumentException("[Error] 로또 결과는 1등에서 6등 사이어야 합니다.");
        }
        rankCounts[rank - 1]++; // rank 1에 대해 index 0에 증가
    }

    public long getTotalPrizeAmount() {
        long totalPrize = 0;

        for (int i = 0; i < rankCounts.length; i++) {
            totalPrize += rankCounts[i] * (i < prizeAmounts.length ? prizeAmounts[i] : 0);
        }

        return totalPrize;
    }


    public int[] getRankCounts() {
        return rankCounts;
    }

    public int[] getPrizeAmounts() {
        return prizeAmounts;
    }
}