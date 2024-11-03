package lotto;

public enum LottoRank {
    THREE_MATCH(3, 5_000, "%d개 일치 (%,d원) - %d개"),
    FOUR_MATCH(4, 50_000, "%d개 일치 (%,d원) - %d개"),
    FIVE_MATCH(5, 1_500_000, "%d개 일치 (%,d원) - %d개"),
    FIVE_MATCH_BONUS(5, 30_000_000, "%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    SIX_MATCH(6, 2_000_000_000, "%d개 일치 (%,d원) - %d개");

    LottoRank(int matchCount, int prize, String printFormat) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.printFormat = printFormat;
    }

    private final int matchCount;
    private final int prize;
    private final String printFormat;

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrintFormat() {
        return printFormat;
    }

    public static LottoRank getLottoRank(int count, boolean bonus) {
        if (count == 6) {
            return SIX_MATCH;
        }
        if (count == 5 && bonus) {
            return FIVE_MATCH_BONUS;
        }
        if (count == 5) {
            return FIVE_MATCH;
        }
        if (count == 4) {
            return FOUR_MATCH;
        }
        if (count == 3) {
            return THREE_MATCH;
        }
        return null;
    }

}
