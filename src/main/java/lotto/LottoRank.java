package lotto;

public enum LottoRank {
    FIFTH(5000),    // 3개 일치
    FOURTH(50000),  // 4개 일치
    THIRD(1500000), // 5개 일치
    SECOND(30000000), // 5개 일치, 보너스 볼 일치
    FIRST(2000000000); // 6개 일치

    private final int prizeAmount; // 당첨 금액
    private int count; // 당첨 개수

    LottoRank(int prizeAmount) {
        this.prizeAmount = prizeAmount;
        this.count = 0; // 초기화
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void resetCount() {
        count = 0;
    }
}
