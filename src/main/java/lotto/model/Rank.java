package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchNumber;
    private final boolean hasBonus;
    private final int prize;

    private Rank(int matchNumber, boolean hasBonus, int prize) {
        this.matchNumber = matchNumber;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank matchLottoRank(int matchNumber, boolean hasBonus) {
        if (matchNumber == 6) {
            return Rank.FIRST;
        }
        if (matchNumber == 5 && hasBonus) {
            return Rank.SECOND;
        }
        if (matchNumber == 5 && !hasBonus) {
            return Rank.THIRD;
        }
        if (matchNumber == 4) {
            return Rank.FOURTH;
        }
        if (matchNumber == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        String bonusText = "";
        if (hasBonus) {
            bonusText = ", 보너스 볼 일치";
        }
        return String.format("%d개 일치%s (%,d원)", matchNumber, bonusText, prize);
    }
}
