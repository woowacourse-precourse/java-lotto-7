package lotto.domain;

public class LottoCommittee {
    static final int LOTTO_PRICE = 1000;
    Answer answer;

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public LottoPrize getLottoPrize(Lotto lotto) {
        int matches = answer.getMatches(lotto);
        int bonus = answer.getBonus(lotto);
        return LottoPrize.getPrize(matches, bonus);
    }
}
