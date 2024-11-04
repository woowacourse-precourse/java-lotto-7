package lotto.model;

public class LottoResult {
    private final int[] rankCounts; // 각 등수의 당첨 횟수 (index 0: 1등, index 1: 2등, ..., index 5: 꽝)

    public LottoResult() {
        rankCounts = new int[PrizeAmount.values().length]; // Enum의 길이로 초기화
    }

    // 각 등수 추가 메서드
    public void addWin(int rank) {
        if (rank < 1 || rank > PrizeAmount.values().length) {
            throw new IllegalArgumentException("[Error] 로또 결과는 1등에서 6등 사이어야 합니다.");
        }
        rankCounts[rank - 1]++; // rank 1에 대해 index 0에 증가
    }

    public long getTotalPrizeAmount() {
        long totalPrize = 0;

        for (int i = 0; i < rankCounts.length; i++) {
            totalPrize += (long) rankCounts[i] * PrizeAmount.values()[i].getPrizeAmount();
        }

        return totalPrize;
    }

    public int[] getRankCounts() {
        return rankCounts;
    }
}
