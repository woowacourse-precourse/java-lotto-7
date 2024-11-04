package lotto;

public enum WinningRank {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVEWITHBONUS(5, true, 30000000),
    SIX(6, false, 2000000000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prizeMoney;
    private int matchingLottoNumbers;

    WinningRank(int matchCount, boolean requiresBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prizeMoney = prizeMoney;
        this.matchingLottoNumbers = 0;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void addMatchingLottoNumbers() {
        this.matchingLottoNumbers = this.matchingLottoNumbers + 1;
    }

    public static WinningRank valueOfMatchCount(long matchCount, boolean bonusMatch) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public static void printStatics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningRank value : values()) {
            if (value == FIVEWITHBONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", value.matchCount, formatMoney(value.prizeMoney),
                        value.matchingLottoNumbers);
            }
            if (value != NONE && value != FIVEWITHBONUS) {
                System.out.printf("%d개 일치 (%s원) - %d개%n", value.matchCount, formatMoney(value.prizeMoney),
                        value.matchingLottoNumbers);
            }
        }
    }

    private static String formatMoney(int amount) {
        return String.format("%,d", amount); // 천 단위 콤마 추가
    }
}
