package lotto;

public class LottoState {
    private int bonusCount;
    private int normalCount;

    public LottoState() {
        this.bonusCount = 0;
        this.normalCount = 0;
    }

    public LottoState(int bonusCount, int normalCount) {
        this.bonusCount = bonusCount;
        this.normalCount = normalCount;
    }

    public int getScore() {
        return this.bonusCount + this.normalCount * 10;
    }
}
