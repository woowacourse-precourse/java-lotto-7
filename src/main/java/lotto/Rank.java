package lotto;

public enum Rank {
    FIFTH(3,5000, "3개 일치 (%,d원) - %d개"),
    FOURTH(4,50000, "4개 일치 (%,d원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (%,d원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    FIRST(6, 2000000000, "6개 일치 (%,d원) - %d개");

    private final int matchCount;
    private final int prize;
    private final String format;


    Rank(int matchCount, int prize, String format) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.format = format;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus){
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getFormat() {
        return format;
    }

    public String formatOutput(long count) {
        return String.format(format, prize, count);
    }
}
