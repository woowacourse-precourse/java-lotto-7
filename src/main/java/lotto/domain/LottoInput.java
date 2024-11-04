package lotto.domain;

public class LottoInput {
    private final Integer cash;
    private final Lotto lotto;
    private final Integer bonus;

    public LottoInput(Integer cash, Lotto lotto, Integer bonus) {
        this.cash = cash;
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Integer getCash() {
        return cash;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonus() {
        return bonus;
    }
}
