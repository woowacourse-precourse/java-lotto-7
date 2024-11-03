package lotto.model;

public class LottoResult {
    private int[] rankCounts; // 각 등수의 당첨 횟수 (index 0: 1등, index 1: 2등, ..., index 5: 꽝)

    public LottoResult() {
        this.rankCounts = new int[6]; // 0-5 인덱스: 1등-꽝
    }

    // 각 등수 추가 메서드
    public void addWin(int rank) {
        if (rank < 1 || rank > 6) {
            throw new IllegalArgumentException("Rank must be between 1 and 6.");
        }
        rankCounts[rank - 1]++; // rank 1에 대해 index 0에 증가
    }
}