package lotto;

public class LottoState {
    private int bonusCount;
    private int normalCount;

    public LottoState() {
        this.bonusCount = 0;
        this.normalCount = 0;
    }

    public int getScore() {
        return this.bonusCount + this.normalCount * 10;
    }
}
