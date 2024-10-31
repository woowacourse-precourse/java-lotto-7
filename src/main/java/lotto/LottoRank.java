package lotto;

public enum LottoRank {
    NO_WIN(0), FIFTH_PRIZE(5000), FOURTH_PRIZE(50000), THIRD_PRIZE(1500000), SECOND_PRIZE(30000000), FIRST_PRIZE(2000000000);

    private int prize;
    private int count;
    LottoRank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public void addCount() {
        this.count++;
    }
}
