package lotto.model;

public class WinningTicket {
    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningTicket(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningTicket of(String lotto, String bonus) {
        return new WinningTicket(Lotto.from(lotto), LottoNumber.from(bonus));
    }

    public Rank getRank(Lotto other) {
        int count = other.calcMatchCount(lotto);
        boolean hasBonus = other.getNumbers().contains(bonus);
        return Rank.of(count, hasBonus);
    }
}
