package lotto.domain;

import java.util.List;

public class LottoScore {
    private final Lotto lotto;
    private int numberMatch;
    private int bonusMatch;
    private long prize;

    public LottoScore(Lotto lotto) {
        this.lotto = lotto;
        this.numberMatch = 0;
        this.bonusMatch = 0;
        this.prize = 0L;
    }

    public static LottoScore newInstance() {
        Lotto lotto = Lotto.newInstance();
        return new LottoScore(lotto);
    }

    protected List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }

    public int getNumberMatch() {
        return numberMatch;
    }

    public void increaseNumberMatch() {
        numberMatch++;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }

    public void increaseBonusMatch() {
        bonusMatch++;
    }

    public long getPrize() {
        return prize;
    }

    public void setPrize(long prize) {
        this.prize = prize;
    }
}
